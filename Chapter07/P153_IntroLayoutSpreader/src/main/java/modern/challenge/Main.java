package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Throwable {

        SequenceLayout inner = MemoryLayout.sequenceLayout(5, ValueLayout.JAVA_DOUBLE);
        SequenceLayout outer = MemoryLayout.sequenceLayout(10, inner);

        VarHandle handle = outer.varHandle(
                PathElement.sequenceElement(),
                PathElement.sequenceElement());

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocate(outer);

            System.out.println("Outer: " + outer.elementCount());
            System.out.println("Inner: " + inner.elementCount());

            for (int i = 0; i < outer.elementCount(); i++) {
                for (int j = 0; j < inner.elementCount(); j++) {
                    handle.set(segment, i, j, Math.random());
                }
            }

            for (int i = 0; i < outer.elementCount(); i++) {
                System.out.print("\n-----" + i + "-----");
                for (int j = 0; j < inner.elementCount(); j++) {
                    System.out.printf("\nx = %.5f", handle.get(segment, i, j));
                }
            }

            MethodHandle mHandle = outer.sliceHandle(
                    PathElement.sequenceElement(),
                    PathElement.sequenceElement()
            );

            System.out.println();
            System.out.println();

            MemorySegment ms = (MemorySegment) mHandle
                    .asSpreader(Long[].class, 2).invokeExact(segment, new Long[]{7L, 3L});
            
            System.out.println(Arrays.toString(ms.toArray(ValueLayout.JAVA_DOUBLE)));
        }
    }
}
