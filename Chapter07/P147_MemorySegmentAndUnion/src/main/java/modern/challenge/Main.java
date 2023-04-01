package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.UnionLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

public class Main {

    public static void main(String[] args) {

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = MemorySegment.allocateNative(
                    ValueLayout.JAVA_DOUBLE.byteSize(),
                    ValueLayout.JAVA_DOUBLE.byteAlignment(), arena.scope());
            
                segment.setAtIndex(ValueLayout.JAVA_DOUBLE, 0, Math.random());
                System.out.printf("\nx = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, 0));
                System.out.printf("\ny = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, 0));            
                
                segment.setAtIndex(ValueLayout.JAVA_DOUBLE, 0, Math.random());                                        
                System.out.printf("\nx = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, 0));
                System.out.printf("\ny = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, 0));            
        }

        System.out.println();

        UnionLayout union = MemoryLayout.unionLayout(
                ValueLayout.JAVA_DOUBLE.withName("x"),
                ValueLayout.JAVA_DOUBLE.withName("y"));

        VarHandle xHandle = union.varHandle(PathElement.groupElement("x"));
        VarHandle yHandle = union.varHandle(PathElement.groupElement("y"));

        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocate(union);

            System.out.println("\nUnion size in bytes: " + segment.byteSize());

            xHandle.set(segment, Math.random());
            System.out.printf("\nx = %.2f", xHandle.get(segment));
            System.out.printf("\ny = %.2f", yHandle.get(segment));
            
            yHandle.set(segment, Math.random());
            System.out.printf("\nx = %.2f", xHandle.get(segment));
            System.out.printf("\ny = %.2f", yHandle.get(segment));
        }
    }
}