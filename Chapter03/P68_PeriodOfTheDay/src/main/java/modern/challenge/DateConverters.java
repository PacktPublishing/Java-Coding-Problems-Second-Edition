package modern.challenge;

import java.time.Instant;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public final class DateConverters {

    private DateConverters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String toDayPeriodV1(Date date, ZoneId zoneId) {

        Objects.requireNonNull(date, "The provided date cannot be null");
        Objects.requireNonNull(zoneId, "The provided zone id cannot be null");

        LocalTime lt = date.toInstant().atZone(zoneId).toLocalTime();
       
        LocalTime night = LocalTime.of(21, 0, 0);
        LocalTime morning = LocalTime.of(6, 0, 0);
        LocalTime afternoon = LocalTime.of(12, 0, 0);
        LocalTime evening = LocalTime.of(18, 0, 0);
        LocalTime almostMidnight = LocalTime.of(23, 59, 59);
        LocalTime midnight = LocalTime.of(0, 0, 0);
        
        if((lt.isAfter(night) && lt.isBefore(almostMidnight)) 
                || lt.isAfter(midnight) && (lt.isBefore(morning))) {
            return "night";
        } else if(lt.isAfter(morning) && lt.isBefore(afternoon)) {
            return "morning";
        } else if(lt.isAfter(afternoon) && lt.isBefore(evening)) {
            return "afternoon";
        } else if(lt.isAfter(evening) && lt.isBefore(night)) {
            return "evening";
        }

        return "day";
    }

    public static String toDayPeriodV2(Date date, ZoneId zoneId) {

        Objects.requireNonNull(date, "The provided date cannot be null");
        Objects.requireNonNull(zoneId, "The provided zone id cannot be null");

        ZonedDateTime zdt = date.toInstant().atZone(zoneId);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MMM-dd'T'HH:mm:ss a Z");

        System.out.println("Date-time to format as day period is: "
                + zdt.withZoneSameInstant(zoneId).format(formatter1));

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MMM-dd [B]");

        return zdt.withZoneSameInstant(zoneId).format(formatter2);
    }
    
    public static void printToDayPeriod() {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh B");
        
        for (int h = 0; h < 24; h++)
        {
            final OffsetDateTime odt
                    = Instant.now().atOffset(ZoneOffset.UTC).withHour(h);
            
            System.out.println("Hour " + h 
                    + ": \"" + formatter.format(odt) + "\"");
        }
    }
}