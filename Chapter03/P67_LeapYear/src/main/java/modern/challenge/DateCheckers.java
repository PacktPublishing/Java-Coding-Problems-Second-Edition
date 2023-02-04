package modern.challenge;

import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class DateCheckers {

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isLeapYearV1(int year) {

        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        }

        return true;
    }

    public static boolean isLeapYearV2(int year) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }
    
    public static boolean isLeapYearV3(int year) {
        
        return new GregorianCalendar(year, 1, 1).isLeapYear(year);
    }
    
    public static boolean isLeapYearV4(int year) {
        
        return ((year & 3) == 0 && ((year % 25) != 0 || (year & 15) == 0));
    }
    
    public static boolean isLeapYearV5(int year) {
        
        return Year.of(year).isLeap();        
    }        
}