package modern.challenge;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.channels.DatagramChannel;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class Main {
    
    private static final int SERVER_PORT = 4444;
    private static final String SERVER_IP = "127.0.0.1"; // modify this accordingly if you want to test remote
    private static final int MAX_SIZE_OF_PACKET = 65507;

    public static void main(String[] args) throws InterruptedException {

        CharBuffer cBuffer;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder chdecoder = charset.newDecoder();
        ByteBuffer bufferToEcho = ByteBuffer.wrap(
                "Echo: I'm a great server!".getBytes());
        ByteBuffer echoedBuffer = ByteBuffer.allocateDirect(MAX_SIZE_OF_PACKET);

        // create a datagram channel
        try (DatagramChannel dchannel 
                = DatagramChannel.open(StandardProtocolFamily.INET)) {

            // if the channel was successfully opened
            if (dchannel.isOpen()) {

                // optionally, configure the client side options
                dchannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
                dchannel.setOption(StandardSocketOptions.SO_SNDBUF, 4 * 1024);

                // sending data packets
                int sentBytes = dchannel.send(bufferToEcho, new InetSocketAddress(SERVER_IP, SERVER_PORT));
                
                System.out.println("Sent " + sentBytes + " bytes to the server");

                dchannel.receive(echoedBuffer);

                // hack to wait for the server to echo
                Thread.sleep(5000); 
                
                echoedBuffer.flip();
                
                cBuffer = chdecoder.decode(echoedBuffer);
                System.out.println(cBuffer.toString());
                echoedBuffer.clear();

            } else {
                System.out.println("Cannot open the channel");
            }
        } catch (SecurityException | IOException ex) {            
            System.err.println(ex);
            // handle exception
        }
    }
}