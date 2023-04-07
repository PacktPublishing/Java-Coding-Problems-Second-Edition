package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

public class Main {

    public static void main(String[] args) {

        System.out.println("Imitating a sequence layout: ");

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = MemorySegment.allocateNative(
                    ValueLayout.JAVA_DOUBLE.byteSize() * 10,
                    ValueLayout.JAVA_DOUBLE.byteAlignment(), arena.scope());

            for (int i = 0; i < 10; i++) {
                segment.setAtIndex(ValueLayout.JAVA_DOUBLE, i, Math.random());
            }

            for (int i = 0; i < 10; i++) {
                System.out.printf("\nx = %.2f", segment.getAtIndex(ValueLayout.JAVA_DOUBLE, i));
            }
        }

        System.out.println();
        System.out.println("\nSingle sequence layout using path element: ");

        SequenceLayout seq = MemoryLayout.sequenceLayout(
                10, ValueLayout.JAVA_DOUBLE);

        // VarHandle[varType=double, coord=[interface java.lang.foreign.MemorySegment, long]]
        VarHandle sphandle = seq.varHandle(PathElement.sequenceElement());

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocate(seq);

            System.out.println("\nSequence size in bytes: " + segment.byteSize());

            for (int i = 0; i < seq.elementCount(); i++) {
                sphandle.set(segment, i, Math.random());
            }

            for (int i = 0; i < seq.elementCount(); i++) {
                System.out.printf("\nx = %.2f", sphandle.get(segment, i));
            }
        }

        System.out.println();
        System.out.println("\nSingle sequence layout using array element: ");

        // VarHandle[varType=double, coord=[interface java.lang.foreign.MemorySegment, long]]
        VarHandle sahandle = ValueLayout.JAVA_DOUBLE.arrayElementVarHandle();

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocate(seq);

            System.out.println("\nSequence size in bytes: " + segment.byteSize());

            for (int i = 0; i < seq.elementCount(); i++) {
                sahandle.set(segment, i, Math.random());
            }

            for (int i = 0; i < seq.elementCount(); i++) {
                System.out.printf("\nx = %.2f", sahandle.get(segment, i));
            }
        }

        System.out.println();
        System.out.println("\nNested sequence layout using path element: ");

        SequenceLayout nestedseq = MemoryLayout.sequenceLayout(5,
                MemoryLayout.sequenceLayout(10, ValueLayout.JAVA_DOUBLE));

        // VarHandle[varType=double, coord=[interface java.lang.foreign.MemorySegment, long, long]]
        VarHandle nphandle = nestedseq.varHandle(
                PathElement.sequenceElement(),
                PathElement.sequenceElement());

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocate(nestedseq);

            System.out.println("\nNested sequence size in bytes: " + segment.byteSize());

            long outer = nestedseq.elementCount();
            long inner = ((SequenceLayout) nestedseq.select(PathElement.sequenceElement())).elementCount();

            for (int i = 0; i < outer; i++) {
                for (int j = 0; j < inner; j++) {
                    nphandle.set(segment, i, j, Math.random());
                }
            }

            for (int i = 0; i < outer; i++) {
                System.out.print("\n-----" + i + "-----");
                for (int j = 0; j < inner; j++) {
                    System.out.printf("\nx = %.2f", nphandle.get(segment, i, j));
                }
            }
        }

        System.out.println();
        System.out.println("\nNested sequence layout using array element: ");

        try (Arena arena = Arena.openConfined()) {
            MemorySegment segment = arena.allocate(nestedseq);

            System.out.println("\nNested sequence size in bytes: " + segment.byteSize());

            // VarHandle[varType=double, coord=[interface java.lang.foreign.MemorySegment, long, long, long]]
            VarHandle nahandle = ValueLayout.JAVA_DOUBLE.arrayElementVarHandle(5, 10);

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                    nahandle.set(segment, 0, i, j, Math.random());
                }
            }

            for (int i = 0; i < 5; i++) {
                System.out.print("\n-----" + i + "-----");
                for (int j = 0; j < 10; j++) {
                    System.out.printf("\nx = %.2f", nahandle.get(segment, 0, i, j));
                }
            }
        }

        // challenge yourself to fill with data the following layout
        SequenceLayout product = MemoryLayout.sequenceLayout(3,
                MemoryLayout.structLayout(
                        ValueLayout.JAVA_INT.withName("price"),
                        ValueLayout.JAVA_INT.withName("discount"),
                        ValueLayout.JAVA_INT.withName("weight"),
                        MemoryLayout.structLayout(
                                ValueLayout.JAVA_INT.withName("quantity"),
                                ValueLayout.JAVA_INT.withName("qrcode")).withName("detail")
                ).withName("info"));

        VarHandle priceHandle = product.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("price"));
        VarHandle discountHandle = product.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("discount"));
        VarHandle weightHandle = product.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("weight"));
        VarHandle quantityHandle = product.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("detail"),
                PathElement.groupElement("quantity"));
        VarHandle qrHandle = product.varHandle(
                PathElement.sequenceElement(), PathElement.groupElement("detail"),
                PathElement.groupElement("qrcode"));
        
        // add here the code for setting/getting data 
    }
}