package modern.challenge;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class DateCheckers {

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<LocalDateTime> splitInEqualIntervals(
            LocalDateTime start, LocalDateTime end, int n) {

        if (start == null || end == null) {
            throw new IllegalArgumentException("The given dates cannot be null");
        }

        if (start.isAfter(end)) {
            throw new IllegalArgumentException("The given start date must be before the given end date");
        }

        if (n <= 1) {
            throw new IllegalArgumentException("The given number of intervals must be >= 1");
        }
        
        Duration range = Duration.between(start, end);
        Duration interval = range.dividedBy(n - 1);

        List<LocalDateTime> listOfDates = new ArrayList<>();
        LocalDateTime timeline = start;
        for (int i = 0; i < n - 1; i++) {
            listOfDates.add(timeline);
            timeline = timeline.plus(interval);
        }
        listOfDates.add(end);

        return listOfDates;
    }
}