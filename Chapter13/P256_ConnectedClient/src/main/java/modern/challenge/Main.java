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

    private static final int PORT = 5555;
    private static final String IP = "127.0.0.1"; // modify this accordingly if you want to test remote
    private static final int MAX_PACKET_SIZE = 65507;

    public static void main(String[] args) {

        CharBuffer charBuffer;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder decoder = charset.newDecoder();
        ByteBuffer textToEcho = ByteBuffer.wrap("Echo this: I'm a big and ugly server!".getBytes());
        ByteBuffer echoedText = ByteBuffer.allocateDirect(MAX_PACKET_SIZE);

        // create a new datagram channel
        try (DatagramChannel datagramChannel 
                = DatagramChannel.open(StandardProtocolFamily.INET)) {

            // set some options
            datagramChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
            datagramChannel.setOption(StandardSocketOptions.SO_SNDBUF, 4 * 1024);

            // check if it the channel was successfully opened
            if (datagramChannel.isOpen()) {

                // connect to remote address
                datagramChannel.connect(new InetSocketAddress(IP, PORT));

                // check if it the channel was successfully connected
                if (datagramChannel.isConnected()) {

                    // transmitting data packets
                    int sent = datagramChannel.write(textToEcho);
                    System.out.println("I have successfully sent " + sent + " bytes to the Echo Server!");

                    datagramChannel.read(echoedText);

                    echoedText.flip();
                    
                    charBuffer = decoder.decode(echoedText);
                    System.out.println(charBuffer.toString());
                    
                    echoedText.clear();

                } else {
                    System.out.println("The channel cannot be connected!");
                }
            } else {
                System.out.println("The channel cannot be opened!");
            }
        } catch (SecurityException | IOException ex) {        
            System.err.println(ex);
            // handle exception
        }

    }
}