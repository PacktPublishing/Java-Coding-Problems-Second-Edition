package modern.challenge;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class DateConverters {

    private DateConverters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Date fromV1(int year, int week) {

        if (year <= 0 || week <= 0) {
            throw new IllegalArgumentException("Year/week cannot be 0 or negative numbers");
        }

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.WEEK_OF_YEAR, week);
        calendar.set(Calendar.DAY_OF_WEEK, 1);

        return calendar.getTime();
    }

    public static LocalDate fromV2(int year, int week) {

        if (year <= 0 || week <= 0) {
            throw new IllegalArgumentException("Year/week cannot be 0 or negative numbers");
        }

        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        return LocalDate.now()
                .withYear(year)
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 1);
    }
    
    public static int getYearV1(Date date) {
        
        if(date == null) {
            throw new IllegalArgumentException("The given name cannot be null");
        }        
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
       
        return calendar.get(Calendar.YEAR);
    }
    
    public static int getWeekV1(Date date) {
        
        if(date == null) {
            throw new IllegalArgumentException("The given name cannot be null");
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
       
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
    
    public static int getYearV2(LocalDate date) {
        
        if(date == null) {
            throw new IllegalArgumentException("The given name cannot be null");
        }
                
        return date.get(ChronoField.YEAR);
    }
    
    public static int getWeekV2(LocalDate date) {
        
        if(date == null) {
            throw new IllegalArgumentException("The given name cannot be null");
        }
          
        // return date.get(WeekFields.of(Locale.getDefault()).weekOfYear());         
        return date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }
}
