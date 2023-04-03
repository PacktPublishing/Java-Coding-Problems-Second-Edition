package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class Main {

    public static void main(String[] args) {
      
        try (Arena arena = Arena.openConfined()) {
            
            MemorySegment segment = arena.allocate(ValueLayout.JAVA_INT);
            
            System.out.println("Segment size: " + segment.byteSize());
            
            // VarHandle[varType=int, coord=[interface java.lang.foreign.MemorySegment, long]]
            VarHandle arrhandle = ValueLayout.JAVA_INT.arrayElementVarHandle();
            arrhandle.set(segment, 0, 50);       
            System.out.println("Value: " + arrhandle.get(segment, 0L)); 
                     
            // VarHandle[varType=int, coord=[interface java.lang.foreign.MemorySegment]]
            VarHandle viewhandle = MethodHandles.memorySegmentViewVarHandle(ValueLayout.JAVA_INT);
            viewhandle = MethodHandles.insertCoordinates(viewhandle, 1, 0);                         
            viewhandle.set(segment, 100);          
            System.out.println("Value: " + viewhandle.get(segment));            
        }        
    }
}
