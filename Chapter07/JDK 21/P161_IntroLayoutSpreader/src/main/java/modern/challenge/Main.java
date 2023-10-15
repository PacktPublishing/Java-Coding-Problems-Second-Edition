package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

public class Main {

    public static void main(String[] args) throws Throwable {

        SequenceLayout innerSeq = MemoryLayout.sequenceLayout(5, ValueLayout.JAVA_DOUBLE);
        SequenceLayout outerSeq = MemoryLayout.sequenceLayout(10, innerSeq);

        VarHandle handle = outerSeq.varHandle(
                PathElement.sequenceElement(),
                PathElement.sequenceElement());

        try (Arena arena = Arena.ofConfined()) {

            MemorySegment segment = arena.allocate(outerSeq);

            System.out.println("Outer: " + outerSeq.elementCount());
            System.out.println("Inner: " + innerSeq.elementCount());

            for (int i = 0; i < outerSeq.elementCount(); i++) {
                for (int j = 0; j < innerSeq.elementCount(); j++) {
                    handle.set(segment, i, j, Math.random());
                }
            }

            for (int i = 0; i < outerSeq.elementCount(); i++) {
                System.out.print("\n-----" + i + "-----");
                for (int j = 0; j < innerSeq.elementCount(); j++) {
                    System.out.printf("\nx = %.5f", handle.get(segment, i, j));
                }
            }

            MethodHandle mHandle = outerSeq.sliceHandle(
                    PathElement.sequenceElement(),
                    PathElement.sequenceElement()
            );

            System.out.println();
            System.out.println();
            
            // no spreader
            // MemorySegment ms = (MemorySegment) mHandle.invokeExact(segment, 7L, 3L);

            // with spreader
            MemorySegment ms = (MemorySegment) mHandle
                    .asSpreader(Long[].class, 2).invokeExact(segment, new Long[]{7L, 3L});
                  
            System.out.println(ms.get(ValueLayout.JAVA_DOUBLE, 0));
        }
    }
}
