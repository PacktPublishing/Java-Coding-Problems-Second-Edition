package modern.challenge;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.channels.DatagramChannel;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;

public class Main {

    private static final int SERVER_PORT = 4444;
    private static final String SERVER_IP = "127.0.0.1";  // modify this to your local IP       
    private static final int MAX_SIZE_OF_PACKET = 65507;

    public static void main(String[] args) {

        ByteBuffer echoBuffer = ByteBuffer.allocateDirect(MAX_SIZE_OF_PACKET);

        // create a datagram channel
        try (DatagramChannel dchannel 
                = DatagramChannel.open(StandardProtocolFamily.INET)) {

            // if the channel was successfully opened
            if (dchannel.isOpen()) {

                System.out.println("The echo server is ready!");

                // optionally, configure the server side options
                dchannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
                dchannel.setOption(StandardSocketOptions.SO_SNDBUF, 4 * 1024);

                // bind the channel to local address
                dchannel.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));
                
                System.out.println("Echo server available at: " + dchannel.getLocalAddress());
                System.out.println("Ready to echo ...");

                // sending data packets
                while (true) {

                    SocketAddress clientSocketAddress = dchannel.receive(echoBuffer);

                    echoBuffer.flip();
                    
                    System.out.println("Received " + echoBuffer.limit()
                            + " bytes from " + clientSocketAddress.toString() + "! Echo ...");
                    
                    dchannel.send(echoBuffer, clientSocketAddress);
                    
                    echoBuffer.clear();
                }
            } else {
                System.out.println("The channel is unavailable!");
            }
        } catch (SecurityException | IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }
}