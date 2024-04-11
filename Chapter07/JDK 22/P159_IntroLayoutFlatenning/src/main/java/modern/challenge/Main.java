package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

public class Main {

    public static void main(String[] args) {

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
                    handle.set(segment, 0L, i, j, Math.random());
                }
            }

            for (int i = 0; i < outerSeq.elementCount(); i++) {
                System.out.print("\n-----" + i + "-----");
                for (int j = 0; j < innerSeq.elementCount(); j++) {
                    System.out.printf("\nx = %.2f", handle.get(segment, 0L, i, j));
                }
            }
            
            // flatten and dispay
            System.out.println("\n\nFlatten and dispay:");
            SequenceLayout flatten = outerSeq.flatten();            
            VarHandle fhandle = flatten.varHandle(PathElement.sequenceElement());
            
            for (int i = 0; i < flatten.elementCount(); i++) {
                System.out.printf("\nx = %.2f", fhandle.get(segment, 0L, i));
            }
        }

        // flatten and reallocate
        System.out.println("\n\nFlatten and reallocate:");
        SequenceLayout flatten = outerSeq.flatten();

        VarHandle fhandle = flatten.varHandle(PathElement.sequenceElement());
              
        try (Arena arena = Arena.ofConfined()) {

            MemorySegment segment = arena.allocate(flatten);

            System.out.println("Element count: " + flatten.elementCount());
            
            for (int i = 0; i < flatten.elementCount(); i++) {
                fhandle.set(segment, 0L, i, Math.random());
            }            

            for (int i = 0; i < flatten.elementCount(); i++) {
                System.out.printf("\nx = %.2f", fhandle.get(segment, 0L, i));
            }
        }
    }
}
