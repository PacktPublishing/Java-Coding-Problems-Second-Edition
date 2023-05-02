package modern.challenge;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsWrapper<T> implements Streams<T> {

    private final Stream<T> delegator;

    public StreamsWrapper(Stream<T> delegator) {
        this.delegator = delegator;
    }

    @Override
    public Stream<T> filter(Predicate<? super T> predicate) {
        return delegator.filter(predicate);
    }

    @Override
    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return delegator.map(mapper);
    }

    @Override
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return delegator.mapToInt(mapper);
    }

    @Override
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return delegator.mapToLong(mapper);
    }

    @Override
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return delegator.mapToDouble(mapper);
    }

    @Override
    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return delegator.flatMap(mapper);
    }

    @Override
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return delegator.flatMapToInt(mapper);
    }

    @Override
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return delegator.flatMapToLong(mapper);
    }

    @Override
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return delegator.flatMapToDouble(mapper);
    }

    @Override
    public Stream<T> distinct() {
        return delegator.distinct();
    }

    @Override
    public Stream<T> sorted() {
        return delegator.sorted();
    }

    @Override
    public Stream<T> sorted(Comparator<? super T> comparator) {
        return delegator.sorted(comparator);
    }

    @Override
    public Stream<T> peek(Consumer<? super T> action) {
        return delegator.peek(action);
    }

    @Override
    public Stream<T> limit(long maxSize) {
        return delegator.limit(maxSize);
    }

    @Override
    public Stream<T> skip(long n) {
        return delegator.skip(n);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        delegator.forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {
        delegator.forEachOrdered(action);
    }

    @Override
    public Object[] toArray() {
        return delegator.toArray();
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        return delegator.toArray(generator);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return delegator.reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return delegator.reduce(accumulator);
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return delegator.reduce(identity, accumulator, combiner);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return delegator.collect(supplier, accumulator, combiner);
    }

    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return delegator.collect(collector);
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        return delegator.min(comparator);
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return delegator.max(comparator);
    }

    @Override
    public long count() {
        return delegator.count();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return delegator.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return delegator.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return delegator.noneMatch(predicate);
    }

    @Override
    public Optional<T> findFirst() {
        return delegator.findFirst();
    }

    @Override
    public Optional<T> findAny() {
        return delegator.findAny();
    }

    @Override
    public Iterator<T> iterator() {
        return delegator.iterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return delegator.spliterator();
    }

    @Override
    public boolean isParallel() {
        return delegator.isParallel();
    }

    @Override
    public Stream<T> sequential() {
        return delegator.sequential();
    }

    @Override
    public Stream<T> parallel() {
        return delegator.parallel();
    }

    @Override
    public Stream<T> unordered() {
        return delegator.unordered();
    }

    @Override
    public Stream<T> onClose(Runnable closeHandler) {
        return delegator.onClose(closeHandler);
    }

    @Override
    public void close() {
        delegator.close();
    }

}
