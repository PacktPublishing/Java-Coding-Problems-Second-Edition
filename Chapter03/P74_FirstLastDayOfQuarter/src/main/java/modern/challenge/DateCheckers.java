package modern.challenge;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.IsoFields;
import static java.time.temporal.IsoFields.QUARTER_OF_YEAR;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public final class DateCheckers {

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Quarter quarterDaysV1(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate firstDay = localDate.with(IsoFields.DAY_OF_QUARTER, 1L);

        // or, like this
        // LocalDate firstDay = localDate.with(localDate.getMonth().firstMonthOfQuarter())
        //        .with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDay = firstDay.plusMonths(2)
                .with(TemporalAdjusters.lastDayOfMonth());

        return new Quarter(
                Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant())
        );
    }

    public static Quarter quarterDaysV2(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // first day
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3);
        Date firstDay = calendar.getTime();

        // last day
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3 + 2);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDay = calendar.getTime();

        return new Quarter(firstDay, lastDay);
    }

    public static Quarter quarterDaysV3(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        int year = localDate.getYear();
        int quarter = localDate.get(QUARTER_OF_YEAR);

        LocalDate firstDay = YearMonth.of(year, 1).with(QUARTER_OF_YEAR, quarter).atDay(1);
        LocalDate lastDay = YearMonth.of(year, 3).with(QUARTER_OF_YEAR, quarter).atEndOfMonth();

        return new Quarter(
                Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant())
        );
    }
}
