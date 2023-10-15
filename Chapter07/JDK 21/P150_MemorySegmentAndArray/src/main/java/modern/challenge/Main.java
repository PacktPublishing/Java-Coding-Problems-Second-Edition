package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteOrder;
import java.util.Arrays;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

public class Main {

    public static void main(String[] args) {

        VectorSpecies<Integer> VS256 = IntVector.SPECIES_256;

        IntVector v0;
        try (Arena arena = Arena.ofConfined()) {

            // 32 = 256/8, but you can also express it as: ValueLayout.JAVA_INT.byteSize() * 8
            MemorySegment segment = arena.allocate(32);
            segment.set(ValueLayout.JAVA_INT, 0, 11);
            segment.set(ValueLayout.JAVA_INT, 4, 21);
            segment.set(ValueLayout.JAVA_INT, 8, 12);
            segment.set(ValueLayout.JAVA_INT, 12, 7);
            segment.set(ValueLayout.JAVA_INT, 16, 33);
            segment.set(ValueLayout.JAVA_INT, 20, 1);
            segment.set(ValueLayout.JAVA_INT, 24, 3);
            segment.set(ValueLayout.JAVA_INT, 28, 6);

            v0 = IntVector.fromMemorySegment(VS256, segment, 0, ByteOrder.nativeOrder());
        }

        System.out.println("v0: " + Arrays.toString(v0.toIntArray()));

        IntVector v1;
        try (Arena arena = Arena.ofConfined()) {

            MemorySegment segment = arena.allocate(32);
            segment.setAtIndex(ValueLayout.JAVA_INT, 0, 11);
            segment.setAtIndex(ValueLayout.JAVA_INT, 1, 21);
            segment.setAtIndex(ValueLayout.JAVA_INT, 2, 12);
            segment.setAtIndex(ValueLayout.JAVA_INT, 3, 7);
            segment.setAtIndex(ValueLayout.JAVA_INT, 4, 33);
            segment.setAtIndex(ValueLayout.JAVA_INT, 5, 1);
            segment.setAtIndex(ValueLayout.JAVA_INT, 6, 3);
            segment.setAtIndex(ValueLayout.JAVA_INT, 7, 6);

            v1 = IntVector.fromMemorySegment(VS256, segment, 0, ByteOrder.nativeOrder());
        }

        System.out.println("v1: " + Arrays.toString(v1.toIntArray()));

        IntVector v2;
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment segment = arena.allocateArray(
                    ValueLayout.JAVA_INT, 11, 21, 12, 7, 33, 1, 3, 6);

            v2 = IntVector.fromMemorySegment(VS256, segment, 0, ByteOrder.nativeOrder());
        }

        System.out.println("v2: " + Arrays.toString(v2.toIntArray()));

        IntVector v3;
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment segment = arena.allocateArray(
                    ValueLayout.JAVA_INT, new int[]{11, 21, 12, 7, 33, 1, 3, 6});

            v3 = IntVector.fromMemorySegment(VS256, segment, 0, ByteOrder.nativeOrder());
        }

        System.out.println("v3: " + Arrays.toString(v3.toIntArray()));

        // on-heap array                            
        MemorySegment segment = MemorySegment
                .ofArray(new int[]{11, 21, 12, 7, 33, 1, 3, 6});

        System.out.println("On-heap, fifth element: " + segment.get(ValueLayout.JAVA_INT, 16));
        System.out.println("On-heap, fifth element: " + segment.getAtIndex(ValueLayout.JAVA_INT, 4));
    }
}