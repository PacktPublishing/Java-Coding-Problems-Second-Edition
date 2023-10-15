package modern.challenge;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;
import com.sun.jna.win32.StdCallFunctionMapper;

import java.lang.reflect.Method;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Main {

    private static final Map MAPPINGS;
            
    static {
        MAPPINGS = Map.of(
                Library.OPTION_FUNCTION_MAPPER,
                new StdCallFunctionMapper() {
            Map<String, String> methodNames = Map.of("sumTwoInt", "_Z9sumTwoIntii");

            @Override
            public String getFunctionName(NativeLibrary library, Method method) {
                String methodName = method.getName();
                return methodNames.get(methodName);
            }
        });
    }
    
    public static void main(String[] args) {        

        System.setProperty("jna.library.path", "./jna/cpp");

        SimpleMath math = Native.load(Platform.isWindows() 
                ? "math" : "NOT_WINDOWS", SimpleMath.class, MAPPINGS);
        
        long result = math.sumTwoInt(3, 9);
        System.out.println("Result: " + result);
    }
}