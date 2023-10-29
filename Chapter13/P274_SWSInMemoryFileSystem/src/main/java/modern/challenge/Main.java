package modern.challenge;

import com.google.common.collect.ImmutableList;
import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer sws = SimpleFileServer.createFileServer(
                new InetSocketAddress(9009),
                inMemoryDirectory(),
                OutputLevel.VERBOSE);

        sws.start();
    }

    private static Path inMemoryDirectory() throws IOException {

        FileSystem fileSystem = Jimfs.newFileSystem(Configuration.forCurrentPlatform());

        Path docs = fileSystem.getPath("docs");
        Files.createDirectory(docs);

        Path books = docs.resolve("books.txt"); // /docs/books.txt
        Files.write(books, ImmutableList.of(
                "Java Coding Problems 1st Edition",
                "Java Coding Problems 2st Edition",
                "jOOQ Masterclass",
                "The Complete Coding Interview Guide in Java"),
                StandardCharsets.UTF_8);

        return docs.toAbsolutePath();
    }
}