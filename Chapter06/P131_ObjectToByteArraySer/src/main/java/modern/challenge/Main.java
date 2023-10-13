package modern.challenge;

import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.lang3.SerializationUtils;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Melon melon = new Melon("Gac", 2500);
        
        byte[] melonSer = Converters.objectToBytes(melon);        
        System.out.println("Serialization: " + Arrays.toString(melonSer));
        
        System.out.println();
                
        Melon melonDeser = (Melon) Converters.bytesToObject(melonSer);        
        System.out.println("Deserialization: " + melonDeser);
        
        System.out.println();
        
        // using Apache Commons Lang
        byte[] melonSerACL = SerializationUtils.serialize(melon);
        System.out.println("Serialization (ACL): " + Arrays.toString(melonSerACL));
        
        System.out.println();
        
        Melon melonDeserACL = SerializationUtils.deserialize(melonSerACL);
        System.out.println("Deserialization (ACL): " + melonDeserACL);
    }
}