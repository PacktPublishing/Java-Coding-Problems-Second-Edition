package modern.challenge;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Main {

    private static final int SERVER_PORT = 4444;
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {

        ByteBuffer tBuffer = ByteBuffer.allocateDirect(1024);

        // open a brand new server socket channel
        try (ServerSocketChannel serverSC = ServerSocketChannel.open()) {

            // server socket channel was created
            if (serverSC.isOpen()) {

                // configure the blocking mode
                serverSC.configureBlocking(true);
                
                // optionally, configure the server side options
                serverSC.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
                serverSC.setOption(StandardSocketOptions.SO_REUSEADDR, true);
                
                // bind the server socket channel to local address
                serverSC.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));

                // waiting for clients
                System.out.println("Waiting for clients ...");

                // ready to accept incoming connections
                while (true) {
                    try (SocketChannel acceptSC = serverSC.accept()) {
                        System.out.println("New connection: " + acceptSC.getRemoteAddress());

                        // sending data
                        while (acceptSC.read(tBuffer) != -1) {

                            tBuffer.flip();                            

                            acceptSC.write(tBuffer);

                            if (tBuffer.hasRemaining()) {
                                tBuffer.compact();
                            } else {
                                tBuffer.clear();
                            }
                        }
                    } catch (IOException ex) {
                        // handle exception
                    }
                }
            } else {
                System.out.println("Server socket channel unavailable!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }
}