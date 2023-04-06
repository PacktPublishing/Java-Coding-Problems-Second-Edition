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

        try (Arena arena = Arena.openConfined()) {

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
                    System.out.printf("\nx = %.2f", handle.get(segment, i, j));
                }
            }
        }

        // reshape
        SequenceLayout reshaped = outerSeq.reshape(25, 2);

        VarHandle rhandle = reshaped.varHandle(
                PathElement.sequenceElement(),
                PathElement.sequenceElement());

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocate(reshaped);

            System.out.println("\n\nReshaped outerSeq: " + reshaped.elementCount());
            System.out.println("Reshaped innerSeq: " 
                    + ((SequenceLayout) reshaped.select(
                            PathElement.sequenceElement())).elementCount());

            long outerSeqCount = reshaped.elementCount();
            long innerSeqCount = ((SequenceLayout) reshaped.select(
                            PathElement.sequenceElement())).elementCount();            
            
            for (int i = 0; i < outerSeqCount; i++) {
                for (int j = 0; j < innerSeqCount; j++) {
                    rhandle.set(segment, i, j, Math.random());
                }
            }

            for (int i = 0; i < outerSeqCount; i++) {
                System.out.print("\n-----" + i + "-----");
                for (int j = 0; j < innerSeqCount; j++) {
                    System.out.printf("\nx = %.2f", rhandle.get(segment, i, j));
                }
            }
        }
    }
}