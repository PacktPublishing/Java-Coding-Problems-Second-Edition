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

    private static final int SERVER_PORT = 4444;
    private static final int MAX_SIZE_OF_PACKET = 65507;
    private static final String MULTICAST_GROUP = "225.4.5.6";
    private static final String MULTICAST_NI_NAME = "ethernet_32775";

    public static void main(String[] args) {

        CharBuffer cBuffer;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder chdecoder = charset.newDecoder();
        ByteBuffer dtBuffer = ByteBuffer.allocateDirect(MAX_SIZE_OF_PACKET);

        // create a channel
        try (DatagramChannel dchannel = DatagramChannel.open(StandardProtocolFamily.INET)) {

            InetAddress multigroup = InetAddress.getByName(MULTICAST_GROUP);
            
            // if the group address is multicast
            if (multigroup.isMulticastAddress()) {
                
                // if the channel was successfully open
                if (dchannel.isOpen()) {

                    // get the multicast network interface
                    NetworkInterface mni = NetworkInterface.getByName(MULTICAST_NI_NAME);

                    // optionally, configure the client side options
                    dchannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
                    
                    // bind the channel to remote address                    
                    dchannel.bind(new InetSocketAddress(SERVER_PORT));
                    
                    // join the multicast group and receive datagrams
                    MembershipKey memkey = dchannel.join(multigroup, mni);

                    // wait to receive datagrams
                    while (true) {

                        if (memkey.isValid()) {

                            dchannel.receive(dtBuffer);
                            dtBuffer.flip();
                            cBuffer = chdecoder.decode(dtBuffer);
                            System.out.println(cBuffer.toString());
                            dtBuffer.clear();
                        } else {
                            break;
                        }
                    }
                } else {
                    System.out.println("The channel is unavailable!");
                }
            } else {
                System.out.println("Not a multicast address!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }    
    }
}