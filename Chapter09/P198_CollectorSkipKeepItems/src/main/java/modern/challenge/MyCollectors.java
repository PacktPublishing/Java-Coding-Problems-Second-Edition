package modern.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public final class MyCollectors {

    private MyCollectors() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <T> Collector<T, List<T>, List<T>> toUnmodifiableListKeep(int max) {

        return Collector.of(ArrayList::new,
                (list, value) -> {
                    if (list.size() < max) {
                        list.add(value);
                    }
                },
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                Collections::unmodifiableList);
    }

    public static <T> Collector<T, List<T>, List<T>> toUnmodifiableListSkip(int index) {

        return Collector.of(ArrayList::new,
                (list, value) -> {
                    if (list.size() >= index) {
                        list.add(value);
                    } else {
                        list.add(null);
                    }
                },
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                list -> Collections.unmodifiableList(list.subList(index, list.size())));
    }

    public static <T> Collector<T, ?, List<T>> toUnmodifiableListSkipOptimized(int index) {

        class Sublist {

            int index;
            List<T> list = new ArrayList<>();            
        }

        return Collector.of(Sublist::new,
                (sublist, value) -> {
                    if (sublist.index >= index) {
                        sublist.list.add(value);
                    } else {
                        sublist.index++;
                    }
                },
                (left, right) -> {
                    left.list.addAll(right.list);
                    left.index = left.index + right.index;
                    return left;
                },
                sublist -> Collections.unmodifiableList(sublist.list));
    }
}