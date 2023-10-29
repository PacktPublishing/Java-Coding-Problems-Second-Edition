package modern.challenge;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        HttpServer sws = SimpleFileServer.createFileServer(
                new InetSocketAddress(9009),
                Path.of("./docs").toAbsolutePath(),
                OutputLevel.VERBOSE);
        
        sws.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        
        sws.start();
    }
}
