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
        SymbolLookup mathLookup = linker.defaultLookup();
        
        try (Arena arena = Arena.openConfined()) {
            
            MemorySegment segmentMath = mathLookup.find("modf").get();

            MethodHandle func = linker.downcallHandle(segmentMath, FunctionDescriptor.of(
                    ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS));
            
            MemorySegment segment = arena.allocate(ValueLayout.JAVA_DOUBLE);
                        
            double result = (double) func.invokeExact(x, segment);

            System.out.println("Fractional part: " + result 
                    + " Integral part: " + segment.get(ValueLayout.JAVA_DOUBLE, 0));
        }
    }
}
