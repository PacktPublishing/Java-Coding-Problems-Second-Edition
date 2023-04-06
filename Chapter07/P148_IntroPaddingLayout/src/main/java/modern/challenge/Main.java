package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentScope;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

public class Main {

    public static void main(String[] args) {

        System.out.println("No padding struct");
        System.out.println("--------------------------------------------------");

        StructLayout npStruct = MemoryLayout.structLayout(
                ValueLayout.JAVA_INT.withName("x"),
                ValueLayout.JAVA_INT.withName("y")
        );

        VarHandle xnHandle = npStruct.varHandle(PathElement.groupElement("x"));
        VarHandle ynHandle = npStruct.varHandle(PathElement.groupElement("y"));

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocate(npStruct);

            System.out.println("\nNo padding struct size in bytes: " + segment.byteSize());

            xnHandle.set(segment, 23); // offset 0
            ynHandle.set(segment, 54); // offset 4

            System.out.println();
            System.out.println("Offset 0: " + segment.get(ValueLayout.JAVA_INT, 0));
            System.out.println("Offset 4: " + segment.get(ValueLayout.JAVA_INT, 4));
        }

        System.out.println("--------------------------------------------------");

        System.out.println("\nStruct with two padding of 4 bytes");
        System.out.println("--------------------------------------------------");

        StructLayout wpStruct = MemoryLayout.structLayout(
                MemoryLayout.paddingLayout(32), // 32 bits, so 4 bytes
                ValueLayout.JAVA_INT.withName("x"),
                MemoryLayout.paddingLayout(32), // 32 bits, so 4 bytes
                ValueLayout.JAVA_INT.withName("y")
        );

        VarHandle xpHandle = wpStruct.varHandle(PathElement.groupElement("x"));
        VarHandle ypHandle = wpStruct.varHandle(PathElement.groupElement("y"));

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocate(wpStruct);

            System.out.println("\nStruct with padding size in bytes: " + segment.byteSize());

            xpHandle.set(segment, 23); // offset 4
            ypHandle.set(segment, 54); // offset 12

