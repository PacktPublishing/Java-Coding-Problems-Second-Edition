package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try (Arena arena = Arena.openConfined()) {

            MemorySegment addrs = arena.allocateArray(ValueLayout.ADDRESS, 3);

            MemorySegment i1 = arena.allocate(ValueLayout.JAVA_INT, 1);
            MemorySegment i2 = arena.allocate(ValueLayout.JAVA_INT, 3);
            MemorySegment i3 = arena.allocate(ValueLayout.JAVA_INT, 2);

            addrs.setAtIndex(ValueLayout.ADDRESS, 0, i1);
            addrs.setAtIndex(ValueLayout.ADDRESS, 1, i2);
            addrs.setAtIndex(ValueLayout.ADDRESS, 2, i3);

            MemorySegment address1 = addrs.getAtIndex(ValueLayout.ADDRESS, 0);
            MemorySegment address2 = addrs.getAtIndex(ValueLayout.ADDRESS, 1);
            MemorySegment address3 = addrs.getAtIndex(ValueLayout.ADDRESS, 2);

            // address1.get(ValueLayout.JAVA_INT, 0); DON'T DO THIS!
            System.out.println("Value at address1: " + MemorySegment.ofAddress(
                    address1.address(), 4).get(ValueLayout.JAVA_INT, 0));
            System.out.println("Value at address2: " + MemorySegment.ofAddress(
                    address2.address(), 4).get(ValueLayout.JAVA_INT, 0));
            System.out.println("Value at address3: " + MemorySegment.ofAddress(
                    address3.address(), 4).get(ValueLayout.JAVA_INT, 0));

            System.out.println();

            System.out.println("Address 1: " + address1 + " | "
                    + i1.address() + " Value 1: " + i1.getAtIndex(ValueLayout.JAVA_INT, 0));
            System.out.println("Address 2: " + address2 + " | "
                    + i2.address() + " Value 2: " + i2.getAtIndex(ValueLayout.JAVA_INT, 0));
            System.out.println("Address 3: " + address3 + " | "
                    + i3.address() + " Value 3: " + i3.getAtIndex(ValueLayout.JAVA_INT, 0));
            System.out.println();

            // check as long
            System.out.println(address1.address() == i1.address());

            // check as MemorySegments
            System.out.println(address1.equals(i1));

            System.out.println();
            System.out.println("i1: " + i1.get(ValueLayout.JAVA_INT, 0));
            System.out.println("i2: " + i2.get(ValueLayout.JAVA_INT, 0));
            System.out.println("i3: " + i3.get(ValueLayout.JAVA_INT, 0));

            long i2Addr = i2.address();
            i2 = MemorySegment.ofAddress(i3.address(), 4);
            i3 = MemorySegment.ofAddress(i2Addr, 4);

            System.out.println();
            System.out.println("i1: " + i1.get(ValueLayout.JAVA_INT, 0));
            System.out.println("i2: " + i2.get(ValueLayout.JAVA_INT, 0));
            System.out.println("i3: " + i3.get(ValueLayout.JAVA_INT, 0));
        }

        // asOverlappingSlice()
        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocateArray(ValueLayout.JAVA_INT,
                    new int[]{1, 2, 3, 4, 6, 8, 4, 5, 3});

            MemorySegment subsegment = segment.asSlice(12);

            int[] subarray = segment.asOverlappingSlice(subsegment).get().toArray(ValueLayout.JAVA_INT);

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
