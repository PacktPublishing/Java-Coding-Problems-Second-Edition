package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.SequencedCollection;
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
        String firstl = list.get(0);              // one
        String lastl = list.get(list.size() - 1); // five

        // JDK 21
        String firstl21 = list.getFirst();        // one
        String lastl21 = list.getLast();          // five

        // LinkedList
        List<String> linkedlist = new LinkedList<>(Arrays.asList("one", "two", "three", "four", "five"));

        // before JDK 21
        String firstll = linkedlist.get(0);              // one
        String lastll = linkedlist.get(list.size() - 1); // five

        // JDK 21
        String firstll21 = linkedlist.getFirst();        // one
        String lastll21 = linkedlist.getLast();          // five
        
        // LinkedHashSet
        SequencedSet<String> linkedhashset = new LinkedHashSet<>(Arrays.asList("one", "two", "three", "four", "five"));
        
        // before JDK 21
        linkedhashset.iterator().next();
        linkedhashset.stream().findFirst().get();
        linkedhashset.stream().skip(linkedhashset.size() - 1).findFirst().get();
        String last = (String) linkedhashset.toArray()[linkedhashset.size() - 1];

        // JDK 21
        linkedhashset.getFirst();
        linkedhashset.getLast();
        
        // SortedSet
        SortedSet<String> sortedset = new TreeSet<>(Arrays.asList("one", "two", "three", "four", "five"));

        // before JDK 21
        sortedset.first();
        sortedset.last();

        // JDK 21
        sortedset.getFirst();
        sortedset.getLast();
        
        // LinkedHashMap
        SequencedMap<Integer, String> linkedhashmap = new LinkedHashMap<>();
        linkedhashmap.put(1, "one");
        linkedhashmap.put(2, "two");
        linkedhashmap.put(3, "three");
        linkedhashmap.put(4, "four");
        linkedhashmap.put(5, "five");

        // before JDK 21
        linkedhashmap.keySet().iterator().next();
        linkedhashmap.keySet().stream().findFirst().get();
        linkedhashmap.keySet().stream().skip(linkedhashmap.size() - 1).findFirst().get();
        Integer lastKeyLhm = (Integer) linkedhashmap.keySet().toArray()[linkedhashmap.size() - 1];

        linkedhashmap.values().iterator().next();
        linkedhashmap.values().stream().findFirst().get();
        linkedhashmap.values().stream().skip(linkedhashmap.size() - 1).findFirst().get();
        String lastValueLhm = (String) linkedhashmap.values().toArray()[linkedhashmap.size() - 1];

        linkedhashmap.entrySet().iterator().next();
        linkedhashmap.entrySet().stream().findFirst().get();
        linkedhashmap.entrySet().stream().skip(linkedhashmap.size() - 1).findFirst().get();
        Entry<Integer, String> lastEntryLhm = (Entry<Integer, String>) linkedhashmap.entrySet().toArray()[linkedhashmap.size() - 1];

        // JDK 21
        Entry<Integer, String> fe = linkedhashmap.firstEntry();
        Entry<Integer, String> le = linkedhashmap.lastEntry();
        
        SequencedSet<Integer> keysLinkedHashMap = linkedhashmap.sequencedKeySet();
        keysLinkedHashMap.getFirst();
        keysLinkedHashMap.getLast();

        SequencedCollection<String> valuesLinkedHashMap = linkedhashmap.sequencedValues();
        valuesLinkedHashMap.getFirst();
        valuesLinkedHashMap.getLast();

        SequencedSet<Entry<Integer, String>> entriesLinkedHashMap = linkedhashmap.sequencedEntrySet();
        entriesLinkedHashMap.getFirst();
        entriesLinkedHashMap.getLast();
                       
        // SortedMap
        SortedMap<Integer, String> sortedmap = new TreeMap<>();
        sortedmap.put(1, "one");
        sortedmap.put(2, "two");
        sortedmap.put(3, "three");
        sortedmap.put(4, "four");
        sortedmap.put(5, "five");
        
        // before JDK 21
        Integer fkey = sortedmap.firstKey();                
        String fval = sortedmap.get(fkey);
        Integer lkey = sortedmap.lastKey();        
        String lval = sortedmap.get(lkey);
                
        // JDK 21
        sortedmap.firstEntry();
        sortedmap.firstEntry().getKey();
        sortedmap.firstEntry().getValue();                
        sortedmap.lastEntry();
        sortedmap.lastEntry().getKey();
        sortedmap.lastEntry().getValue();
        
        SequencedSet<Integer> keysSortedMap = sortedmap.sequencedKeySet();
        keysSortedMap.getFirst();
        keysSortedMap.getLast();

        SequencedCollection<String> valuesSortedMap = sortedmap.sequencedValues();
        valuesSortedMap.getFirst();
        valuesSortedMap.getLast();

        SequencedSet<Entry<Integer, String>> entriesSortedMap = sortedmap.sequencedEntrySet();
        entriesSortedMap.getFirst();
        entriesSortedMap.getLast();
    }
}