package modern.challenge;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public class Main {

    public static void main(String[] args) throws Throwable {

        String dest = "Hello ";
        String src = "World";

        Linker linker = Linker.nativeLinker();
        SymbolLookup mathLookup = linker.defaultLookup();

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segmentMath = mathLookup.find("strcat").get();

            MethodHandle func = linker.downcallHandle(segmentMath, FunctionDescriptor.ofVoid(
                    ValueLayout.ADDRESS, ValueLayout.ADDRESS));

            MemorySegment segmentSrc = arena.allocate(src.length() + 1);
            segmentSrc.setUtf8String(0, src);

            MemorySegment segmentDest = arena.allocate(src.length() + 1 + dest.length() + 1);
            segmentDest.setUtf8String(0, dest);

            func.invokeExact(segmentDest, segmentSrc);

            System.out.println("Result: " + segmentDest.getUtf8String(0));
        }
    }
}
