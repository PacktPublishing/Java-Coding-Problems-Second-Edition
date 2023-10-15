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

        VectorSpecies<Integer> VS128 = IntVector.SPECIES_128;
        IntVector v1, v2, v3;
        int[] jv1, jv2, jv3;

        try (Arena arena = Arena.openConfined()) {
            MemorySegment srcSegment = arena.allocateArray(
                    ValueLayout.JAVA_INT, 1, 2, 3, 4, -1, -1, -1, 52, 22, 33, -1, -1, -1, -1, -1, 4);

            MemorySegment copySegment = srcSegment.copyFrom(srcSegment);

            System.out.println("Data of source segment: "
                    + Arrays.toString(copySegment.toArray(ValueLayout.JAVA_INT)));

            System.out.println("\nCopying ...\n");

            MemorySegment dstSegment1 = arena.allocateArray(ValueLayout.JAVA_INT, 8);
            MemorySegment.copy(srcSegment, 32, dstSegment1, 0, 4 * 8);
            System.out.println("Destination segment (1): "
                    + Arrays.toString(dstSegment1.toArray(ValueLayout.JAVA_INT)));

            int[] dstArray = new int[8];
            MemorySegment.copy(srcSegment, ValueLayout.JAVA_INT, 32, dstArray, 0, 8);
            System.out.println("Destination array (2): " + Arrays.toString(dstArray));

            int[] srcArray = new int[]{10, 44, 2, 6, 55, 65, 7, 89};
            MemorySegment dstSegment2 = arena.allocateArray(ValueLayout.JAVA_INT, 16);
            MemorySegment.copy(srcArray, 0, dstSegment2, ValueLayout.JAVA_INT, 32, 8);
            System.out.println("Destination segment (3): "
                    + Arrays.toString(dstSegment2.toArray(ValueLayout.JAVA_INT)));

            // MemorySegment.copy(srcSegment, 32, dstSegment2, 0, 32);
            MemorySegment.copy(srcSegment, ValueLayout.JAVA_INT, 32, dstSegment2, ValueLayout.JAVA_INT, 0, 8);
            System.out.println("Destination segment (4): "
                    + Arrays.toString(dstSegment2.toArray(ValueLayout.JAVA_INT)));

            System.out.println("\nSlicing ...\n");

            v1 = IntVector.fromMemorySegment(VS128,
                    srcSegment.asSlice(0, 16), 0, ByteOrder.nativeOrder());

            v2 = IntVector.fromMemorySegment(VS128,
                    srcSegment.asSlice(28, 12), 0L, ByteOrder.nativeOrder(),
                    VS128.indexInRange(0, 3));

            v3 = IntVector.fromMemorySegment(VS128,
                    srcSegment.asSlice(60), 0, ByteOrder.nativeOrder(),
                    VS128.indexInRange(0, 1));

            System.out.println("v1: " + Arrays.toString(v1.toIntArray()));
            System.out.println("v2: " + Arrays.toString(v2.toIntArray()));
            System.out.println("v3: " + Arrays.toString(v3.toIntArray()));

            jv1 = srcSegment.asSlice(0, 16).toArray(ValueLayout.JAVA_INT);
            jv2 = srcSegment.asSlice(28, 12).toArray(ValueLayout.JAVA_INT);
            jv3 = srcSegment.asSlice(60).toArray(ValueLayout.JAVA_INT);

            System.out.println();
            System.out.println("jv1: " + Arrays.toString(jv1));
            System.out.println("jv2: " + Arrays.toString(jv2));
            System.out.println("jv3: " + Arrays.toString(jv3));
        }

        // asOverlappingSlice()
        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocateArray(ValueLayout.JAVA_INT,
                    new int[]{1, 2, 3, 4, 6, 8, 4, 5, 3});

            MemorySegment subsegment = segment.asSlice(12);

            int[] subarray = segment.asOverlappingSlice(subsegment)
                    .orElse(MemorySegment.NULL).toArray(ValueLayout.JAVA_INT);

            System.out.println("\nSub-array: " + Arrays.toString(subarray));
        }

        // segmentOffset()
        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocateArray(ValueLayout.JAVA_INT,
                    new int[]{1, 2, 3, 4, 6, 8, 4, 5, 3});

            MemorySegment subsegment = segment.asSlice(16);

            long offset = segment.segmentOffset(subsegment);

            System.out.println("\nOffset: " + offset + " Value: " + segment.get(ValueLayout.JAVA_INT, offset));
        }
    }
}
