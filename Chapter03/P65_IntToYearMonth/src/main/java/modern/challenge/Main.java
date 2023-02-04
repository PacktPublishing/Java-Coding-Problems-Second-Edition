package modern.challenge;

import java.text.ParseException;
import java.time.YearMonth;

public class Main {

    public static void main(String[] args) throws ParseException {

        System.out.println("YearMonth to int: " + DateConverters.to(YearMonth.now()));
        System.out.println("int to YearMonth: " + DateConverters.from(24277));     
    }
}
