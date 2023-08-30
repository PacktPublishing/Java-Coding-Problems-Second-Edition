package modern.challenge;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer sws = SimpleFileServer.createFileServer(
                new InetSocketAddress(9009), jrtFileSystem(),
                OutputLevel.VERBOSE);

        sws.start();
    }

    private static Path jrtFileSystem() {

        URI uri = URI.create("jrt:/");
        
        FileSystem jrtfs = FileSystems.getFileSystem(uri);
        Path jrtRoot = jrtfs.getPath("modules").toAbsolutePath();

        return jrtRoot;
    }
}