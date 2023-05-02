package modern.challenge;

import java.util.Collection;
import java.util.Set;
import static java.util.function.Predicate.isEqual;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public interface Streams<T> extends Stream<T> {    

    default boolean contains(T item) {
        return anyMatch(isEqual(item));
    }

    default boolean containsAll(T... items) {
        return containsAll(Stream.of(items));
    }

    default boolean containsAll(Collection<T> items) {
        return containsAll(items.stream());
    }

    default boolean containsAll(Stream<? extends T> items) {

        Set<? extends T> set = toSet(items);

        if (set.isEmpty()) {
            return true;
        }

        return filter(item -> set.remove(item))
                .anyMatch(any -> set.isEmpty());
    }

    default boolean containsAny(T... items) {
        return containsAny(Stream.of(items));
    }

    default boolean containsAny(Collection<T> items) {
        return containsAny(items.stream());
    }

    default boolean containsAny(Stream<? extends T> items) {

        Set<? extends T> set = toSet(items);

        if (set.isEmpty()) {
            return false;
        }

        return anyMatch(set::contains);
    }
    
    static <T> Streams<T> from(Stream<? extends T> stream) {
        
        if (stream == null) {
            return from(Stream.empty());
        }    
                    
        if (stream instanceof Streams) {
            return (Streams<T>) stream;
        }

        return new StreamsWrapper(stream);
    }

    static <T> Set<T> toSet(Stream<? extends T> stream) {

        return stream.collect(Collectors.toSet());
    }
}