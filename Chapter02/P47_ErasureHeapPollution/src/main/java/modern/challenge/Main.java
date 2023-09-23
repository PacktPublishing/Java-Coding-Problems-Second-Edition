package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        Main.listOf(ints, 1, 2, 3);
        
        Main.listsOfYeak(ints);
    }

    // @SuppressWarnings({"unchecked", "varargs"})
    @SafeVarargs
    public static <T> void listOf(List<T> list, T... ts) {

        list.addAll(Arrays.asList(ts));    
    }
        
    // don't use @SafeVarargs in such cases
    public static void listsOfYeak(List<Integer>... lists) {
        
    Object[] listsAsArray = lists;     
    
    listsAsArray[0] = Arrays.asList(4, 5, 6);        
    Integer someInt = lists[0].get(0);   
    
    listsAsArray[0] = Arrays.asList("a", "b", "c");    
    Integer someIntYeak = lists[0].get(0);   // ClassCastException
  }
}