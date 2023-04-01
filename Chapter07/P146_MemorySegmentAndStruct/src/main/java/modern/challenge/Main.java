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
                    2 * ValueLayout.JAVA_DOUBLE.byteSize() * 5,
                    ValueLayout.JAVA_DOUBLE.byteAlignment(), arena.scope());

            for (int i = 0; i < 5; i++) {
                segment.setAtIndex(ValueLayout.JAVA_DOUBLE, i * 2, Math.random());
                segment.setAtIndex(ValueLayout.JAVA_DOUBLE, i * 2 + 1, Math.random());
            }

            for (int i = 0; i < 5; i++) {
                System.out.printf("\nx = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, i * 2));
                System.out.printf("\ny = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, i * 2 + 1));
            }
        }

        System.out.println();

        SequenceLayout struct
                = MemoryLayout.sequenceLayout(5,
                        MemoryLayout.structLayout(
                                ValueLayout.JAVA_DOUBLE.withName("x"),
                                ValueLayout.JAVA_DOUBLE.withName("y")));

        VarHandle xHandle = struct.varHandle(PathElement.sequenceElement(),
                PathElement.groupElement("x"));
        VarHandle yHandle = struct.varHandle(PathElement.sequenceElement(),
                PathElement.groupElement("y"));

        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocate(struct);
            
            System.out.println("\nStruct size in bytes: " + segment.byteSize());
            
            for (int i = 0; i < struct.elementCount(); i++) {
                xHandle.set(segment, i, Math.random());
                yHandle.set(segment, i, Math.random());
            }

            for (int i = 0; i < struct.elementCount(); i++) {
                System.out.printf("\nx = %.2f", xHandle.get(segment, i));
                System.out.printf("\ny = %.2f", yHandle.get(segment, i));
            }
        }
    }
}