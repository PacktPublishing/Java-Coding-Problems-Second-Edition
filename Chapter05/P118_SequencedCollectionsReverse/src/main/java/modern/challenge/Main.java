package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.Set;
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
        Collections.reverse(list); // reverse the list itself

        // JDK 21
        List<String> reversedList = list.reversed(); // return the reversed view as a new list        
       
        // LinkedList
        List<String> linkedlist = new LinkedList<>(Arrays.asList("one", "two", "three", "four", "five"));

        // before JDK 21
        Collections.reverse(linkedlist); // reverse the list itself
        
        // JDK 21
        List<String> reversedLinkedList = linkedlist.reversed(); // return the reversed view as a new linked list        
        
        // LinkedHashSet
        SequencedSet<String> linkedhashset = new LinkedHashSet<>(Arrays.asList("one", "two", "three", "four", "five"));
        
        // before JDK 21             
        // nothing to do, just to convert it to an array/arraylist and reverse that       

        // JDK 21
        SequencedSet<String> reversedLhs = linkedhashset.reversed();
                               
        // SortedSet
        SortedSet<String> sortedset = new TreeSet<>(Arrays.asList("one", "two", "three", "four", "five"));        

        // before JDK 21               
        SortedSet<String> reversedSortedSet = new TreeSet<>(sortedset).descendingSet(); // descendingIterator()     
        
        // JDK 21
        SortedSet<String> reversedSortedSetJdk21 = sortedset.reversed();                        
                                                        
        // LinkedHashMap
        SequencedMap<Integer, String> linkedhashmap = new LinkedHashMap<>();
        linkedhashmap.put(1, "one");
        linkedhashmap.put(2, "two");
        linkedhashmap.put(3, "three");
        linkedhashmap.put(4, "four");
        linkedhashmap.put(5, "five");

        // before JDK 21         
        SequencedMap<Integer, String> reversedlinkedhashmap = new LinkedHashMap<>();
        Set<Integer> setKeys = linkedhashmap.keySet(); 
        LinkedList<Integer> listKeys = new LinkedList<>(setKeys); 
        Iterator<Integer> iterator = listKeys.descendingIterator(); 
        
        while (iterator.hasNext()) {
             Integer key = iterator.next();
             reversedlinkedhashmap.put(key, linkedhashmap.get(key));
         }
                
        // JDK 21
        SequencedMap<Integer, String> reversedMap = linkedhashmap.reversed();        
                
        // SortedMap
        SortedMap<Integer, String> sortedmap = new TreeMap<>();
        sortedmap.put(1, "one");
        sortedmap.put(2, "two");
        sortedmap.put(3, "three");
        sortedmap.put(4, "four");
        sortedmap.put(5, "five");
        
        // before JDK 21
        NavigableMap<Integer, String> reversednavigablemap = ((TreeMap) sortedmap).descendingMap();        
        
        // JDK 21                
        SortedMap<Integer, String> reversedsortedmap = sortedmap.reversed();
    }
}