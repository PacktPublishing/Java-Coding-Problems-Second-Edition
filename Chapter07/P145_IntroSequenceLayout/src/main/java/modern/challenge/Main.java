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

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = MemorySegment.allocateNative(
                    ValueLayout.JAVA_DOUBLE.byteSize() * 10,
                    ValueLayout.JAVA_DOUBLE.byteAlignment(), arena.scope());

            for (int i = 0; i < 10; i++) {
                segment.setAtIndex(ValueLayout.JAVA_DOUBLE, i, Math.random());
            }

            for (int i = 0; i < 10; i++) {
                System.out.printf("\nx = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, i));
            }
        }

        System.out.println();

        SequenceLayout seq = MemoryLayout.sequenceLayout(
                10, ValueLayout.JAVA_DOUBLE.withName("x"));

        VarHandle xHandle = seq.varHandle(PathElement.sequenceElement());
       
        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocate(seq);
            
            System.out.println("\nSequence size in bytes: " + segment.byteSize());
            
            for (int i = 0; i < seq.elementCount(); i++) {
                xHandle.set(segment, i, Math.random());               
            }

            for (int i = 0; i < seq.elementCount(); i++) {
                System.out.printf("\nx = %.2f", xHandle.get(segment, i));               
            }
        }
    }
}