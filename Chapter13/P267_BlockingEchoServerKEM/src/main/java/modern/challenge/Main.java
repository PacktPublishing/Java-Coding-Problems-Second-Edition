package modern.challenge;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KEM;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {

    private static final int PORT = 5555;
    private static final String IP = "127.0.0.1";

    private static final Map<SocketAddress, SecretKey> receiver = new HashMap<>(1);

    private static SecretKey secretKeySender;

    public static void main(String[] args) 
            throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, 
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        ByteBuffer buffer = ByteBuffer.allocate(44);

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            if (serverSocketChannel.isOpen()) {

                serverSocketChannel.configureBlocking(true);

                serverSocketChannel.bind(new InetSocketAddress(IP, PORT));

                System.out.println("Waiting for connections ...");

                while (true) {
                    try (SocketChannel socketChannel = serverSocketChannel.accept()) {
                        System.out.println("Incoming connection from: " + socketChannel.getRemoteAddress());

                        receiver.put(socketChannel.getRemoteAddress(), null);

                        while (socketChannel.read(buffer) != -1) {

                            if (receiver.get(socketChannel.getRemoteAddress()) == null) {

                                KeyFactory kf = KeyFactory.getInstance("X25519");
                                PublicKey publicKeyReceiver = kf.generatePublic(
                                        new X509EncodedKeySpec(buffer.array()));

                                KEM kemSender = KEM.getInstance("DHKEM");
                                KEM.Encapsulator encorSender = kemSender.newEncapsulator(publicKeyReceiver);
                                KEM.Encapsulated encedSender = encorSender.encapsulate(
                                        0, encorSender.secretSize(), "AES");

                                secretKeySender = encedSender.key();

                                receiver.put(socketChannel.getRemoteAddress(), secretKeySender);

                                socketChannel.write(ByteBuffer.wrap(encedSender.encapsulation()));

                                System.out.println("Secret Key Sender: " + secretKeySender);

                                buffer.clear();
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
                                cipher.init(Cipher.DECRYPT_MODE, secretKeySender);
                                String decMessage = new String(cipher.doFinal(message), Charset.defaultCharset());
                                System.out.println(decMessage);
                                
                                cipher.init(Cipher.ENCRYPT_MODE, secretKeySender);
                                socketChannel.write(ByteBuffer.wrap(
                                        cipher.doFinal("The generated password is: O98S!".getBytes())));
                            }
                        }
                    } catch (IOException ex) {
                        // handle exception
                    }
                }
            } else {
                System.out.println("The server socket channel cannot be opened!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }
}