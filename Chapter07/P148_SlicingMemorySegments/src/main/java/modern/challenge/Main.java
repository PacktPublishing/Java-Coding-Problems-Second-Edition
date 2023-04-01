package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteOrder;
import java.util.Arrays;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorMask;
import jdk.incubator.vector.VectorSpecies;

public class Main {

    public static void main(String[] args) {

        VectorSpecies<Integer> VS128 = IntVector.SPECIES_128;

        IntVector v1, v2, v3;        
        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocateArray(
                    ValueLayout.JAVA_INT, 1, 2, 3, 4, 0, 0, 0, 52, 22, 33, 0, 0, 0, 0 ,0, 4);
            
            v1 = IntVector.fromMemorySegment(VS128, 
                    segment.asSlice(0, 16), 0, ByteOrder.nativeOrder());
            
            v2 = IntVector.fromMemorySegment(VS128, 
                    segment.asSlice(28, 12), 0, ByteOrder.nativeOrder(),
                    VectorMask.fromArray(VS128, new boolean[] {true, true, true, false}, 0));
            
            v3 = IntVector.fromMemorySegment(VS128, 
                    segment.asSlice(60), 0, ByteOrder.nativeOrder(),
                    VectorMask.fromArray(VS128, new boolean[] {true, false, false, false}, 0));
        }

        System.out.println("v1: " + Arrays.toString(v1.toIntArray()));
        System.out.println("v2: " + Arrays.toString(v2.toIntArray()));
        System.out.println("v3: " + Arrays.toString(v3.toIntArray()));
    }
}