package modern.challenge;

import java.time.YearMonth;
import java.time.temporal.ChronoField;

public final class DateConverters {

    private DateConverters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static YearMonth from(int t) {

        return YearMonth.of(1970, 1).with(ChronoField.PROLEPTIC_MONTH, t);
    }

    public static int to(YearMonth u) {

        if (u == null) {
            throw new IllegalArgumentException("The given YearMonth cannot be null");
        }

        return (int) u.getLong(ChronoField.PROLEPTIC_MONTH);
    }
}