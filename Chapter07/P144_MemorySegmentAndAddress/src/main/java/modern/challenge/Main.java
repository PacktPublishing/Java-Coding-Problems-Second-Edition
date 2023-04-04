package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    
        try (Arena arena = Arena.openConfined()) {
            
            MemorySegment segment = arena.allocateArray(
                    ValueLayout.JAVA_DOUBLE, new double[] {1.0, 3.2, 2.2});
           
            MemorySegment address1 = segment.get(ValueLayout.ADDRESS, 0);
            MemorySegment address2 = segment.get(ValueLayout.ADDRESS, 8);
            MemorySegment address3 = segment.get(ValueLayout.ADDRESS, 16);            
            
            System.out.println("Initial array: " 
                    + Arrays.toString(segment.toArray(ValueLayout.JAVA_DOUBLE)));            
            System.out.println("Segment: " + segment + " [" + segment.address() + "]");
            System.out.println("Address 1 (for 1.0): " + address1);
            System.out.println("Address 2 (for 3.2): " + address2);
            System.out.println("Address 3 (for 2.2): " + address3);
            System.out.println();
                        
            System.out.println("Change the value from offset 8 (second value, 3.2) to Double.MAX_VALUE");
            segment.set(ValueLayout.JAVA_DOUBLE, 8, Double.MAX_VALUE);
            System.out.println("Current array: " + Arrays.toString(
                    segment.toArray(ValueLayout.JAVA_DOUBLE)));
                        
            MemorySegment newAddress2 = segment.get(ValueLayout.ADDRESS, 8);
            System.out.println("\nAddress 2: " + address2);
            System.out.println("New address 2: " + newAddress2);
                        
            System.out.println("\nChange the value from offset 0 (first value, 1.0) to Double.MIN_VALUE");
            segment.setAtIndex(ValueLayout.JAVA_DOUBLE, 0, Double.MIN_VALUE);
            System.out.println("Current array: " + Arrays.toString(
                    segment.toArray(ValueLayout.JAVA_DOUBLE)));
                        
            MemorySegment newAddress1 = segment.get(ValueLayout.ADDRESS, 0);
            System.out.println("\nAddress 1: " + address1);
            System.out.println("New address 1: " + newAddress1);
            
            System.out.println("\nReplace the value from offset 16 (2.2) with the initial value from offset 0 (1.0)");
            segment.set(ValueLayout.ADDRESS, 16, address1);
            System.out.println("Current array: " + Arrays.toString(
                    segment.toArray(ValueLayout.JAVA_DOUBLE)));
                        
            MemorySegment initialAddress1 = segment.get(ValueLayout.ADDRESS, 16);
            System.out.println("\nAddress 1: " + address1);
            System.out.println("New address 3: " + initialAddress1);
            
            System.out.println("\nReplace the value from offset 0 (now, Double.MIN_VALUE) with the initial value from offset 16 (2.2)");
            segment.set(ValueLayout.ADDRESS, 0, address3);
            System.out.println("Current array: " + Arrays.toString(
                    segment.toArray(ValueLayout.JAVA_DOUBLE)));
                        
            MemorySegment initialAddress3 = segment.get(ValueLayout.ADDRESS, 0);
            System.out.println("\nAddress 3: " + address3);
            System.out.println("New address 1: " + initialAddress3);
            
            System.out.println("\nReplace the value from offset 8 (now, Double.MAX_VALUE) with the initial value from offset 8 (3.2)");
            segment.set(ValueLayout.ADDRESS, 8, address2);
            System.out.println("Current array: " + Arrays.toString(
                    segment.toArray(ValueLayout.JAVA_DOUBLE)));
                        
            MemorySegment initialAddress2 = segment.get(ValueLayout.ADDRESS, 8);
            System.out.println("\nAddress 2: " + address2);
            System.out.println("New address 2: " + initialAddress2);
            
            MemorySegment faddress1 = segment.get(ValueLayout.ADDRESS, 0);
            MemorySegment faddress2 = segment.get(ValueLayout.ADDRESS, 8);
            MemorySegment faddress3 = segment.get(ValueLayout.ADDRESS, 16);            
            
            System.out.println("\nFinal array: " 
                    + Arrays.toString(segment.toArray(ValueLayout.JAVA_DOUBLE)));            
            System.out.println("Segment: " + segment + " [" + segment.address() + "]");
            System.out.println("Address 1 (for 2.2): " + faddress1);
            System.out.println("Address 2 (for 3.2): " + faddress2);
            System.out.println("Address 3 (for 1.0): " + faddress3);
        }               
    }
}
