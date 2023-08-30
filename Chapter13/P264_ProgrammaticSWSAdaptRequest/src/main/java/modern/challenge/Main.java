package modern.challenge;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import java.io.IOException;
import static java.lang.System.out;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.List;

public class Main {
 
    public static void main(String[] args) throws IOException {

        HttpHandler fileHandler = SimpleFileServer.createFileHandler(
                Path.of("./docs").toAbsolutePath());
                        
        Filter preFilter = Filter.adaptRequest(
                "Add 'Author' header", r -> r.with("Author", List.of("Anghel Leonard")));
        Filter postFilter = SimpleFileServer.createOutputFilter(out, SimpleFileServer.OutputLevel.VERBOSE);
        
        HttpServer sws = HttpServer.create(
                new InetSocketAddress(9009), 10, "/mybooks", fileHandler, preFilter, postFilter);                                
        
        sws.start();
    }
}