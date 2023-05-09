package modern.challenge;

import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface TriFunction <T1, T2, T3, R> {
    
    R apply(T1 t1, T2 t2, T3 t3);
    
    default BiFunction<T2, T3, R> applyOnly(T1 t1) {
        return (t2, t3) -> apply(t1, t2, t3);
    }
    
    default Function<T3, R> applyOnly(T1 t1, T2 t2) {
        return (t3) -> apply(t1, t2, t3);
    }
}