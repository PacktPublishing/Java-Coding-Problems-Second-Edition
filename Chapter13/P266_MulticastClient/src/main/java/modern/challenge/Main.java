package modern.challenge;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardProtocolFamily;
import java.nio.channels.DatagramChannel;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.MembershipKey;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class Main {

    private static final int PORT = 5555;
    private static final int MAX_PACKET_SIZE = 65507;
    private static final String GROUP = "225.4.5.6";
    private static final String NETWORK_INTERFACE_NAME = "eth17";

    public static void main(String[] args) {

        CharBuffer charBuffer;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder decoder = charset.newDecoder();
        ByteBuffer datetime = ByteBuffer.allocateDirect(MAX_PACKET_SIZE);

        // create a new channel
        try (DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET)) {

            InetAddress group = InetAddress.getByName(GROUP);
            
            // check if the group address is multicast
            if (group.isMulticastAddress()) {
                
                // check if the channel was successfully created
                if (datagramChannel.isOpen()) {

                    // get the network interface used for multicast
                    NetworkInterface networkInterface = NetworkInterface.getByName(NETWORK_INTERFACE_NAME);

                    // set some options
                    datagramChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
                    
                    // bind the channel to the local address                    
                    datagramChannel.bind(new InetSocketAddress(PORT));
                    
                    // join the multicast group and get ready to receive datagrams
                    MembershipKey key = datagramChannel.join(group, networkInterface);

                    // wait for datagrams
                    while (true) {

                        if (key.isValid()) {

                            datagramChannel.receive(datetime);
                            datetime.flip();
                            charBuffer = decoder.decode(datetime);
                            System.out.println(charBuffer.toString());
                            datetime.clear();
                        } else {
                            break;
                        }
                    }
                } else {
                    System.out.println("The channel cannot be opened!");
                }
            } else {
                System.out.println("This is not  multicast address!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }    
    }
}