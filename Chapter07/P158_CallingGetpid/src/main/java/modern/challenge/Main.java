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

        SymbolLookup mathLookup = linker.defaultLookup();
        MemorySegment segmentMath = mathLookup.find("_getpid").get();

        MethodHandle func = linker.downcallHandle(segmentMath,
                FunctionDescriptor.of(ValueLayout.JAVA_INT));

        int result = (int) func.invokeExact();

        System.out.println(result);
    }
}
