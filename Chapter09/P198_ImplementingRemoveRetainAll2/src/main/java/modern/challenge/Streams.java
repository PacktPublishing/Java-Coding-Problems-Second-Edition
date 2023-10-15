package modern.challenge;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
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

    default Streams<T> remove(T item) {
        return removeAll(item);
    }

    default Streams<T> removeAll(T... items) {
        return removeAll(Stream.of(items));
    }

    default Streams<T> removeAll(List<? extends T> items) {
        return removeAll(items.stream());
    }

    default Streams<T> removeAll(Stream<? extends T> items) {

        Set<? extends T> set = toSet(items);

        if (set.isEmpty()) {
            return this;
        }

        return from(stream().filter(item -> !set.contains(item)));
    }

    default Streams<T> retainAll(T... items) {
        return retainAll(Stream.of(items));
    }

    default Streams<T> retainAll(List<? extends T> items) {
        return retainAll(items.stream());
    }

    default Streams<T> retainAll(Stream<? extends T> items) {

        Set<? extends T> set = toSet(items);

        if (set.isEmpty()) {
            return from(Stream.empty());
        }

        return from(stream().filter(item -> set.contains(item)));
    }       

    static <T> Set<T> toSet(Stream<? extends T> stream) {

        return stream.collect(Collectors.toSet());
    }
}