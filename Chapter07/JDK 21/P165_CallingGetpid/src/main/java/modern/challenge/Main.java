package modern.challenge;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public class Main {

    public static void main(String[] args) throws Throwable {

        // get the Linker of the underlying native platform 
        // (operating system + processor that runs the JVM)
        Linker linker = Linker.nativeLinker();
        
        // "_getpid" is part of the Universal C Runtime (UCRT) Library
        SymbolLookup libLookup = linker.defaultLookup();
        
        // find the "_getpid" foreign function
        MemorySegment segmentGetpid = libLookup.find("_getpid").get();

        // create a method handle for "_getpid"
        MethodHandle func = linker.downcallHandle(segmentGetpid,
                FunctionDescriptor.of(ValueLayout.JAVA_INT));

        // invoke the foreign function, "_getpid" and get the result
        int result = (int) func.invokeExact();       
        System.out.println(result);
    }
}