package modern.challenge;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Platform;
import jnr.ffi.provider.FFIProvider;

public class Main {

    public static void main(String[] args) {

        LibraryLoader<SimpleMath> loader = FFIProvider.getSystemProvider()
                .createLibraryLoader(SimpleMath.class)
                .search("./jnr/cpp")
                .map("sumTwoInt", "_Z9sumTwoIntii");
        
        if (Platform.getNativePlatform().getOS() == Platform.OS.WINDOWS) {

            SimpleMath simpleMath = loader.load("math");                        
            
            long result = simpleMath.sumTwoInt(3, 9);

            System.out.println("Result: " + result);
        }
    }
}