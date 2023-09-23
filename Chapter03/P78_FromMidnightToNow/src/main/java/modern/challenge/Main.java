package modern.challenge;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime midnight = LocalDateTime.of(now.getYear(),
                now.getMonth(), now.getDayOfMonth(), 0, 0, 0);

        System.out.println("Millis: " + ChronoUnit.MILLIS.between(midnight, now));
        System.out.println("Seconds: " + ChronoUnit.SECONDS.between(midnight, now));
        System.out.println("Minutes: " + ChronoUnit.MINUTES.between(midnight, now));
        System.out.println("Hours: " + ChronoUnit.HOURS.between(midnight, now));
    }
}
