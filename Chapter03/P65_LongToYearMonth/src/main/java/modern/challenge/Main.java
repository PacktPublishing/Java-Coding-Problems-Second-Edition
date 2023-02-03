package modern.challenge;

import java.text.ParseException;
import java.time.YearMonth;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        System.out.println("YearMonth to long: " + DateConverters.to(YearMonth.now()));
        System.out.println("long to YearMonth: " + DateConverters.from(24277));     
    }
}
