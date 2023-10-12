package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import java.util.Set;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // Map //
        /////////
        
        // before JDK 9
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java Coding Problems, First Edition");
        map.put(2, "The Complete Coding Interview Guide in Java");
        map.put(3, "jOOQ Masterclass");
        // map.put(4, null); // null values are allowed
        // map.put(null, "Java Coding Problems, Second Edition");

        Map<Integer, String> imap1 = Collections.unmodifiableMap(map);
        // imap1.put(5, "Java Coding Problems, Second Edition"); // UnsupportedOperationException

        Map<Integer, String> imap2 = Collections.unmodifiableMap(new HashMap<Integer, String>() {
            {
                put(1, "Java Coding Problems, First Edition");
                put(2, "The Complete Coding Interview Guide in Java");
                put(3, "jOOQ Masterclass");
                put(4, null);
                put(null, "Java Coding Problems, Second Edition");
            }
        });
        
        // imap2.put(5, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        
        Map<Integer, String> imap3 = Stream.of(
                entry(1, "Java Coding Problems, First Edition"),
                entry(2, "The Complete Coding Interview Guide in Java"),
                entry(3, "jOOQ Masterclass"))
                .collect(collectingAndThen(toMap(e -> e.getKey(), e -> e.getValue()), 
                        Collections::unmodifiableMap));
        
        // imap3.put(5, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        
        Map<Integer, String> imap4 = Collections.emptyMap();
        // imap4.put(1, "Java Coding Problems, First Edition"); // UnsupportedOperationException
        
        Map<Integer, String> imap5 = Collections.singletonMap(1, "Java Coding Problems, First Edition");
        // imap5.put(2, "The Complete Coding Interview Guide in Java"); // UnsupportedOperationException        

        // JDK 9+
        Map<Integer, String> imap1jdk9 = Map.of(
                1, "Java Coding Problems, First Edition",
                2, "The Complete Coding Interview Guide in Java",
                3, "jOOQ Masterclass"
        // 4, null                                      // NullPointerException
        // null, "Java Coding Problems, Second Edition" // NullPointerException
        );

        Map<Integer, String> imap2jdk9 = Map.ofEntries(
                entry(1, "Java Coding Problems, First Edition"),
                entry(2, "The Complete Coding Interview Guide in Java"),
                entry(3, "jOOQ Masterclass")
        // entry(4, null)                                      // NullPointerException
        // entry(null, "Java Coding Problems, Second Edition") // NullPointerException
        );

        // imap1jdk9.put(5, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        // imap2jdk9.put(5, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        Map<Integer, String> imap3jdk9 = Map.copyOf(imap1jdk9);
        Map<Integer, String> imap4jdk9 = Map.copyOf(map);
        System.out.println("Equal maps (1): " + (imap1jdk9 == imap3jdk9)); // true
        System.out.println("Equal maps (2): " + (imap4jdk9 == map));       // false

        Map<Integer, String> im1 = Map.of(1, "1", 2, "2");
        Map<Integer, String> im2 = Map.of(1, "1", 2, "2");
        System.out.println("Equal maps (3): " + (im1 == im2));             // false
        
        // List //
        //////////
        
        // before JDK 9
        List<String> list = new ArrayList<>();
        list.add("Java Coding Problems, First Edition");
        list.add("The Complete Coding Interview Guide in Java");
        list.add("jOOQ Masterclass");
        list.add(null); // null values are allowed        

        List<String> ilist1 = Collections.unmodifiableList(list);
        // ilist1.add(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        // ilist1.set(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException

        List<String> ilist2 = Arrays.asList(
                "Java Coding Problems, First Edition",
                "The Complete Coding Interview Guide in Java",
                "jOOQ Masterclass"
        );
                
        // ilist2.add(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        ilist2.set(0, "Java Coding Problems, Second Edition");
        
        List<String> ilist3 = Stream.of(
                "Java Coding Problems, First Edition",
                "The Complete Coding Interview Guide in Java",
                "jOOQ Masterclass")
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
        
        // ilist3.add(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        // ilist3.set(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        
        List<String> ilist4 = Collections.emptyList();
        // ilist4.add(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        // ilist4.set(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        
        List<String> ilist5 = Collections.singletonList("Java Coding Problems, First Edition");
        // ilist5.add(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        // ilist5.set(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
        
        // JDK 9+
         List<String> ilist1jdk9 = List.of(
                "Java Coding Problems, First Edition",
                "The Complete Coding Interview Guide in Java",
                "jOOQ Masterclass");
                // null); // NullPointerException
         
         // ilist1jdk9.add(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
         // ilist1jdk9.set(0, "Java Coding Problems, Second Edition"); // UnsupportedOperationException
         
         List<String> ilist2jdk9 = List.copyOf(ilist1jdk9);
         System.out.println("Equal lists: " + (ilist1jdk9 == ilist2jdk9)); // true
         
         // Set //
        //////////
        
        // before JDK 9
        Set<String> set = new HashSet<>();
        set.add("Java Coding Problems, First Edition");
        set.add("The Complete Coding Interview Guide in Java");
        set.add("jOOQ Masterclass");
        set.add(null); // null values are allowed        

        Set<String> iset1 = Collections.unmodifiableSet(set);
        // iset1.remove("Java Coding Problems, First Edition"); // UnsupportedOperationException                
        
        Set<String> iset2 = Stream.of(
                "Java Coding Problems, First Edition",
                "The Complete Coding Interview Guide in Java",
                "jOOQ Masterclass")
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
        
        // iset2.remove("Java Coding Problems, First Edition"); // UnsupportedOperationException                
 
        Set<String> iset3 = Collections.emptySet();
        // iset3.add("Java Coding Problems, First Edition"); // UnsupportedOperationException                
               
        Set<String> iset4 = Collections.singleton("Java Coding Problems, First Edition");
        // iset4.remove("Java Coding Problems, First Edition"); // UnsupportedOperationException                
               
        // JDK 9+
         Set<String> iset1jdk9 = Set.of(
                "Java Coding Problems, First Edition",
                "The Complete Coding Interview Guide in Java",
                "jOOQ Masterclass");
                // null); // NullPointerException
         
         // iset1jdk9.remove("Java Coding Problems, First Edition"); // UnsupportedOperationException                
                  
         Set<String> iset2jdk9 = Set.copyOf(iset1jdk9);
         System.out.println("Equal sets: " + (iset1jdk9 == iset2jdk9)); // true
    }
}