package modern.challenge;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.DecapsulateException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KEM;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {

    private static final int PORT = 5555;
    private static final String IP = "127.0.0.1";

    private static PublicKey publicKey;
    private static PrivateKey privateKey;
    private static SecretKey secretKeyReceiver;

    static {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("X25519");
            KeyPair kp = kpg.generateKeyPair();

            publicKey = kp.getPublic();
            privateKey = kp.getPrivate();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) 
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
            IllegalBlockSizeException, BadPaddingException, DecapsulateException {

        ByteBuffer buffer = ByteBuffer.allocate(32);

        try (SocketChannel socketChannel = SocketChannel.open()) {

            if (socketChannel.isOpen()) {

                socketChannel.configureBlocking(true);

                socketChannel.connect(new InetSocketAddress(IP, PORT));

                if (socketChannel.isConnected()) {

                    // transmitting the public key to the sender                    
                    socketChannel.write(ByteBuffer.wrap(publicKey.getEncoded()));

                    while (socketChannel.read(buffer) != -1) {

                        if (secretKeyReceiver == null) {

                            KEM kemReceiver = KEM.getInstance("DHKEM");
                            KEM.Decapsulator decReceiver = kemReceiver.newDecapsulator(privateKey);
                            secretKeyReceiver = decReceiver.decapsulate(
                                    buffer.array(), 0, decReceiver.secretSize(), "AES");

                            System.out.println("Secret Key Receiver: " + secretKeyReceiver);

                            buffer.clear();
                            
                            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
                            cipher.init(Cipher.ENCRYPT_MODE, secretKeyReceiver);
                            socketChannel.write(ByteBuffer.wrap(
                                    cipher.doFinal("My token is: 763".getBytes())));                                                        
                        } else {
                            int position = buffer.position();
                            byte[] message = new byte[position];
                            buffer.flip();
                            buffer.get(message, 0, position);
                            buffer.clear();

                            System.out.println("\nEncrypted message:");
                            System.out.println(new String(message, Charset.defaultCharset()));

                            System.out.println("\nDecrypted message:");
                            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
                            cipher.init(Cipher.DECRYPT_MODE, secretKeyReceiver);
                            String decMessage = new String(cipher.doFinal(message), Charset.defaultCharset());
                            System.out.println(decMessage);
                        }
                    }
                } else {
                    System.out.println("The connection cannot be established!");
                }
            } else {
                System.out.println("The socket channel cannot be opened!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }
}
