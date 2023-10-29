package modern.challenge;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
 
    public static void main(String[] args) throws IOException {

        HttpHandler fileHandler = SimpleFileServer.createFileHandler(
                Path.of("./docs").toAbsolutePath());
        
        Path swslog = Paths.get("swslog.txt");
        BufferedOutputStream output = new BufferedOutputStream(Files.newOutputStream(
                swslog, StandardOpenOption.CREATE, StandardOpenOption.WRITE));
        
        Filter filter = SimpleFileServer.createOutputFilter(output, SimpleFileServer.OutputLevel.VERBOSE);
        
        HttpServer sws = HttpServer.create(
                new InetSocketAddress(9009), 10, "/mybooks", fileHandler, filter);                                
        
        sws.start();
    }
}