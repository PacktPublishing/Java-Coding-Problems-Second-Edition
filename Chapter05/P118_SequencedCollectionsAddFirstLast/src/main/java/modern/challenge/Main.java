package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
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
        list.add(0, "zero"); // add on the first position
        list.add("six");     // add on the last position    

        // JDK 21
        list.addFirst("zero");
        list.addLast("six");        
      
        // LinkedList
        List<String> linkedlist = new LinkedList<>(Arrays.asList("one", "two", "three", "four", "five"));

        // before JDK 21
        linkedlist.add(0, "zero"); // add on the first position
        linkedlist.add("six");     // add on the last position

        // JDK 21
        linkedlist.addFirst("zero");
        linkedlist.addLast("six");        
        
        // LinkedHashSet
        SequencedSet<String> linkedhashset = new LinkedHashSet<>(Arrays.asList("one", "two", "three", "four", "five"));
        
        // before JDK 21     
        // cannot add on first position        
        linkedhashset.add("six");                

        // JDK 21
        linkedhashset.addFirst("zero");
        linkedhashset.addLast("six");
       
        // SortedSet
        SortedSet<String> sortedset = new TreeSet<>(Arrays.asList("one", "two", "three", "four", "five"));        

        // before JDK 21
        sortedset.add("zero"); // this will not be the first element
        sortedset.add("six"); // this will not be the last element
        
        // JDK 21
        // sortedset.addFirst("zero"); // throws UnsupportedOperationException.
        // sortedset.addLast("six");   // throws UnsupportedOperationException.                             
                
        // LinkedHashMap
        SequencedMap<Integer, String> linkedhashmap = new LinkedHashMap<>();
        linkedhashmap.put(1, "one");
        linkedhashmap.put(2, "two");
        linkedhashmap.put(3, "three");
        linkedhashmap.put(4, "four");
        linkedhashmap.put(5, "five");

        // before JDK 21
        // linkedhashmap.entrySet().add(new SimpleEntry<>(0, "zero")); // throws UnsupportedOperationException
        // linkedhashmap.entrySet().add(new SimpleEntry<>(6, "six"));  // throws UnsupportedOperationException
        
        SequencedMap<Integer, String> slinkedhashmap = new LinkedHashMap<>();
        slinkedhashmap.put(0, "zero"); // add the first entry
        slinkedhashmap.putAll(linkedhashmap);
        slinkedhashmap.put(6, "six");  // add the last entry                

        // JDK 21
        linkedhashmap.putFirst(0, "zero");
        linkedhashmap.putLast(6, "six");        
                
        // SortedMap
        SortedMap<Integer, String> sortedmap = new TreeMap<>();
        sortedmap.put(1, "one");
        sortedmap.put(2, "two");
        sortedmap.put(3, "three");
        sortedmap.put(4, "four");
        sortedmap.put(5, "five");
        
        // before JDK 21
        // nothing to do
        
        // JDK 21                
        // sortedmap.putFirst(0, "zero"); // throws UnsupportedOperationException
        // sortedmap.putLast(6, "six");   // throws UnsupportedOperationException
    }
}