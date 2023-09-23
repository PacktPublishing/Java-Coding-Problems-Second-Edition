package modern.challenge;

import java.time.LocalDate;
import java.time.temporal.IsoFields;

public final class DateCheckers {

    private DateCheckers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static long nrOfQuarters(LocalDate startDate, LocalDate endDate) {
        
        if(startDate == null || endDate == null) {
            throw new IllegalArgumentException("The given dates cannot be null");
        }

        if(startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("The given start date cannot be after the given end date");
        }
        
        return IsoFields.QUARTER_YEARS.between(startDate, endDate);
    }
}
