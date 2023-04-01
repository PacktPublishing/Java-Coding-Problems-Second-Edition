package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class Main {

    public static void main(String[] args) {

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment1i = arena.allocate(ValueLayout.JAVA_INT, Integer.MAX_VALUE);
            MemorySegment segment1s = arena.allocateUtf8String("abcd");
            MemorySegment segment1d = arena.allocate(ValueLayout.JAVA_DOUBLE.byteSize(),
                    ValueLayout.JAVA_DOUBLE.byteAlignment()); // it already has arena's scope
            MemorySegment segment1a = arena.allocateArray(ValueLayout.JAVA_CHAR, "abcd".toCharArray());           
            
            segment1d.set(ValueLayout.JAVA_DOUBLE, 0, Double.MIN_VALUE);

            MemorySegment segment2i = MemorySegment.allocateNative(4, arena.scope());
            MemorySegment segment2s = MemorySegment.allocateNative(5, arena.scope());
            MemorySegment segment2d = MemorySegment.allocateNative(
                    ValueLayout.JAVA_DOUBLE.byteSize(),
                    ValueLayout.JAVA_DOUBLE.byteAlignment(), arena.scope());
            MemorySegment segment2a = MemorySegment.ofArray("abcd".toCharArray());                        

            segment2i.set(ValueLayout.JAVA_INT, 0, Integer.MAX_VALUE);
            segment2s.setUtf8String(0, "abcd");
            segment2d.set(ValueLayout.JAVA_DOUBLE, 0, Double.MAX_VALUE);
            
            System.out.println("Segment 1i: " + segment1i);
            System.out.println("Segment 1i content: " + segment1i.get(ValueLayout.JAVA_INT, 0));
            
            System.out.println("Segment 2i: " + segment2i);
            System.out.println("Segment 2i content: " + segment2i.get(ValueLayout.JAVA_INT, 0));
            
            System.out.println("Segment 1s: " + segment1s);
            System.out.println("Segment 1s content: " + segment1s.getUtf8String(0));

            System.out.println("Segment 2s: " + segment2s);
            System.out.println("Segment 2s content: " + segment2s.getUtf8String(0));
            
            System.out.println("Segment 1d: " + segment1d);
            System.out.println("Segment 1d content: " + segment1d.get(ValueLayout.JAVA_DOUBLE, 0));
            
            System.out.println("Segment 2d: " + segment2d);
            System.out.println("Segment 2d content: " + segment2d.get(ValueLayout.JAVA_DOUBLE, 0));

            System.out.println("Segment 1a: " + segment1a);
            System.out.println("Segment 1a content: " + segment1a.getAtIndex(ValueLayout.JAVA_CHAR, 0));

            System.out.println("Segment 2a: " + segment2a);
            System.out.println("Segment 2a content: " + segment2a.getAtIndex(ValueLayout.JAVA_CHAR, 0));
        }
    }
}