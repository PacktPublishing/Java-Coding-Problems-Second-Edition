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

        String strDestination = "Hello ";
        String strSource = "World";

        Linker linker = Linker.nativeLinker();
        SymbolLookup libLookup = linker.defaultLookup();

        try (Arena arena = Arena.openConfined()) {

            MemorySegment segmentStrcat = libLookup.find("strcat").get();

            MethodHandle func = linker.downcallHandle(segmentStrcat, FunctionDescriptor.ofVoid(
                    ValueLayout.ADDRESS, ValueLayout.ADDRESS));

            MemorySegment segmentStrSource = arena.allocate(strSource.length() + 1);
            segmentStrSource.setUtf8String(0, strSource);

            MemorySegment segmentStrDestination = arena.allocate(
                    strSource.length() + 1 + strDestination.length() + 1);
            segmentStrDestination.setUtf8String(0, strDestination);

            func.invokeExact(segmentStrDestination, segmentStrSource);

            System.out.println(segmentStrDestination.getUtf8String(0));
        }
    }
}
