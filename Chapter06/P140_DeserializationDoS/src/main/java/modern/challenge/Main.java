package modern.challenge;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Object> startList = new ArrayList<>();
        
        List<Object> list1 = startList;
        List<Object> list2 = new ArrayList<>();
        
        for (int i = 0; i < 101; i++) {
            
            List<Object> sublist1 = new ArrayList<>();
            List<Object> sublist2 = new ArrayList<>();
            
            sublist1.add("value: " + i);

            list1.add(sublist1);
            list1.add(sublist2);

            list2.add(sublist1);
            list2.add(sublist2);

            list1 = sublist1;
            list2 = sublist2;
        }
             
        // create a filter to prvent DoS
        ObjectInputFilter filter = ObjectInputFilter.
                Config.createFilter("maxdepth=10;java.base/*;!*");
        
        byte[] startListSer = Converters.objectToBytes(startList);        
        System.out.println("Serialization: " + Arrays.toString(startListSer));
        
        System.out.println();
                
        ArrayList startListDeser = (ArrayList) Converters.bytesToObject(startListSer, filter);        
        System.out.println("Deserialization: " + startListDeser);        
    }
}