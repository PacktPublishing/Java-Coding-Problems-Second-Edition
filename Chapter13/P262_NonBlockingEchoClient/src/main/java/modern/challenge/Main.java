package modern.challenge;

import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {

    private static final int SERVER_PORT = 4444;
    private static final String SERVER_IP = "127.0.0.1";
    private static final int TIMEOUT_SELECTOR = 1_000;
        
    public static void main(String[] args) throws InterruptedException {        

        ByteBuffer tBuffer = ByteBuffer.allocateDirect(2 * 1024);
        ByteBuffer rBuffer;
        CharBuffer cBuffer;

        Charset charset = Charset.defaultCharset();
        CharsetDecoder chdecoder = charset.newDecoder();

        // call the open() for ServerSocketChannel and Selector
        try (Selector selector = Selector.open(); 
                SocketChannel clientSC = SocketChannel.open()) {

            // ServerSocketChannel and Selector successfully opened
            if ((clientSC.isOpen()) && (selector.isOpen())) {

                // configure non-blocking mode
                clientSC.configureBlocking(false);

                // optionally, configure the client side options
                clientSC.setOption(StandardSocketOptions.SO_RCVBUF, 128 * 1024);
                clientSC.setOption(StandardSocketOptions.SO_SNDBUF, 128 * 1024);
                clientSC.setOption(StandardSocketOptions.SO_KEEPALIVE, true);

                // register this channel with the selector
                clientSC.register(selector, SelectionKey.OP_CONNECT);

                // connecting to the remote host
                clientSC.connect(new java.net.InetSocketAddress(SERVER_IP, SERVER_PORT));

                System.out.println("Local host: " + clientSC.getLocalAddress());

                // waiting for the connection
                while (selector.select(TIMEOUT_SELECTOR) > 0) {

                    // get the keys
                    Set selkeys = selector.selectedKeys();
                    Iterator iter = selkeys.iterator();

                    // traverse and process the keys
                    while (iter.hasNext()) {
                        SelectionKey selkey = (SelectionKey) iter.next();

                        // remove the current key
                        iter.remove();

                        // get the key's socket channel
                        try (SocketChannel keySC = (SocketChannel) selkey.channel()) {

                            // attempt a connection
                            if (selkey.isConnectable()) {

                                // connection successfully achieved
                                System.out.println("Connection successfully achieved!");

                                // pending connections will be closed
                                if (keySC.isConnectionPending()) {
                                    keySC.finishConnect();
                                }

                                // this delay is not necessary - it was added just for easy following the output
                                Thread.sleep(new Random().nextInt(5000));
                                
                                // read/write from/to server                                
                                while (keySC.read(tBuffer) != -1) {

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
                                        // this delay is not necessary - it was added just for easy following the output
                                        Thread.sleep(new Random().nextInt(3000));
                                
                                        rBuffer = ByteBuffer.wrap(
                                                "Random number:".concat(String.valueOf(r).concat(" ")).getBytes("UTF-8"));
                                        keySC.write(rBuffer);
                                    }
                                }
                            }
                        } catch (IOException ex) {
                            System.err.println(ex);
                            // handle exception
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
}