package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[]{7, 8, 9};
        int[] arr3 = new int[]{10, 11, 12, 13, 14};

        try (Arena arena = Arena.ofConfined()) {
            MemorySegment segment1 = arena.allocateFrom(ValueLayout.JAVA_INT, arr1);
            MemorySegment segment2 = arena.allocateFrom(ValueLayout.JAVA_INT, arr2);
            MemorySegment segment3 = arena.allocateFrom(ValueLayout.JAVA_INT, arr3);

            System.out.println("Segment 1: " + Arrays.toString(segment1.toArray(ValueLayout.JAVA_INT)));
            System.out.println("Segment 2: " + Arrays.toString(segment2.toArray(ValueLayout.JAVA_INT)));
            System.out.println("Segment 3: " + Arrays.toString(segment3.toArray(ValueLayout.JAVA_INT)));
        }
        
        System.out.println();

        // using a pre-allocated segment that doesn't fit all data
        try (Arena arena = Arena.ofConfined()) {
                                                                  // it should be 10 * 4 + 4 * 4
            SegmentAllocator allocator = SegmentAllocator.slicingAllocator(arena.allocate(10 * 4)); 

            MemorySegment segment1 = allocator.allocateFrom(ValueLayout.JAVA_INT, arr1);
            MemorySegment segment2 = allocator.allocateFrom(ValueLayout.JAVA_INT, arr2);
            MemorySegment segment3 = allocator.allocateFrom(ValueLayout.JAVA_INT, arr3);

            System.out.println("Segment 1: " + Arrays.toString(segment1.toArray(ValueLayout.JAVA_INT)));
            System.out.println("Segment 2: " + Arrays.toString(segment2.toArray(ValueLayout.JAVA_INT)));
            System.out.println("Segment 3: " + Arrays.toString(segment3.toArray(ValueLayout.JAVA_INT)));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is not enough memory to fit all data");
            // handle exception
        }
    }
}