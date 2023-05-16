package modern.challenge;

import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public final class Predicates {
    
    private Predicates() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    public static <T> Predicate<T> asOneAnd(Predicate<T>... predicates) {

        Predicate<T> theOneAnd = Stream.of(predicates).reduce(p -> true, Predicate::and);
        
        return theOneAnd;
    }
    
    public static <T> Predicate<T> asOneOr(Predicate<T>... predicates) {

        Predicate<T> theOneOr = Stream.of(predicates).reduce(p -> false, Predicate::or);
        
        return theOneOr;
    }
}