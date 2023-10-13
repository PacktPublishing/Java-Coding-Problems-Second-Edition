package modern.challenge;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Melon melon = new Melon("Gac", 2500);
        
        byte[] melonSer = Converters.objectToBytes(melon);        
        System.out.println("Serialization: " + Arrays.toString(melonSer));
        
        System.out.println();
                
        Melon melonDeser = (Melon) Converters.bytesToObject(melonSer);        
        System.out.println("Deserialization: " + melonDeser);
        
        System.out.println();        
    }
}