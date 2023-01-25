package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {    

    public static void main(String[] args) {
         
        Integer x1 = 14;
        Integer y1 = 14;
        
        System.out.println(x1 == y1); // true
        System.out.println(x1.equals(y1)); // true
        
        Integer x2 = 129;
        Integer y2 = 129;
        
        System.out.println(x2 == y2); // false
        System.out.println(x2.equals(y2)); // true
        
        System.out.println();
        
        // don't do this
        List<Integer> listOfInt1 = new ArrayList<>(Arrays.asList(x1, y1, x2, y2));
        System.out.println(listOfInt1);                
        listOfInt1.removeIf(t -> t == x1 || t == x2);        
        System.out.println(listOfInt1);
        
        System.out.println();
        
        // do this
        List<Integer> listOfInt2 = new ArrayList<>(Arrays.asList(x1, y1, x2, y2));
        System.out.println(listOfInt2);               
        listOfInt2.removeIf(t -> t.equals(x1) || t.equals(x2));        
        System.out.println(listOfInt2);                
    }
}
