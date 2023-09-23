package modern.challenge;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        Date date = DateConverters.fromV1(2023, 10);
        System.out.println("Date: " + date);
        System.out.println("Year: " + DateConverters.getYearV1(date));
        System.out.println("Week: " + DateConverters.getWeekV1(date));
        
        System.out.println();
                
        LocalDate localDate = DateConverters.fromV2(2023, 10);
        System.out.println("LocalDate: " + localDate);
        System.out.println("Year: " + DateConverters.getYearV2(localDate));
        System.out.println("Week: " + DateConverters.getWeekV2(localDate));        
    }
}