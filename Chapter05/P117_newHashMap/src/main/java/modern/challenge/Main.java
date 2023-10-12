package modern.challenge;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        // before JDK 19
        Map<Integer, String> map1 = new HashMap<>(4);
        map1.put(1, "1");
        map1.put(2, "2");
        map1.put(3, "3");
        // capacity: 4
        map1.put(4, "4");
        // capacity: 8

        // emulating JDK 19
        System.out.println("Emulating capacity: " + ((int) Math.ceil(4 / (double) 0.75)));
        Map<Integer, String> map2 = new HashMap<>((int) Math.ceil(4 / (double) 0.75));
        map2.put(1, "1");
        map2.put(2, "2");
        map2.put(3, "3");
        // capacity: 6
        map2.put(4, "4");
        // capacity: 6

        // JDK 19
        // Analog methods exists for HashSet, LinkedHashSet, LinkedHashMap and WeakHashMap
        Map<Integer, String> map3 = HashMap.newHashMap(4);
        map3.put(1, "1");
        map3.put(2, "2");
        map3.put(3, "3");
        // capacity: 6
        map3.put(4, "4");
        // capacity: 6
    }
}