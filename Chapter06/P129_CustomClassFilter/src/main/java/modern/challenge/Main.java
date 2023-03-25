package modern.challenge;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
    
        /* create a custom class filter and set it for all the streams of this application */
        // ObjectInputFilter.Config.setSerialFilter(new MelonFilter());
        
        Melon melon = new Melon("Gac", 2500);

        byte[] melonSer = Converters.objectToBytes(melon);
        System.out.println("Serialization: " + Arrays.toString(melonSer));

        System.out.println();

        Melon melonDeser = (Melon) Converters.bytesToObject(melonSer, new MelonFilter());
        System.out.println("Deserialization: " + melonDeser);
    }
}