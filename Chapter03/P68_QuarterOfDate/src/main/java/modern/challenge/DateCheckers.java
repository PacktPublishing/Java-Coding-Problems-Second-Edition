package modern.challenge;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.Calendar;
import java.util.Date;

public final class DateCheckers {

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String quarterV1(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        String[] quarters = {"Q1", "Q2", "Q3", "Q4"};

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int quarter = calendar.get(Calendar.MONTH) / 3;

        return quarters[quarter];
    }

    public static int quarterV2(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        Calendar calendar = Calendar.getInstance(); // or, new GregorianCalendar();
        calendar.setTime(date);
        return (calendar.get(Calendar.MONTH) / 3) + 1;
    }

    public static int quarterV3(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        return localDate.get(IsoFields.QUARTER_OF_YEAR);
    }

    public static String quarterV4(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                .format(DateTimeFormatter.ofPattern("QQQ")); // QQ escapes Q
    }
}
