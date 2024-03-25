package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class Main {

    public static void main(String[] args) {

        try (Arena arena = Arena.ofConfined()) {

            MemorySegment addrs = arena.allocate(ValueLayout.ADDRESS, 3); // JDK 22

            MemorySegment i1 = arena.allocateFrom(ValueLayout.JAVA_INT, 1); // JDK 22
            MemorySegment i2 = arena.allocateFrom(ValueLayout.JAVA_INT, 3); // JDK 22
            MemorySegment i3 = arena.allocateFrom(ValueLayout.JAVA_INT, 2); // JDK 22

            addrs.setAtIndex(ValueLayout.ADDRESS, 0, i1);
            addrs.setAtIndex(ValueLayout.ADDRESS, 1, i2);
            addrs.setAtIndex(ValueLayout.ADDRESS, 2, i3);

            MemorySegment addr1 = addrs.getAtIndex(ValueLayout.ADDRESS, 0);
            MemorySegment addr2 = addrs.getAtIndex(ValueLayout.ADDRESS, 1);
            MemorySegment addr3 = addrs.getAtIndex(ValueLayout.ADDRESS, 2);            

            // addr1.get(ValueLayout.JAVA_INT, 0); // DON'T DO THIS!                        
            System.out.println("Value at address1: " + MemorySegment.ofAddress(
                    addr1.address()).reinterpret(ValueLayout.JAVA_INT.byteSize()).get(ValueLayout.JAVA_INT, 0));
            System.out.println("Value at address2: " + MemorySegment.ofAddress(
                    addr2.address()).reinterpret(ValueLayout.JAVA_INT.byteSize()).get(ValueLayout.JAVA_INT, 0));
            System.out.println("Value at address3: " + MemorySegment.ofAddress(
                    addr3.address()).reinterpret(ValueLayout.JAVA_INT.byteSize()).get(ValueLayout.JAVA_INT, 0));                       

            System.out.println();

            System.out.println("Address 1: " + addr1 + " | "
                    + i1.address() + " Value 1: " + i1.getAtIndex(ValueLayout.JAVA_INT, 0));
            System.out.println("Address 2: " + addr2 + " | "
                    + i2.address() + " Value 2: " + i2.getAtIndex(ValueLayout.JAVA_INT, 0));
            System.out.println("Address 3: " + addr3 + " | "
                    + i3.address() + " Value 3: " + i3.getAtIndex(ValueLayout.JAVA_INT, 0));
            System.out.println();

            // check as long
            System.out.println(addr1.address() == i1.address());

            // check as MemorySegments
            System.out.println(addr1.equals(i1));

            System.out.println();
            System.out.println("i1: " + i1.get(ValueLayout.JAVA_INT, 0));
            System.out.println("i2: " + i2.get(ValueLayout.JAVA_INT, 0));
            System.out.println("i3: " + i3.get(ValueLayout.JAVA_INT, 0));

            long i2Addr = i2.address();
            i2 = MemorySegment.ofAddress(i3.address()).reinterpret(ValueLayout.JAVA_INT.byteSize());
            i3 = MemorySegment.ofAddress(i2Addr).reinterpret(ValueLayout.JAVA_INT.byteSize());

            System.out.println();
            System.out.println("i1: " + i1.get(ValueLayout.JAVA_INT, 0));
            System.out.println("i2: " + i2.get(ValueLayout.JAVA_INT, 0));
            System.out.println("i3: " + i3.get(ValueLayout.JAVA_INT, 0));
        }               
    }
}