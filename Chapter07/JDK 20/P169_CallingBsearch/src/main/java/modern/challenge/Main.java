package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentScope;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;

public class Main {

    static int elem = 14;
    static int[] arr = new int[]{1, 3, 6, 8, 10, 12, 14, 16, 20, 22};

    static int comparator(MemorySegment i1, MemorySegment i2) {
        return Integer.compare(i1.get(ValueLayout.JAVA_INT, 0),
                i2.get(ValueLayout.JAVA_INT, 0));
    }

    public static void main(String[] args) throws Throwable {
        
        MethodHandle comparatorHandle = MethodHandles.lookup()
                .findStatic(Main.class, "comparator", MethodType.methodType(
                        int.class, MemorySegment.class, MemorySegment.class));

        Linker linker = Linker.nativeLinker();
        SymbolLookup libLookup = linker.defaultLookup();
        
        MemorySegment comparatorFunc = linker.upcallStub(comparatorHandle,
                FunctionDescriptor.of(ValueLayout.JAVA_INT,
                        ValueLayout.ADDRESS.asUnbounded(),
                        ValueLayout.ADDRESS.asUnbounded()),
                SegmentScope.auto());

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segmentBsearch = libLookup.find("bsearch").get();

            MethodHandle func = linker.downcallHandle(segmentBsearch, FunctionDescriptor.of(
                    ValueLayout.ADDRESS,
                    ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT,
                    ValueLayout.JAVA_LONG, ValueLayout.ADDRESS));

            MemorySegment key = arena.allocate(ValueLayout.JAVA_INT, elem);
            MemorySegment array = arena.allocateArray(ValueLayout.JAVA_INT, arr);

            MemorySegment result = (MemorySegment) func.invokeExact(
                    key, array, 10, ValueLayout.JAVA_INT.byteSize(), comparatorFunc);

            if (result.equals(MemorySegment.NULL)) {
                System.out.println("Element " + elem 
                        + " not found in the given array " + Arrays.toString(arr));
            } else {
                long offset = array.segmentOffset(result);
                System.out.println("Element found in the given array at offset: " + offset);
                System.out.println("Element value: "
                        + array.get(ValueLayout.JAVA_INT, offset));
            }
        }
    }
}