package modern.challenge;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public final class DateConverters {

    private DateConverters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static LocalDateTime toLocalDateTimeV1(Calendar calendar) {

        if (calendar == null) {
            throw new IllegalArgumentException("The given calendar cannot be null");
        }

        // for LocalDate use LocalDate.ofInstant()
        return LocalDateTime.ofInstant(calendar.toInstant(), // or, Instant.ofEpochMilli(calendar.getTimeInMillis())
                ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTimeV2(Calendar calendar) {

        if (calendar == null) {
            throw new IllegalArgumentException("The given calendar cannot be null");
        }

        Date date = calendar.getTime();
        
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static ZonedDateTime toZonedDateTimeV1(Calendar calendar) {

        if (calendar == null) {
            throw new IllegalArgumentException("The given calendar cannot be null");
        }

        return ZonedDateTime.ofInstant(calendar.toInstant(), // or, Instant.ofEpochMilli(calendar.getTimeInMillis())
                calendar.getTimeZone().toZoneId());
    }
    
    public static ZonedDateTime toZonedDateTimeV2(Calendar calendar) {

        if (calendar == null) {
            throw new IllegalArgumentException("The given calendar cannot be null");
        }

        Date date = calendar.getTime();
        
        return date.toInstant().atZone(calendar.getTimeZone().toZoneId());
    }
}