            System.out.println();
            System.out.println("Offset 0: " + segment.get(ValueLayout.JAVA_INT, 0));
            System.out.println("Offset 4: " + segment.get(ValueLayout.JAVA_INT, 4));
            System.out.println("Offset 8: " + segment.get(ValueLayout.JAVA_INT, 8));
            System.out.println("Offset 12: " + segment.get(ValueLayout.JAVA_INT, 12));
        }

        System.out.println("--------------------------------------------------");

        MemorySegment segment = MemorySegment.allocateNative(12, SegmentScope.auto());
        segment.set(ValueLayout.JAVA_INT, 0, 1000);
        segment.set(ValueLayout.JAVA_CHAR, 4, 'a');
        segment.set(ValueLayout.JAVA_INT, 8, 2000); // try it out with 6 instead of 8

        System.out.println("\nStruct with padding for fixing alignment");
        System.out.println("----------------------Case 1----------------------");

        StructLayout product1
                = MemoryLayout.structLayout(
                        ValueLayout.JAVA_INT.withName("sku"),
                        ValueLayout.JAVA_CHAR.withName("energy"),
                        ValueLayout.JAVA_BYTE.withName("weight"));

        System.out.println("Size: " + product1.byteSize());
        System.out.println("Alignment: " + product1.byteAlignment());

        System.out.println("Sku byte offset: "
                + product1.byteOffset(PathElement.groupElement("sku")));
        System.out.println("Energy byte offset: "
                + product1.byteOffset(PathElement.groupElement("energy")));
        System.out.println("Weight byte offset: "
                + product1.byteOffset(PathElement.groupElement("weight")));

        // VarHandle sHansdle = product1.varHandle(PathElement.groupElement("sku"));
        // VarHandle eHansdle = product1.varHandle(PathElement.groupElement("energy"));
        // VarHandle wHansdle = product1.varHandle(PathElement.groupElement("weight"));                                
        
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("----------------------Case 2----------------------");

        StructLayout product2 = MemoryLayout.structLayout(
                ValueLayout.JAVA_CHAR.withName("energy"),
                MemoryLayout.paddingLayout(16),
                ValueLayout.JAVA_INT.withName("sku"),
                ValueLayout.JAVA_BYTE.withName("weight")
        );

        System.out.println("Size: " + product2.byteSize());
        System.out.println("Alignment: " + product2.byteAlignment());

        System.out.println("Energy byte offset: "
                + product2.byteOffset(PathElement.groupElement("energy")));
        System.out.println("Sku byte offset: "
                + product2.byteOffset(PathElement.groupElement("sku")));
        System.out.println("Weight byte offset: "
                + product2.byteOffset(PathElement.groupElement("weight")));

        // VarHandle eHansdle = product2.varHandle(PathElement.groupElement("energy"));
        // VarHandle sHansdle = product2.varHandle(PathElement.groupElement("sku"));
        // VarHandle wHansdle = product2.varHandle(PathElement.groupElement("weight"));

        System.out.println("--------------------------------------------------");

        System.out.println();
        System.out.println("----------------------Case 3----------------------");

        SequenceLayout product3 = MemoryLayout.sequenceLayout(
                2, MemoryLayout.structLayout(
                        ValueLayout.JAVA_CHAR.withName("energy"),
                        MemoryLayout.paddingLayout(16),  // 2 bytes (16 bits)
                        ValueLayout.JAVA_INT.withName("sku"),
                        ValueLayout.JAVA_BYTE.withName("weight"),
                        MemoryLayout.paddingLayout(24)   // 3 bytes (24 bits)
                ));

        System.out.println("Size: " + product3.byteSize());
        System.out.println("Alignment: " + product3.byteAlignment());

        System.out.println("Energy byte offset (0): "
                + product3.byteOffset(
                        PathElement.sequenceElement(0), PathElement.groupElement("energy")));
        System.out.println("Energy byte offset (1): "
                + product3.byteOffset(
                        PathElement.sequenceElement(1), PathElement.groupElement("energy")));
        System.out.println("Sku byte offset (0): "
                + product3.byteOffset(
                        PathElement.sequenceElement(0), PathElement.groupElement("sku")));
        System.out.println("Sku byte offset (1): "
                + product3.byteOffset(
                        PathElement.sequenceElement(1), PathElement.groupElement("sku")));
        System.out.println("Weight byte offset (0): "
                + product3.byteOffset(
                        PathElement.sequenceElement(0), PathElement.groupElement("weight")));
        System.out.println("Weight byte offset (1): "
                + product3.byteOffset(
                        PathElement.sequenceElement(1), PathElement.groupElement("weight")));
       
        // VarHandle eHansdle = product3.varHandle(
        //        PathElement.sequenceElement(), PathElement.groupElement("energy"));
        // VarHandle sHansdle = product3.varHandle(
        //        PathElement.sequenceElement(), PathElement.groupElement("sku"));
        // VarHandle wHansdle = product3.varHandle(
        //        PathElement.sequenceElement(), PathElement.groupElement("weight"));

        System.out.println("--------------------------------------------------");
        
        System.out.println();
        System.out.println("----------------------Case 4----------------------");

        StructLayout product4 = MemoryLayout.structLayout(
                ValueLayout.JAVA_BYTE.withName("weight"),
                MemoryLayout.paddingLayout(8),  // 1 byte (8 bits)
                ValueLayout.JAVA_CHAR.withName("energy"),                
                ValueLayout.JAVA_INT.withName("sku")            
        );

        System.out.println("Size: " + product4.byteSize());
        System.out.println("Alignment: " + product4.byteAlignment());

        System.out.println("Weight byte offset: "
                + product4.byteOffset(PathElement.groupElement("weight")));
        System.out.println("Energy byte offset: "
                + product4.byteOffset(PathElement.groupElement("energy")));
        System.out.println("Sku byte offset: "
                + product4.byteOffset(PathElement.groupElement("sku")));        

        // VarHandle wHansdle = product4.varHandle(PathElement.groupElement("weight"));
        // VarHandle eHansdle = product4.varHandle(PathElement.groupElement("energy"));
        // VarHandle sHansdle = product4.varHandle(PathElement.groupElement("sku"));        

        System.out.println("--------------------------------------------------");
        
        System.out.println();
        System.out.println("----------------------Case 5----------------------");

        StructLayout product5 = MemoryLayout.structLayout(
                ValueLayout.JAVA_INT.withName("sku"),
                ValueLayout.JAVA_BYTE.withName("weight"),
                MemoryLayout.paddingLayout(8),  // 1 byte (8 bits)
                ValueLayout.JAVA_CHAR.withName("energy")                
        );

        System.out.println("Size: " + product5.byteSize());
        System.out.println("Alignment: " + product5.byteAlignment());

        System.out.println("Sku byte offset: "
                + product5.byteOffset(PathElement.groupElement("sku")));        
        System.out.println("Weight byte offset: "
                + product5.byteOffset(PathElement.groupElement("weight")));
        System.out.println("Energy byte offset: "
                + product5.byteOffset(PathElement.groupElement("energy")));        

        // VarHandle sHansdle = product5.varHandle(PathElement.groupElement("sku"));        
        // VarHandle wHansdle = product5.varHandle(PathElement.groupElement("weight"));
        // VarHandle eHansdle = product5.varHandle(PathElement.groupElement("energy"));        

        System.out.println("--------------------------------------------------");
    }
}
