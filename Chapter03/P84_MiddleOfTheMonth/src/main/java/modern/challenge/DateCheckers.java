package modern.challenge;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public final class DateCheckers {

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Date middleOfTheMonthV1(Date date) {
        
        if(date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int middleDay = daysInMonth / 2;

        calendar.set(Calendar.DAY_OF_MONTH, middleDay);

        return calendar.getTime();
    }
    
    public static LocalDate middleOfTheMonthV2(LocalDate date) {
        
        if(date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }
        
        return LocalDate.of(date.getYear(), date.getMonth(), 
                date.lengthOfMonth() / 2);        
    }
}
