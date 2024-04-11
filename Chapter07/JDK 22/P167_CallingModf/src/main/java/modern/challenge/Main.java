package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public class Main {

    public static void main(String[] args) throws Throwable {

        double x = 89.76655;
        
        Linker linker = Linker.nativeLinker();
        SymbolLookup libLookup = linker.defaultLookup();
        
        try (Arena arena = Arena.ofConfined()) {
            
            MemorySegment segmentModf = libLookup.find("modf").get();

            MethodHandle func = linker.downcallHandle(segmentModf, FunctionDescriptor.of(
                    ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS));
            
            MemorySegment segmentIntptr = arena.allocate(ValueLayout.JAVA_DOUBLE);
                        
            double fractional = (double) func.invokeExact(x, segmentIntptr);

            System.out.println("Fractional part: " + fractional 
                    + " Integer part: " + segmentIntptr.get(ValueLayout.JAVA_DOUBLE, 0));
        }
    }
}
