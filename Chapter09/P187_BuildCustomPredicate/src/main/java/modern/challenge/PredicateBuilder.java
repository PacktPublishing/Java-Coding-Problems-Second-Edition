package modern.challenge;

import java.lang.reflect.Field;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

enum PredicateBuilder {

    GT((t, u) -> t > u),
    LT((t, u) -> t < u),
    GE((t, u) -> t >= u),
    LE((t, u) -> t <= u),
    EQ((t, u) -> t.intValue() == u.intValue()),
    NOT_EQ((t, u) -> t.intValue() != u.intValue());

    private final BiPredicate<Integer, Integer> predicate;

    private PredicateBuilder(BiPredicate<Integer, Integer> predicate) {
        this.predicate = predicate;
    }

    public <T> Predicate<T> toPredicate(Function<T, Integer> getter, int u) {
        return obj -> this.predicate.test(getter.apply(obj), u);
    }

    public static <T> Function<T, Integer> getFieldByName(Class<T> cls, String field) {
        return object -> {
            try {
                Field f = cls.getDeclaredField(field);
                f.setAccessible(true);

                return (Integer) f.get(object);
            } catch (IllegalAccessException | IllegalArgumentException
                    | NoSuchFieldException | SecurityException e) {                
                throw new RuntimeException(e);
            }
        };
    }
}