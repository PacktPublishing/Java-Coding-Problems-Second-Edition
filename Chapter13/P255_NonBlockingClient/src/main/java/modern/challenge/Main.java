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

    private static final int PORT = 5555;
    private static final String IP = "127.0.0.1";
    private static final int SELECTOR_TIMEOUT = 1_000;
        
    public static void main(String[] args) throws InterruptedException {        

        ByteBuffer buffer = ByteBuffer.allocateDirect(2 * 1024);
        ByteBuffer randomBuffer;
        CharBuffer charBuffer;

        Charset charset = Charset.defaultCharset();
        CharsetDecoder decoder = charset.newDecoder();

        // open Selector and ServerSocketChannel by calling the open() method
        try (Selector selector = Selector.open(); 
                SocketChannel socketChannel = SocketChannel.open()) {

            // check that both of them were successfully opened
            if ((socketChannel.isOpen()) && (selector.isOpen())) {

                // configure non-blocking mode
                socketChannel.configureBlocking(false);

                // set some options
                socketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 128 * 1024);
                socketChannel.setOption(StandardSocketOptions.SO_SNDBUF, 128 * 1024);
                socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);

                // register the current channel with the given selector
                socketChannel.register(selector, SelectionKey.OP_CONNECT);

                // connect to remote host
                socketChannel.connect(new java.net.InetSocketAddress(IP, PORT));

                System.out.println("Localhost: " + socketChannel.getLocalAddress());

                // waiting for the connection
                while (selector.select(SELECTOR_TIMEOUT) > 0) {

                    // get keys
                    Set keys = selector.selectedKeys();
                    Iterator its = keys.iterator();

                    // process each key
                    while (its.hasNext()) {
                        SelectionKey key = (SelectionKey) its.next();

                        // remove the current key
                        its.remove();

                        // get the socket channel for this key
                        try (SocketChannel keySocketChannel = (SocketChannel) key.channel()) {

                            // attempt a connection
                            if (key.isConnectable()) {

                                // signal connection success
                                System.out.println("I am connected!");

                                // close pending connections
                                if (keySocketChannel.isConnectionPending()) {
                                    keySocketChannel.finishConnect();
                                }

                                // this delay is not necessary - it was added just for easy following the output
                                Thread.sleep(new Random().nextInt(5000));
                                
                                // read/write from/to server                                
                                while (keySocketChannel.read(buffer) != -1) {

                                    buffer.flip();

                                    charBuffer = decoder.decode(buffer);
                                    System.out.println(charBuffer.toString());

                                    if (buffer.hasRemaining()) {
                                        buffer.compact();
                                    } else {
                                        buffer.clear();
                                    }

                                    int r = new Random().nextInt(100);
                                    if (r == 50) {
                                        System.out.println("50 was generated! Close the socket channel!");
                                        break;
                                    } else {
                                        // this delay is not necessary - it was added just for easy following the output
                                        Thread.sleep(new Random().nextInt(3000));
                                
                                        randomBuffer = ByteBuffer.wrap(
                                                "Random number:".concat(String.valueOf(r).concat(" ")).getBytes("UTF-8"));
                                        keySocketChannel.write(randomBuffer);
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
                System.out.println("The socket channel or selector cannot be opened!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
            // handle exception
        }
    }
}