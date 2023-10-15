package modern.challenge;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.channels.FileChannel;
import static java.nio.channels.FileChannel.MapMode.READ_WRITE;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.SPARSE;
import static java.nio.file.StandardOpenOption.WRITE;

public class MappedArena implements Arena {

    private final String fileName;
    private final Arena shared;

    public MappedArena(String fileName) {

        if (fileName == null) {
            throw new IllegalArgumentException("The file name cannot be null");
        }

        this.fileName = fileName;
        this.shared = Arena.ofShared();
    }

    @Override
    public MemorySegment allocate(long byteSize, long byteAlignment) {

        try (FileChannel file = FileChannel.open(
                Path.of(fileName + System.currentTimeMillis() + ".txt"),
                CREATE_NEW, SPARSE, READ, WRITE)) {

            return file.map(READ_WRITE, 0, byteSize, shared);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MemorySegment.Scope scope() {
        return shared.scope();
    }

    @Override
    public void close() {
        shared.close();
    }  
}