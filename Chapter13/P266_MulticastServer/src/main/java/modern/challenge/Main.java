package modern.challenge;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardProtocolFamily;
import java.nio.channels.DatagramChannel;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.util.Date;

public class Main {

    private static final int SERVER_PORT = 4444;
    private static final String MULTICAST_GROUP = "225.4.5.6";
    private static final String MULTICAST_NI_NAME = "ethernet_32775";

    public static void main(String[] args) {

        ByteBuffer dtBuffer;

        // create a channel
        try (DatagramChannel dchannel = DatagramChannel.open(StandardProtocolFamily.INET)) {

            // if the channel was successfully opened
            if (dchannel.isOpen()) {

                // get the multicast network interface
                NetworkInterface mni = NetworkInterface.getByName(MULTICAST_NI_NAME);

                // optionally, configure the server side options
                dchannel.setOption(StandardSocketOptions.IP_MULTICAST_IF, mni);
                dchannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);

                // bind the channel to local address
                dchannel.bind(new InetSocketAddress(SERVER_PORT));
                System.out.println("Server is ready ... sending date-time info soon ...");

                // sending datagrams
                while (true) {

                    // sleep for 10000 ms (10 seconds)
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {}
                    
                    System.out.println("Sending date-time ...");

                    dtBuffer = ByteBuffer.wrap(new Date().toString().getBytes());
                    dchannel.send(dtBuffer, new InetSocketAddress(
                            InetAddress.getByName(MULTICAST_GROUP), SERVER_PORT));
                    dtBuffer.flip();
                }

            } else {
                System.out.println("The channel is unavailable!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}