package modern.challenge;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public final class DateCheckers {

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static long nrOfWeeks(Date startDate, Date endDate) {

        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("The given dates cannot be null");
        }

        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("The given start date cannot be after the given end date");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        int weeks = 0;
        while (calendar.getTime().before(endDate)) {
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
            weeks++;
        }

        return weeks;
    }

    public static long nrOfWeeks(LocalDateTime startLdt1, LocalDateTime endLdt2) {

        if (startLdt1 == null || endLdt2 == null) {
            throw new IllegalArgumentException("The given dates cannot be null");
        }

        return Math.abs(ChronoUnit.WEEKS.between(startLdt1, endLdt2));
    }
}
