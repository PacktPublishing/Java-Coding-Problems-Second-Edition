package modern.challenge;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta")); 
        System.out.println(DateConverters.toLocalDateTimeV1(calendar)); // ignore calendar's time zone
        System.out.println(DateConverters.toZonedDateTimeV1(calendar)); // use calendar's time zone
        System.out.println(DateConverters.toLocalDateTimeV2(calendar)); // ignore calendar's time zone
        System.out.println(DateConverters.toZonedDateTimeV2(calendar)); // use calendar's time zone
    }
}
