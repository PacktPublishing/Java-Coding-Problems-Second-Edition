package modern.challenge;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class StreamsWrapper<T> implements Streams<T> {

    private final Stream<? extends T> delegator;

    public StreamsWrapper(Stream<? extends T> delegator) {
        this.delegator = delegator.sequential();
    }       

    @Override
    public Streams<T> filter(Predicate<? super T> predicate) {        
        return Streams.from(delegator.filter(predicate));
    }

    @Override
    public <R> Streams<R> map(Function<? super T, ? extends R> mapper) {
        return Streams.from(delegator.map(mapper));
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
    public <R> Streams<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return Streams.from(delegator.flatMap(mapper));
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
    public Streams<T> distinct() {
        return Streams.from(delegator.distinct());
    }

    @Override
    public Streams<T> sorted() {
        return Streams.from(delegator.sorted());
    }

    @Override
    public Streams<T> sorted(Comparator<? super T> comparator) {
        return Streams.from(delegator.sorted(comparator));
    }

    @Override
    public Streams<T> peek(Consumer<? super T> action) {
        return Streams.from(delegator.peek(action));
    }

    @Override
    public Streams<T> limit(long maxSize) {
        return Streams.from(delegator.limit(maxSize));
    }

    @Override
    public Streams<T> skip(long n) {
        return Streams.from(delegator.skip(n));
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
        return ((Stream<T>) delegator).reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return ((Stream<T>) delegator).reduce(accumulator);
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
        return ((Stream<T>) delegator).min(comparator);
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return ((Stream<T>) delegator).max(comparator);
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
        return ((Stream<T>) delegator).findFirst();
    }

    @Override
    public Optional<T> findAny() {
        return ((Stream<T>) delegator).findAny();
    }         

    @Override
    public List<T> toList() {
        return delegator.collect(Collectors.toList());
    }

    @Override
    public Streams<T> dropWhile(Predicate<? super T> predicate) {
        return Streams.from(delegator.dropWhile(predicate));
    }

    @Override
    public Streams<T> takeWhile(Predicate<? super T> predicate) {
        return Streams.from(delegator.takeWhile(predicate));
    }

    @Override
    public DoubleStream mapMultiToDouble(BiConsumer<? super T, ? super DoubleConsumer> mapper) {
        return delegator.mapMultiToDouble(mapper);
    }

    @Override
    public LongStream mapMultiToLong(BiConsumer<? super T, ? super LongConsumer> mapper) {
        return delegator.mapMultiToLong(mapper);
    }

    @Override
    public IntStream mapMultiToInt(BiConsumer<? super T, ? super IntConsumer> mapper) {
        return delegator.mapMultiToInt(mapper);
    }

    @Override
    public <R> Streams<R> mapMulti(BiConsumer<? super T, ? super Consumer<R>> mapper) {
        return Streams.from(delegator.mapMulti(mapper));
    }
    
       @Override
    public Iterator<T> iterator() {
        return ((Stream<T>) delegator).iterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return ((Stream<T>) delegator).spliterator();
    }    
    
    @Override
    public Streams<T> onClose(Runnable closeHandler) {
        return Streams.from(delegator.onClose(closeHandler));
    }

    @Override
    public void close() {
        delegator.close();
    }  
}