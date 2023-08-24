package modern.challenge;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {

    private static final int PORT = 5555;
    
    private final Map<SocketChannel, List<byte[]>> keepDataTrack = new HashMap<>();
    private final ByteBuffer buffer = ByteBuffer.allocate(2 * 1024);

    private void startEchoServer() {        

        // open Selector and ServerSocketChannel by calling the open() method
        try (Selector selector = Selector.open(); 
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            // check that both of them were successfully opened
            if ((serverSocketChannel.isOpen()) && (selector.isOpen())) {

                // configure non-blocking mode
                serverSocketChannel.configureBlocking(false);

                // set some options
                serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 256 * 1024);
                serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);

                // bind the server socket channel to port
                serverSocketChannel.bind(new InetSocketAddress(PORT));

                // register the current channel with the given selector
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

                // display a waiting message while ... waiting!
                System.out.println("Waiting for connections ...");

                while (true) {
                    // wait for incomming events
                    selector.select();

                    // there is something to process on selected keys
                    Iterator keys = selector.selectedKeys().iterator();

                    while (keys.hasNext()) {
                        SelectionKey key = (SelectionKey) keys.next();

                        // prevent the same key from coming up again
                        keys.remove();

                        if (!key.isValid()) {
                            continue;
                        }

                        if (key.isAcceptable()) {
                            acceptOP(key, selector);
                        } else if (key.isReadable()) {
                            this.readOP(key);
                        } else if (key.isWritable()) {
                            this.writeOP(key);
                        }
                    }
                }
            } else {
                System.out.println("The server socket channel or selector cannot be opened!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }

    // isAcceptable returned true
    private void acceptOP(SelectionKey key, Selector selector) throws IOException {

        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverChannel.accept();
        socketChannel.configureBlocking(false);

        System.out.println("Incoming connection from: " + socketChannel.getRemoteAddress());

        // write an welcome message
        socketChannel.write(ByteBuffer.wrap("Hello!\n".getBytes("UTF-8")));

        // register channel with selector for further I/O
        keepDataTrack.put(socketChannel, new ArrayList<>());
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    //isReadable returned true
    private void readOP(SelectionKey key) {
        
        try {
            SocketChannel socketChannel = (SocketChannel) key.channel();

            buffer.clear();

            int numRead = -1;
            try {
                numRead = socketChannel.read(buffer);
            } catch (IOException e) {
                System.err.println("Cannot read error!");
                // handle exception
            }

            if (numRead == -1) {
                this.keepDataTrack.remove(socketChannel);
                System.out.println("Connection closed by: " + socketChannel.getRemoteAddress());
                socketChannel.close();
                key.cancel();
                return;
            }

            byte[] data = new byte[numRead];
            System.arraycopy(buffer.array(), 0, data, 0, numRead);
            System.out.println(new String(data, "UTF-8") 
                    + " from " + socketChannel.getRemoteAddress());

            // write back to client
            doEchoJob(key, data);
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }

    // isWritable returned true
    private void writeOP(SelectionKey key) throws IOException {

        SocketChannel socketChannel = (SocketChannel) key.channel();

        List<byte[]> channelData = keepDataTrack.get(socketChannel);
        Iterator<byte[]> its = channelData.iterator();

        while (its.hasNext()) {
            byte[] it = its.next();
            its.remove();
            socketChannel.write(ByteBuffer.wrap(it));
        }

        key.interestOps(SelectionKey.OP_READ);
    }

    private void doEchoJob(SelectionKey key, byte[] data) {
        
        SocketChannel socketChannel = (SocketChannel) key.channel();
        List<byte[]> channelData = keepDataTrack.get(socketChannel);
        channelData.add(data);

        key.interestOps(SelectionKey.OP_WRITE);
    }

    public static void main(String[] args) {
        
        Main main = new Main();
        main.startEchoServer();
    }
}