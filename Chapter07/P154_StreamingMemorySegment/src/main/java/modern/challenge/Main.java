package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Throwable {

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
                    System.out.printf("\nx = %.5f", handle.get(segment, i, j));
                }
            }

            segment.elements(outer)
                    .map(t-> t.toArray(ValueLayout.JAVA_DOUBLE))
                    .flatMapToDouble(t -> Arrays.stream(t))
                    .filter(e -> e > 0.5)
                    .forEach(System.out::println);                                                            
        }
    }
}
