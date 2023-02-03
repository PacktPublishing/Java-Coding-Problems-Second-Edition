package modern.challenge;

import java.text.ParseException;
import java.time.YearMonth;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        System.out.println("Date to YearMonth: " + DateConverters.toYearMonth(new Date()));
        System.out.println("YearMonth to Date: " + DateConverters.toDate(YearMonth.now()));     
    }
}
