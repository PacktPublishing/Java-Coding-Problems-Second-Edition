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

        SequenceLayout inner = MemoryLayout.sequenceLayout(5, ValueLayout.JAVA_DOUBLE);
        SequenceLayout outer = MemoryLayout.sequenceLayout(10, inner);

        VarHandle handle = outer.varHandle(
                PathElement.sequenceElement(),
                PathElement.sequenceElement());

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocate(outer);

            System.out.println("Outer: " + outer.elementCount());
            System.out.println("Inner: " + inner.elementCount());

            for (int i = 0; i < outer.elementCount(); i++) {
                for (int j = 0; j < inner.elementCount(); j++) {
                    handle.set(segment, i, j, Math.random());
                }
            }

            for (int i = 0; i < outer.elementCount(); i++) {
                System.out.print("\n-----" + i + "-----");
                for (int j = 0; j < inner.elementCount(); j++) {
                    System.out.printf("\nx = %.2f", handle.get(segment, i, j));
                }
            }
        }

        // reshape
        SequenceLayout reshaped = outer.reshape(25, 2);

        VarHandle rhandle = reshaped.varHandle(
                PathElement.sequenceElement(),
                PathElement.sequenceElement());

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segment = arena.allocate(reshaped);

            System.out.println("\n\nReshaped outer: " + reshaped.elementCount());
            System.out.println("Reshaped inner: " 
                    + ((SequenceLayout) reshaped.select(
                            PathElement.sequenceElement())).elementCount());

            long outerCount = reshaped.elementCount();
            long innerCount = ((SequenceLayout) reshaped.select(
                            PathElement.sequenceElement())).elementCount();            
            
            for (int i = 0; i < outerCount; i++) {
                for (int j = 0; j < innerCount; j++) {
                    rhandle.set(segment, i, j, Math.random());
                }
            }

            for (int i = 0; i < outerCount; i++) {
                System.out.print("\n-----" + i + "-----");
                for (int j = 0; j < innerCount; j++) {
                    System.out.printf("\nx = %.2f", rhandle.get(segment, i, j));
                }
            }
        }
    }
}