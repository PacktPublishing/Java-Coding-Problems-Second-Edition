package modern.challenge;

import java.util.function.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Predicates {

    private static final Logger logger = LoggerFactory.getLogger(LogPredicate.class);

    private Predicates() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <T> Predicate<T> testAndLog(Predicate<? super T> predicate, String val) {

        return t -> {
            boolean result = predicate.test(t);

            if (!result) {
                logger.warn(predicate + " don't match '" + val + "'");
            }

            return result;
        };
    }
}