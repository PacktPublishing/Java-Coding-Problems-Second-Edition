package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {

        // ArrayList
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));        

        // before JDK 21        
        list.remove(0);               // remove the first element
        list.remove(list.size() - 1); // remove the last element
        // list.remove("five");

        // JDK 21
        list.removeFirst();
        list.removeLast();        
        
        // LinkedList
        List<String> linkedlist = new LinkedList<>(Arrays.asList("one", "two", "three", "four", "five"));

        // before JDK 21
        linkedlist.remove(0);
        linkedlist.remove("five");

        // JDK 21
        linkedlist.removeFirst();
        linkedlist.removeLast();        
        
        // LinkedHashSet
        SequencedSet<String> linkedhashset = new LinkedHashSet<>(Arrays.asList("one", "two", "three", "four", "five"));
        
        // before JDK 21           
        linkedhashset.remove("one");
        linkedhashset.remove("five");        
        // or, use the code for getting the first/last elements and call remove on those

        // JDK 21
        linkedhashset.removeFirst();
        linkedhashset.removeLast();
                
        // SortedSet
        SortedSet<String> sortedset = new TreeSet<>(Arrays.asList("one", "two", "three", "four", "five"));        

        // before JDK 21       
        
        String first = sortedset.first();
        sortedset.remove(first);
        String last = sortedset.last();
        sortedset.remove(last);
        
        // JDK 21
        sortedset.removeFirst();
        sortedset.removeLast();                    
               
        // LinkedHashMap
        SequencedMap<Integer, String> linkedhashmap = new LinkedHashMap<>();
        linkedhashmap.put(1, "one");
        linkedhashmap.put(2, "two");
        linkedhashmap.put(3, "three");
        linkedhashmap.put(4, "four");
        linkedhashmap.put(5, "five");

        // before JDK 21
        // linkedhashmap.remove(1);
        // linkedhashmap.remove(5, "five");
        Entry<Integer, String> firstentrylhm = linkedhashmap.entrySet().iterator().next();
        linkedhashmap.remove(firstentrylhm.getKey());
        linkedhashmap.remove(firstentrylhm.getKey(), firstentrylhm.getValue());
        Entry<Integer, String> lastEntryLhm = linkedhashmap.entrySet().stream()
                .skip(linkedhashmap.size() - 1).findFirst().get();
        linkedhashmap.remove(lastEntryLhm.getKey());
        linkedhashmap.remove(lastEntryLhm.getKey(), lastEntryLhm.getValue());

        // JDK 21
        linkedhashmap.pollFirstEntry();
        linkedhashmap.pollLastEntry();
                
        // SortedMap
        SortedMap<Integer, String> sortedmap = new TreeMap<>();
        sortedmap.put(1, "one");
        sortedmap.put(2, "two");
        sortedmap.put(3, "three");
        sortedmap.put(4, "four");
        sortedmap.put(5, "five");
        
        // before JDK 21
        // sortedmap.remove(1);
        // sortedmap.remove(5, "five");     
        Integer fkey = sortedmap.firstKey();
        String fval = sortedmap.get(fkey);  
        
        Integer lkey = sortedmap.lastKey();       
        String lval = sortedmap.get(lkey);  

        sortedmap.remove(fkey);
        sortedmap.remove(fkey, fval);
        sortedmap.remove(lkey);
        sortedmap.remove(lkey, lval);
        
        // JDK 21                
        sortedmap.pollFirstEntry();
        sortedmap.pollLastEntry();
    }
}