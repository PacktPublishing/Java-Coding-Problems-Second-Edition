package modern.challenge;

import java.util.ArrayList;
import java.util.List;

public final class Logistics {

    private Logistics() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <T1, T2, T3, T4, X, R> List<R> compute(T1 t1, T2 t2, T3 t3, T4 t4, List<X> allX,
            FiveFunction<T1, T2, T3, T4, X, R> f) {

        List<R> allY = new ArrayList<>();

        for (X x : allX) {
            allY.add(f.apply(t1, t2, t3, t4, x));
        }

        return allY;
    }
    
    public static <T1, T2, T3, T4, X, R> R create(T1 t1, T2 t2, T3 t3, T4 t4, X x,
                                            FiveFunction<T1, T2, T3, T4, X, R> f) {
        
        return f.apply(t1, t2, t3, t4, x);
    }
}