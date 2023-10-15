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

            System.out.println("\nUnion size in bytes: " + segment.byteSize());

            segment.setAtIndex(ValueLayout.JAVA_DOUBLE, 0, 500.99);
            System.out.printf("\nprice = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, 0));
            segment.setAtIndex(ValueLayout.JAVA_INT, 0, 101000);
            System.out.printf("\nprice (garbage value) = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, 0));
            System.out.println("\nsku = " + segment.getAtIndex(ValueLayout.JAVA_INT, 0));

            segment.setAtIndex(ValueLayout.JAVA_DOUBLE, 0, 500.99);
            System.out.printf("\nprice = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, 0));
            System.out.println("\nsku (garbage value) = " + segment.getAtIndex(ValueLayout.JAVA_INT, 0));
        }

        System.out.println();

        UnionLayout union = MemoryLayout.unionLayout(
                ValueLayout.JAVA_DOUBLE.withName("price"),
                ValueLayout.JAVA_INT.withName("sku"));

        VarHandle pHandle = union.varHandle(PathElement.groupElement("price"));
        VarHandle sHandle = union.varHandle(PathElement.groupElement("sku"));
        
        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocate(union);

            System.out.println("\nUnion size in bytes: " + segment.byteSize());

            pHandle.set(segment, 500.99);
            System.out.printf("\nprice = %.2f", pHandle.get(segment));
            sHandle.set(segment, 101000);
            System.out.printf("\nprice (garbage value) = %.2f", pHandle.get(segment));
            System.out.println("\nsku = " + sHandle.get(segment));

            pHandle.set(segment, 500.99);
            System.out.printf("\nprice = %.2f", pHandle.get(segment));
            System.out.println("\nsku (garbage value) = " + sHandle.get(segment));
        }
    }
}
