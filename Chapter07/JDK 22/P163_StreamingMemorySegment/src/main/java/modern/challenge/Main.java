package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Throwable {
        
        SequenceLayout xy = MemoryLayout.sequenceLayout(2, MemoryLayout.structLayout(
                    ValueLayout.JAVA_INT.withName("x"),
                    ValueLayout.JAVA_INT.withName("y")
            ));

        VarHandle xHandle = xy.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("x"));
        VarHandle yHandle = xy.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("y"));       

        try (Arena arena = Arena.ofShared()) {

            MemorySegment segment = arena.allocate(xy);
            
            xHandle.set(segment, 0L, 0, 5);
            yHandle.set(segment, 0L, 0, 9);
            xHandle.set(segment, 0L, 1, 6);
            yHandle.set(segment, 0L, 1, 8);

            // sum everything
            int sum1 = segment.elements(xy)
                    .map(t -> t.toArray(ValueLayout.JAVA_INT))
                    .flatMapToInt(t -> Arrays.stream(t))
                    .sum();

            int sum2 = segment.elements(ValueLayout.JAVA_INT).parallel()
                    .mapToInt(s -> s.get(ValueLayout.JAVA_INT, 0))
                    .sum();

            System.out.println("Sum everything: " + sum1 + "   " + sum2);
            
            // sum only the frist pair of x, y
            MethodHandle xyHandle = xy.sliceHandle(PathElement.sequenceElement());
            
            MemorySegment subsegment = (MemorySegment) xyHandle.invoke(segment, 0L, 0);
             
            int sum3 = subsegment.elements(ValueLayout.JAVA_INT).parallel()
                    .mapToInt(s -> s.get(ValueLayout.JAVA_INT, 0))
                    .sum();
            
            System.out.println("Sum the first pair of (x, y): " + sum3);
            
            // sum y from the first pair with the second pair (x, y)
            var sum4 = segment.elements(xy).parallel()
                    .map(t -> t.asSlice(4).toArray(ValueLayout.JAVA_INT)) // by offset 4 we skip the first x
                    .flatMapToInt(t -> Arrays.stream(t))
                    .sum();
            
            System.out.println("Sum y from the first pair with the second pair (x, y): " + sum4);
        }      
    }
}