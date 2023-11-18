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

    private static final int SERVER_PORT = 4444;
    
    private final Map<SocketChannel, List<byte[]>> registerTrack = new HashMap<>();
    private final ByteBuffer tBuffer = ByteBuffer.allocate(2 * 1024);

    private void startEchoServer() {        

        // call the open() method for Selector/ServerSocketChannel
        try (Selector selector = Selector.open(); 
                ServerSocketChannel serverSC = ServerSocketChannel.open()) {

            // ServerSocketChannel and Selector successfully opened
            if ((serverSC.isOpen()) && (selector.isOpen())) {

                // configure non-blocking mode
                serverSC.configureBlocking(false);

                // optionally, configure the client side options
                serverSC.setOption(StandardSocketOptions.SO_RCVBUF, 256 * 1024);
                serverSC.setOption(StandardSocketOptions.SO_REUSEADDR, true);

                // bind the server socket channel to the port
                serverSC.bind(new InetSocketAddress(SERVER_PORT));

                // register this channel with the selector
                serverSC.register(selector, SelectionKey.OP_ACCEPT);

                // waiting for clients
                System.out.println("Waiting for clients ...");

                while (true) {
                    // waiting for events
                    selector.select();

                    // the selected keys have something to be processed
                    Iterator itkeys = selector.selectedKeys().iterator();

                    while (itkeys.hasNext()) {
                        SelectionKey selkey = (SelectionKey) itkeys.next();

                        // avoid processing the same key twice
                        itkeys.remove();

                        if (!selkey.isValid()) {
                            continue;
                        }

                        if (selkey.isAcceptable()) {
                            acceptOperation(selkey, selector);
                        } else if (selkey.isReadable()) {
                            this.readOperation(selkey);
                        } else if (selkey.isWritable()) {
                            this.writeOperation(selkey);
                        }
                    }
                }
            } else {
                System.out.println("Cannot open the selector/channel");
            }
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }

    // isAcceptable = true
    private void acceptOperation(SelectionKey selkey, Selector selector) throws IOException {

        ServerSocketChannel serverSC = (ServerSocketChannel) selkey.channel();
        SocketChannel acceptSC = serverSC.accept();
        acceptSC.configureBlocking(false);

        System.out.println("New connection: " + acceptSC.getRemoteAddress());

        // send an welcome message
        acceptSC.write(ByteBuffer.wrap("Hey !\n".getBytes("UTF-8")));

        // register the channel with this selector to support more I/O
        registerTrack.put(acceptSC, new ArrayList<>());
        acceptSC.register(selector, SelectionKey.OP_READ);
    }

    // isReadable = true
    private void readOperation(SelectionKey selkey) {
        
        try {
            SocketChannel socketC = (SocketChannel) selkey.channel();

            tBuffer.clear();

            int byteRead = -1;
            try {
                byteRead = socketC.read(tBuffer);
            } catch (IOException e) {
                System.err.println("Read error!");
                // handle exception
            }

            if (byteRead == -1) {
                this.registerTrack.remove(socketC);
                
                System.out.println("Connection was closed by: " + socketC.getRemoteAddress());
                
                socketC.close();
                selkey.cancel();
                
                return;
            }

            byte[] byteData = new byte[byteRead];
            System.arraycopy(tBuffer.array(), 0, byteData, 0, byteRead);
            System.out.println(new String(byteData, "UTF-8") + " from " + socketC.getRemoteAddress());

            // send the bytes back to client
            doEchoTask(selkey, byteData);
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }

    // isWritable = true
    private void writeOperation(SelectionKey selkey) throws IOException {

        SocketChannel socketC = (SocketChannel) selkey.channel();

        List<byte[]> channelByteData = registerTrack.get(socketC);
        Iterator<byte[]> iter = channelByteData.iterator();

        while (iter.hasNext()) {
            byte[] itb = iter.next();
            iter.remove();
            socketC.write(ByteBuffer.wrap(itb));
        }

        selkey.interestOps(SelectionKey.OP_READ);
    }

    private void doEchoTask(SelectionKey selkey, byte[] dataByte) {
        
        SocketChannel socketC = (SocketChannel) selkey.channel();
        List<byte[]> channelByteData = registerTrack.get(socketC);
        channelByteData.add(dataByte);

        selkey.interestOps(SelectionKey.OP_WRITE);
    }

    public static void main(String[] args) {
        
        Main main = new Main();
        main.startEchoServer();
    }
}