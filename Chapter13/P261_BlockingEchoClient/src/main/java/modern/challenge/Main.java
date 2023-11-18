package modern.challenge;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Random;

public class Main {

    private static final int SERVER_PORT = 4444;
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {

        ByteBuffer tBuffer = ByteBuffer.allocateDirect(1024);
        
        ByteBuffer hBuffer = ByteBuffer.wrap("Hey !".getBytes());
        ByteBuffer rBuffer;
        CharBuffer cBuffer;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder chdecoder = charset.newDecoder();

        // create a brand new client socket channel
        try (SocketChannel clientSC = SocketChannel.open()) {

            // client socket channel was created
            if (clientSC.isOpen()) {

                // configure the blocking mode
                clientSC.configureBlocking(true);
                
                // optionally, configure the client side options
                clientSC.setOption(StandardSocketOptions.SO_RCVBUF, 128 * 1024);
                clientSC.setOption(StandardSocketOptions.SO_SNDBUF, 128 * 1024);
                clientSC.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
                clientSC.setOption(StandardSocketOptions.SO_LINGER, 5);
                
                // connect this channel's socket to the proper address
                clientSC.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

                // check the connection availability
                if (clientSC.isConnected()) {

                    // sending data
                    clientSC.write(hBuffer);

                    while (clientSC.read(tBuffer) != -1) {

                        tBuffer.flip();

                        cBuffer = chdecoder.decode(tBuffer);
                        System.out.println(cBuffer.toString());

                        if (tBuffer.hasRemaining()) {
                            tBuffer.compact();
                        } else {
                            tBuffer.clear();
                        }

                        int r = new Random().nextInt(100);
                        if (r == 50) {
                            System.out.println("Number 50 is here so the channel will be closed");
                            break;
                        } else {
                            rBuffer = ByteBuffer.wrap(
                                    "Random number:".concat(String.valueOf(r)).getBytes());
                            clientSC.write(rBuffer);
                        }
                    }
                } else {
                    System.out.println("Connection unavailable!");
                }
            } else {
                System.out.println("Client socket channel unavailable!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }
}