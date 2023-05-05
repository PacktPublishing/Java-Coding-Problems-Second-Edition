package modern.challenge;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Filters {

    private Filters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <K, V> Map<K, V> byKey(Map<K, V> map, Predicate<K> predicate) {

        return map.entrySet()
                .stream()
                .filter(item -> predicate.test(item.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    
    public static <K, V> Map<K, V> sortedByKey(Map<K, V> map, Predicate<K> predicate, Comparator<K> c) {

        return map.entrySet()
                .stream()
                .filter(item -> predicate.test(item.getKey()))
                .sorted(Map.Entry.comparingByKey(c))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (c1, c2) -> c2, LinkedHashMap::new));
    }

    public static <K, V> Map<K, V> byValue(Map<K, V> map, Predicate<V> predicate) {

        return map.entrySet()
                .stream()
                .filter(item -> predicate.test(item.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> sortedbyValue(Map<K, V> map, Predicate<V> predicate, Comparator<V> c) {

        return map.entrySet()
                .stream()
                .filter(item -> predicate.test(item.getValue()))
                .sorted(Map.Entry.comparingByValue(c))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (c1, c2) -> c2, LinkedHashMap::new));
    }
}