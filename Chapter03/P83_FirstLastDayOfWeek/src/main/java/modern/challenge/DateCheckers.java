package modern.challenge;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class DateCheckers {

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<String> weekBoundariesV1(int nrOfWeeks) {

        if (nrOfWeeks <= 0) {
            throw new IllegalArgumentException("The given number of weeks must be >= 1");
        }

        List<String> boundaries = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
        int nrOfDayToAdd = 0;
        DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");        
        for (int i = 0; i < nrOfWeeks; i++) {
            calendar.add(Calendar.DATE, nrOfDayToAdd);
            boundaries.add(df.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 6);
            boundaries.add(df.format(calendar.getTime()));
            nrOfDayToAdd = 1;
        }

        return boundaries;
    }

    public static List<String> weekBoundariesV2(int nrOfWeeks) {

        if (nrOfWeeks <= 0) {
            throw new IllegalArgumentException("The given number of weeks must be >= 1");
        }

        List<String> boundaries = new ArrayList<>();
        LocalDate timeline = LocalDate.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE dd/MM/yyyy");
        for (int i = 0; i < nrOfWeeks; i++) {
            boundaries.add(dtf.format(timeline.with(previousOrSame(DayOfWeek.MONDAY))));
            boundaries.add(dtf.format(timeline.with(nextOrSame(DayOfWeek.SUNDAY))));
            timeline = timeline.plusDays(7);
        }

        return boundaries;
    }
}
