package modern.challenge;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Main {

    private static final int PORT = 5555;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        // create a new server-socket channel
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            // continue if it was successfully created
            if (serverSocketChannel.isOpen()) {

                // set the blocking mode
                serverSocketChannel.configureBlocking(true);
                
                // set some options
                serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
                serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
                
                // bind the server-socket channel to local address
                serverSocketChannel.bind(new InetSocketAddress(IP, PORT));

                // display a waiting message while ... waiting clients
                System.out.println("Waiting for connections ...");

                // wait for incoming connections
                while (true) {
                    try (SocketChannel socketChannel = serverSocketChannel.accept()) {
                        System.out.println("Incoming connection from: " + socketChannel.getRemoteAddress());

                        // transmitting data
                        while (socketChannel.read(buffer) != -1) {

                            buffer.flip();                            

                            socketChannel.write(buffer);

                            if (buffer.hasRemaining()) {
                                buffer.compact();
                            } else {
                                buffer.clear();
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