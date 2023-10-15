package modern.challenge;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.channels.FileChannel;
import static java.nio.channels.FileChannel.MapMode.READ_WRITE;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.SPARSE;
import static java.nio.file.StandardOpenOption.WRITE;

public class Main {

    public static void main(String[] args) throws IOException {
        
        try (FileChannel file = FileChannel.open(
                Path.of("readme.txt"), CREATE, READ, WRITE);                 
                Arena arena = Arena.openConfined()) {

            MemorySegment segment
                    = file.map(READ_WRITE, 0, 1048576, arena.scope());  // 1 Megabyte = 1048576 bytes
                                                                        // 1 Gigabyte = 1073741824 bytes

            // write the data                                                                        
            segment.setUtf8String(0, "This is a readme file ...");
            segment.setUtf8String(1048576/2, "Here is the middle of the file ...");
            segment.setUtf8String(1048576-32, "Here is the end of the file ...");
            
            // read some data
            System.out.println(segment.getUtf8String(1048576/2));
        }
        
        try (FileChannel file = FileChannel.open(
                Path.of("sparse_readme.txt"), CREATE_NEW, SPARSE, READ, WRITE);                 
                Arena arena = Arena.openConfined()) {

            MemorySegment segment
                    = file.map(READ_WRITE, 0, 1048576, arena.scope());  // 1 Megabyte = 1048576 bytes
                                                                        // 1 Gigabyte = 1073741824 bytes

            // write the data                                                                        
            segment.setUtf8String(0, "This is a readme file ...");
            segment.setUtf8String(1048576/2, "Here is the middle of the file ...");
            segment.setUtf8String(1048576-32, "Here is the end of the file ...");
            
            // read some data
            System.out.println(segment.getUtf8String(0));
        }
        
        System.out.println("\n\nYou should find the files on disk in the project's root");
    }
}
