package modern.challenge;

import java.util.ArrayList;
import java.util.List;

public final class Logistics {

    private Logistics() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <T1, T2, T3, T4, T, R> List<R> compute(T1 t1, T2 t2, T3 t3, T4 t4, List<T> in,
            FiveFunction<T1, T2, T3, T4, T, R> f) {

        List<R> out = new ArrayList<>();

        for (T t : in) {
            out.add(f.apply(t1, t2, t3, t4, t));
        }

        return out;
    }
    
    public static <T1, T2, T3, T4, T, R> R create(T1 t1, T2 t2, T3 t3, T4 t4, T t,
                                            FiveFunction<T1, T2, T3, T4, T, R> f) {
        
        return f.apply(t1, t2, t3, t4, t);
    }
}