package modern.challenge;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import static java.util.function.Predicate.isEqual;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public interface Streams<T> {

    Stream<T> stream();

    static <T> Streams<T> from(Stream<T> stream) {
        return () -> stream;
    }

    // not used here, but it may be useful
    default <U> Streams<U> stream(Function<Stream<T>, Stream<U>> stream) {
        return from(stream.apply(stream()));
    }

    default boolean contains(T item) {
        return stream().anyMatch(isEqual(item));
    }

    default boolean containsAll(T... items) {
        return containsAll(Stream.of(items));
    }

    default boolean containsAll(List<? extends T> items) {
        return containsAll(items.stream());
    }

    default boolean containsAll(Stream<? extends T> items) {

        Set<? extends T> set = toSet(items);

        if (set.isEmpty()) {
            return true;
        }

        return stream().filter(item -> set.remove(item))
                .anyMatch(any -> set.isEmpty());
    }

    default boolean containsAny(T... items) {
        return containsAny(Stream.of(items));
    }

    default boolean containsAny(List<? extends T> items) {
        return containsAny(items.stream());
    }

    default boolean containsAny(Stream<? extends T> items) {

        Set<? extends T> set = toSet(items);

        if (set.isEmpty()) {
            return false;
        }

        return stream().anyMatch(set::contains);
    }

    static <T> Set<T> toSet(Stream<? extends T> stream) {

        return stream.collect(Collectors.toSet());
    }
}