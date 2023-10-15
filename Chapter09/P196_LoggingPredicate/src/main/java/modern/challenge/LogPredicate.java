package modern.challenge;

import java.util.function.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FunctionalInterface
public interface LogPredicate<T> extends Predicate<T> {

    Logger logger = LoggerFactory.getLogger(LogPredicate.class);
   
    default boolean testAndLog(T t, String val) {

        boolean result = this.test(t);

        if (!result) {
            logger.warn(t + " don't match '" + val + "'");
        }

        return result;
    }
}
