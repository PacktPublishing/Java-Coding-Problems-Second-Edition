package modern.challenge;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class DateCheckers {
    
    public static final int PREGNANCY_WEEKS = 40;
    public static final int PREGNANCY_DAYS = PREGNANCY_WEEKS * 7;

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void pregnancyCalculator(LocalDate firstDay) {
        
        firstDay = firstDay.plusDays(PREGNANCY_DAYS);        
        System.out.println("Due date: " + firstDay);
        
        LocalDate today = LocalDate.now();
        long betweenDays = Math.abs(ChronoUnit.DAYS.between(firstDay, today));
        
        long diffDays = PREGNANCY_DAYS - betweenDays;

        long weekNr = diffDays / 7;
        long weekPart = diffDays % 7;

        String week = weekNr + " | " + weekPart;

        System.out.println("Days remaining: " + betweenDays);
        System.out.println("Days in: " + diffDays);
        System.out.println("Week: " + week);        
    }
}