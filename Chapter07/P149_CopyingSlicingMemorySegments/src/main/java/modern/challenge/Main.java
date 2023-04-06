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

        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocateArray(
                    ValueLayout.JAVA_INT, 1, 2, 3, 4, -1, -1, -1, 52, 22, 33, -1, -1, -1, -1, -1, 4);

            MemorySegment copySegment = segment.copyFrom(segment);

            System.out.println("Data: "
                    + Arrays.toString(copySegment.toArray(ValueLayout.JAVA_INT)));
        }

        VectorSpecies<Integer> VS128 = IntVector.SPECIES_128;

        IntVector v1, v2, v3;
        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocateArray(
                    ValueLayout.JAVA_INT, 1, 2, 3, 4, -1, -1, -1, 52, 22, 33, -1, -1, -1, -1, -1, 4);
            
            v1 = IntVector.fromMemorySegment(VS128,
                    segment.asSlice(0, 16), 0, ByteOrder.nativeOrder());

            v2 = IntVector.fromMemorySegment(VS128,
                    segment.asSlice(28, 12), 0L, ByteOrder.nativeOrder(),
                    VS128.indexInRange(0, 3));

            v3 = IntVector.fromMemorySegment(VS128,
                    segment.asSlice(60), 0, ByteOrder.nativeOrder(),
                    VS128.indexInRange(0, 1));
        }

        System.out.println("v1: " + Arrays.toString(v1.toIntArray()));
        System.out.println("v2: " + Arrays.toString(v2.toIntArray()));
        System.out.println("v3: " + Arrays.toString(v3.toIntArray()));
        
        int[] jv1, jv2, jv3;
        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocateArray(
                    ValueLayout.JAVA_INT, 1, 2, 3, 4, -1, -1, -1, 52, 22, 33, -1, -1, -1, -1, -1, 4);
                       
           jv1 = segment.asSlice(0, 16).toArray(ValueLayout.JAVA_INT);
           jv2 = segment.asSlice(28, 12).toArray(ValueLayout.JAVA_INT);
           jv3 = segment.asSlice(60).toArray(ValueLayout.JAVA_INT);
        }
        
        System.out.println("jv1: " + Arrays.toString(jv1));
        System.out.println("jv2: " + Arrays.toString(jv2));
        System.out.println("jv3: " + Arrays.toString(jv3));
    }
}
