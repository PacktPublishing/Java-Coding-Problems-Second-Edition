package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
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

        try (Arena arena = Arena.ofConfined()) {

            MemorySegment segment = arena.allocate(npStruct);

            System.out.println("\nNo padding struct size in bytes: " + segment.byteSize());

            xnHandle.set(segment, 0L, 23); // offset 0
            ynHandle.set(segment, 0L, 54); // offset 4

            System.out.println();
            System.out.println("Offset 0: " + segment.get(ValueLayout.JAVA_INT, 0));
            System.out.println("Offset 4: " + segment.get(ValueLayout.JAVA_INT, 4));
        }

        System.out.println("--------------------------------------------------");

        System.out.println("\nStruct with two padding of 4 bytes");
        System.out.println("--------------------------------------------------");

        StructLayout wpStruct = MemoryLayout.structLayout(
                MemoryLayout.paddingLayout(4), // 4 bytes
                ValueLayout.JAVA_INT.withName("x"),
                MemoryLayout.paddingLayout(4), // 4 bytes
                ValueLayout.JAVA_INT.withName("y")
        );

        VarHandle xpHandle = wpStruct.varHandle(PathElement.groupElement("x"));
        VarHandle ypHandle = wpStruct.varHandle(PathElement.groupElement("y"));

        try (Arena arena = Arena.ofConfined()) {

            MemorySegment segment = arena.allocate(wpStruct);

            System.out.println("\nStruct with padding size in bytes: " + segment.byteSize());

            xpHandle.set(segment, 0L, 23); // offset 4
            ypHandle.set(segment, 0L, 54); // offset 12

            System.out.println();
            System.out.println("Offset 0: " + segment.get(ValueLayout.JAVA_INT, 0));
            System.out.println("Offset 4: " + segment.get(ValueLayout.JAVA_INT, 4));
            System.out.println("Offset 8: " + segment.get(ValueLayout.JAVA_INT, 8));
            System.out.println("Offset 12: " + segment.get(ValueLayout.JAVA_INT, 12));
        }

        System.out.println("--------------------------------------------------");

        MemorySegment segmenta = Arena.ofAuto().allocate(12);
        segmenta.set(ValueLayout.JAVA_INT, 0, 1000);
        segmenta.set(ValueLayout.JAVA_CHAR, 4, 'a');
        segmenta.set(ValueLayout.JAVA_INT, 8, 2000); // try it out with 6 instead of 8

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
                                        
        VarHandle spHandle1 = product1.varHandle(PathElement.groupElement("sku"));
        VarHandle epHandle1 = product1.varHandle(PathElement.groupElement("energy"));        
        VarHandle wpHandle1 = product1.varHandle(PathElement.groupElement("weight"));
        
         try (Arena arena = Arena.ofConfined()) {
            
            MemorySegment segment = arena.allocate(product1);
                        
            spHandle1.set(segment, 0L, 10102);            
            epHandle1.set(segment, 0L, 'D');                        
            wpHandle1.set(segment, 0L, (byte) 12);            
            
            System.out.println();
            System.out.println("Sku: " + spHandle1.get(segment, 0L));
            System.out.println("Energy: " + epHandle1.get(segment, 0L));            
            System.out.println("Weight: " + wpHandle1.get(segment, 0L));
         }
        
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("----------------------Case 2----------------------");
        
        StructLayout product2 = MemoryLayout.structLayout(
                ValueLayout.JAVA_CHAR.withName("energy"),
                MemoryLayout.paddingLayout(2),
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
        
        // use arrayElementVarHandle()
        VarHandle erHandle2 = ValueLayout.JAVA_CHAR.arrayElementVarHandle();
        VarHandle srHandle2 = ValueLayout.JAVA_INT.arrayElementVarHandle();
        VarHandle wrHandle2 = ValueLayout.JAVA_BYTE.arrayElementVarHandle();
        
         try (Arena arena = Arena.ofConfined()) {
            
            MemorySegment segment = arena.allocate(product2);
                        
            erHandle2.set(segment, 0L, 0, 'D');            
            srHandle2.set(segment, 0L, 1, 10102);            
            wrHandle2.set(segment, 0L, 2, (byte) 12);            
            
            System.out.println();
            System.out.println("Energy: " + erHandle2.get(segment, 0L, 0));
            System.out.println("Sku: " + srHandle2.get(segment, 0L, 1));
            System.out.println("Weight: " + wrHandle2.get(segment, 0L, 2));
         }

        // use PathElement
        VarHandle epHandle2 = product2.varHandle(PathElement.groupElement("energy"));
        VarHandle spHandle2 = product2.varHandle(PathElement.groupElement("sku"));
        VarHandle wpHandle2 = product2.varHandle(PathElement.groupElement("weight"));
        
         try (Arena arena = Arena.ofConfined()) {
            
            MemorySegment segment = arena.allocate(product2);
                        
            epHandle2.set(segment, 0L, 'D');            
            spHandle2.set(segment, 0L, 10102);            
            wpHandle2.set(segment, 0L, (byte) 12);            
            
            System.out.println();
            System.out.println("Energy: " + epHandle2.get(segment, 0L));
            System.out.println("Sku: " + spHandle2.get(segment, 0L));
            System.out.println("Weight: " + wpHandle2.get(segment, 0L));
         }

        System.out.println("--------------------------------------------------");

        System.out.println();
        System.out.println("----------------------Case 3----------------------");

        SequenceLayout product3 = MemoryLayout.sequenceLayout(
                2, MemoryLayout.structLayout(
                        ValueLayout.JAVA_CHAR.withName("energy"),
                        MemoryLayout.paddingLayout(2), 
                        ValueLayout.JAVA_INT.withName("sku"),
                        ValueLayout.JAVA_BYTE.withName("weight"),
                        MemoryLayout.paddingLayout(3)
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

        // use PathElement
        VarHandle epHandle3 = product3.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("energy"));
        VarHandle spHandle3 = product3.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("sku"));
        VarHandle wpHandle3 = product3.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("weight"));
        
         try (Arena arena = Arena.ofConfined()) {
            
            MemorySegment segment = arena.allocate(product3);
                        
            epHandle3.set(segment, 0L, 0, 'D');            
            spHandle3.set(segment, 0L, 0, 10102);            
            wpHandle3.set(segment, 0L, 0, (byte) 12);            
            
            epHandle3.set(segment, 0L, 1, 'A');            
            spHandle3.set(segment, 0L, 1, 454402);            
            wpHandle3.set(segment, 0L, 1, (byte) 9);            
            
            System.out.println();
            System.out.println("Energy (1): " + epHandle3.get(segment, 0L, 0));
            System.out.println("Sku (1): " + spHandle3.get(segment, 0L, 0));
            System.out.println("Weight (1): " + wpHandle3.get(segment, 0L, 0));
            
            System.out.println();
            System.out.println("Energy (2): " + epHandle3.get(segment, 0L, 1));
            System.out.println("Sku (2): " + spHandle3.get(segment, 0L, 1));
            System.out.println("Weight (2): " + wpHandle3.get(segment, 0L, 1));
         }

        System.out.println("--------------------------------------------------");
        
        System.out.println();
        System.out.println("----------------------Case 4----------------------");

        StructLayout product4 = MemoryLayout.structLayout(
                ValueLayout.JAVA_BYTE.withName("weight"),
                MemoryLayout.paddingLayout(1),
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

        /* challenge yourself to use arrayElementVarHandle() or PathElement */

        System.out.println("--------------------------------------------------");
        
        System.out.println();
        System.out.println("----------------------Case 5----------------------");

        StructLayout product5 = MemoryLayout.structLayout(
                ValueLayout.JAVA_INT.withName("sku"),
                ValueLayout.JAVA_BYTE.withName("weight"),
                MemoryLayout.paddingLayout(1),
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

        /* challenge yourself to use arrayElementVarHandle() or PathElement */

        System.out.println("--------------------------------------------------");
    }
}