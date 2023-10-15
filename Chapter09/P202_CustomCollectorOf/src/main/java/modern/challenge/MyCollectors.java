package modern.challenge;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

public final class MyCollectors {

    private MyCollectors() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <T> Collector<T, TreeSet<T>, TreeSet<T>> toTreeSet() {

        return Collector.of(TreeSet::new, TreeSet::add,
                (left, right) -> {
                    left.addAll(right);

                    return left;
                }, Collector.Characteristics.IDENTITY_FINISH);
    }

    public static <T> Collector<T, LinkedHashSet<T>, LinkedHashSet<T>> toLinkedHashSet() {

        return Collector.of(LinkedHashSet::new, HashSet::add,
                (left, right) -> {
                    left.addAll(right);

                    return left;
                }, Collector.Characteristics.IDENTITY_FINISH);
    }

    public static <T, A, R> Collector<T, A, R> exclude(
            Predicate<T> predicate, Collector<T, A, R> collector) {
        return Collector.of(
                collector.supplier(),
                (l, r) -> {
                    if (predicate.negate().test(r)) {
                        collector.accumulator().accept(l, r);
                    }
                },
                collector.combiner(),
                collector.finisher(),
                collector.characteristics().toArray(Collector.Characteristics[]::new)
        );
    }

    public static <T, A extends T, R extends Collection<A>> Collector<T, ?, R>
            toType(Class<A> type, Supplier<R> supplier) {

        return Collector.of(supplier,
                (R r, T t) -> {
                    if (type.isInstance(t)) {
                        r.add(type.cast(t));
                    }
                },
                (R left, R right) -> {
                    left.addAll(right);

                    return left;
                },
                Collector.Characteristics.IDENTITY_FINISH
        );
    }

    public static Collector<Integer, SplayTree, SplayTree> toSplayTree() {

        return Collector.of(SplayTree::new, SplayTree::insert,
                (left, right) -> {
                    left.insertAll(right);

                    return left;
                }, Collector.Characteristics.IDENTITY_FINISH);
    }
}
