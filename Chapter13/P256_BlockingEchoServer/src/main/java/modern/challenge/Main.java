package modern.challenge;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.channels.DatagramChannel;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;

public class Main {

    private static final int PORT = 5555;
    private static final String IP = "127.0.0.1";  // modify this to your local IP       
    private static final int MAX_PACKET_SIZE = 65507;

    public static void main(String[] args) {

        ByteBuffer echoText = ByteBuffer.allocateDirect(MAX_PACKET_SIZE);

        //create a new datagram channel
        try (DatagramChannel datagramChannel 
                = DatagramChannel.open(StandardProtocolFamily.INET)) {

            // check if it the channel was successfully opened
            if (datagramChannel.isOpen()) {

                System.out.println("Echo server was successfully opened!");

                // set some options
                datagramChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
                datagramChannel.setOption(StandardSocketOptions.SO_SNDBUF, 4 * 1024);

                // bind the channel to local address
                datagramChannel.bind(new InetSocketAddress(IP, PORT));
                
                System.out.println("Echo server was binded on: " + datagramChannel.getLocalAddress());
                System.out.println("Echo server is ready to echo ...");

                // transmitting data packets
                while (true) {

                    SocketAddress clientAddress = datagramChannel.receive(echoText);

                    echoText.flip();
                    
                    System.out.println("I have received " + echoText.limit()
                            + " bytes from " + clientAddress.toString() + "! Sending them back ...");
                    
                    datagramChannel.send(echoText, clientAddress);
                    echoText.clear();
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