package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.GroupLayout;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

public class Main {

    public static void main(String[] args) {
     
       GroupLayout struct = java.lang.foreign.MemoryLayout.structLayout(
             MemoryLayout.paddingLayout(32), // 32 bits, so 4 bytes
             ValueLayout.JAVA_INT.withName("x"),
             MemoryLayout.paddingLayout(32),
             ValueLayout.JAVA_INT.withName("y")
     );
       
        VarHandle xHandle = struct.varHandle(PathElement.groupElement("x"));
        VarHandle yHandle = struct.varHandle(PathElement.groupElement("y"));

        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocate(struct);                        
            
            System.out.println("\nStruct size in bytes: " + segment.byteSize());
            
            xHandle.set(segment, 23); // offset 4
            yHandle.set(segment, 54); // offset 12
            
            System.out.println("Offset 0: " + segment.get(ValueLayout.JAVA_INT, 0));
            System.out.println("Offset 4: " + segment.get(ValueLayout.JAVA_INT, 4));
            System.out.println("Offset 8: " + segment.get(ValueLayout.JAVA_INT, 8));
            System.out.println("Offset 12: " + segment.get(ValueLayout.JAVA_INT, 12));
        }
    }
}