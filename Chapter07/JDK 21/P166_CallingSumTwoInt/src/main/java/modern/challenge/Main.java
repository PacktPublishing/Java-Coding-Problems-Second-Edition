package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Throwable {

        Linker linker = Linker.nativeLinker();
        Path path = Paths.get("lib/cpp/math.dll");            
       
        try (Arena arena = Arena.ofConfined()) {                        
            
            SymbolLookup libLookup = SymbolLookup.libraryLookup(path, arena);            
            MemorySegment segmentSumTwoInt = libLookup.find("_Z9sumTwoIntii").get();

            MethodHandle func = linker.downcallHandle(segmentSumTwoInt,
                    FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));

            long result = (long) func.invokeExact(3, 9);

            System.out.println(result);
        }
    }
}