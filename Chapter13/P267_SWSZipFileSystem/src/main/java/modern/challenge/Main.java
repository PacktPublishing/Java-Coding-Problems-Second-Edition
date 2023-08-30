package modern.challenge;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer sws = SimpleFileServer.createFileServer(
                new InetSocketAddress(9009), zipFileSystem(),
                OutputLevel.VERBOSE);

        sws.start();
    }

    private static Path zipFileSystem() throws IOException {

        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
     
        Path root = Path.of("./zips").toAbsolutePath();
        Path zipPath = root.resolve("docs.zip").toAbsolutePath().normalize();

        FileSystem zipfs = FileSystems.newFileSystem(zipPath, env);
        Path externalTxtFile = Paths.get("./docs/books.txt");
        Path pathInZipfile = zipfs.getPath("/bookszipped.txt");

        // copy a file into the zip file
        Files.copy(externalTxtFile, pathInZipfile,
                StandardCopyOption.REPLACE_EXISTING);

        return zipfs.getPath("/");
    }
}