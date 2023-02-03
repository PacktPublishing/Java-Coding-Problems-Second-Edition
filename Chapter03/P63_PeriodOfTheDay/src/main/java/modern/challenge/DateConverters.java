package modern.challenge;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public final class DateConverters {

    private DateConverters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String toDayPeriod(Date date, ZoneId zoneId) {

        Objects.requireNonNull(date, "The provided date cannot be null");
        Objects.requireNonNull(zoneId, "The provided zone id cannot be null");

        ZonedDateTime zdt = date.toInstant().atZone(zoneId);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MMM-dd'T'HH:mm:ss a Z");        

        System.out.println("Date-time to format as day period is: "
                + zdt.withZoneSameInstant(zoneId).format(formatter1));
        
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MMM-dd [B]");

        return zdt.withZoneSameInstant(zoneId).format(formatter2);
    }
}