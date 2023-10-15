package modern.challenge;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class Streams {

    private Streams() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <K, T> Collector<T, ?, Map<K, T>> distinctByKeyV1(
            Function<? super T, ? extends K> function) {

        return Collectors.toMap(function, Function.identity(), (t1, t2) -> t1);
    }

    public static <T> Predicate<T> distinctByKeyV2(Function<? super T, ?> function) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();

        return t -> seen.putIfAbsent(function.apply(t), Boolean.TRUE) == null;
    }

    public static <T> Predicate<T> distinctByKeyV3(Function<? super T, ?> function) {

        Set<Object> seen = ConcurrentHashMap.newKeySet();

        return t -> seen.add(function.apply(t));
    }
}