package modern.challenge;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpHandlers;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.Request;
import com.sun.net.httpserver.SimpleFileServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.function.Predicate;

public class Main {
 
    public static void main(String[] args) throws IOException {

        HttpHandler complementHandler = HttpHandlers.of(200, Headers.of(
                "Content-Type", "text/plain"), "No data available");
        
        HttpHandler fileHandler = SimpleFileServer.createFileHandler(
                Path.of("./docs").toAbsolutePath());                    
        
        Predicate<Request> predicate = request -> request.getRequestMethod().equalsIgnoreCase("GET");
        
        HttpHandler handler = HttpHandlers.handleOrElse(predicate, fileHandler, complementHandler);
                        
        HttpServer sws = HttpServer.create(
                new InetSocketAddress(9009), 10, "/mybooks", handler);                                
        
        sws.start();
    }
}