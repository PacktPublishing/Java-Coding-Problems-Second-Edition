package modern.challenge;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public final class DateCheckers {

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<String> quarterMonths(LocalDate ld) {

        if (ld == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        List<String> qmonths = new ArrayList<>();

        int qmonth = Month.from(ld).firstMonthOfQuarter().getValue();

        qmonths.add(Month.of(qmonth).name());
        qmonths.add(Month.of(++qmonth).name());
        qmonths.add(Month.of(++qmonth).name());

        /*
        int qmonth = Month.from(ld).firstMonthOfQuarter().getValue();
        List<String> qmonths = IntStream.of(qmonth, ++qmonth, ++qmonth)
                .mapToObj(Month::of)
                .map(Month::name)
                .collect(Collectors.toList());
        */
        
        return qmonths;
    }

    public static List<String> quarterMonths(int quarter) {

        if (quarter < 1 || quarter > 4) {
            throw new IllegalArgumentException("Quarter can be 1, 2, 3, or 4");
        }

        List<String> qmonths = new ArrayList<>();

        int qmonth = quarter * 3 - 2;
        qmonths.add(Month.of(qmonth).name());
        qmonths.add(Month.of(++qmonth).name());
        qmonths.add(Month.of(++qmonth).name());

        /*
        int qmonth = quarter * 3 - 2;
        List<String> qmonths = IntStream.of(qmonth, ++qmonth, ++qmonth)
                .mapToObj(Month::of)
                .map(Month::name)
                .collect(Collectors.toList());
        */
        
        return qmonths;
    }

    public static List<String> quarterMonths(String quarter) {

        if (quarter == null) {
            throw new IllegalArgumentException("Quarter cannot be null");
        }

        if (quarter.isBlank() || quarter.length() != 2) {
            throw new IllegalArgumentException("Quarter cannot be empty or have the length != 2");
        }

        if (!quarter.matches("^Q([1-4])$")) {
            throw new IllegalArgumentException("Quarter values are: Q1, Q2, Q3, or Q4");
        }

        List<String> qmonths = new ArrayList<>();

        int qmonth = Integer.parseInt(quarter.replaceAll("\\D", "")) * 3 - 2;
        for (int i = 0; i < 3; i++) {
            qmonths.add(Month.of(qmonth + i).name());
        }

        /*
        int qmonth = Integer.parseInt(quarter.replaceAll("\\D", "")) * 3 - 2;
        List<String> qmonths = IntStream.of(qmonth, ++qmonth, ++qmonth)
                .mapToObj(Month::of)
                .map(Month::name)
                .collect(Collectors.toList());
        */
        
        return qmonths;
    }
}
