package modern.challenge;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;

public class Main {
 
    public static void main(String[] args) throws IOException {

        HttpHandler fileHandler = SimpleFileServer.createFileHandler(
                Path.of("./docs").toAbsolutePath());
        
        HttpServer sws = HttpServer.create(
                new InetSocketAddress(9009), 10, "/mybooks", fileHandler);                                
        
        sws.start();
    }
}