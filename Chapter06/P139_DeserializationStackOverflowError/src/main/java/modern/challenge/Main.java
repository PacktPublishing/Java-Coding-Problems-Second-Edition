package modern.challenge;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        // 'mapOfSets' is the object to serialize/deserialize
        HashMap<Set, Integer> mapOfSets = new HashMap<>();
        Set<Set> set = new HashSet<>();
        mapOfSets.put(set, 1);
        set.add(set);
               
        // create a filter to avoid StackOverflowError
        ObjectInputFilter filter = ObjectInputFilter.
                Config.createFilter("maxdepth=2;java.base/*;!*");
        
        byte[] mapSer = Converters.objectToBytes(mapOfSets);        
        System.out.println("Serialization: " + Arrays.toString(mapSer));
        
        System.out.println();
                
        HashMap mapDeser = (HashMap) Converters.bytesToObject(mapSer, filter);        
        System.out.println("Deserialization: " + mapDeser);        
    }
}