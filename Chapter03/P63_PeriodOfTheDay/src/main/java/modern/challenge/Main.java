package modern.challenge;

import java.time.ZoneId;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        
        System.out.println(ZoneId.getAvailableZoneIds());
        
        System.out.println();
        
        // Africa/Johannesburg
        System.out.println("Africa/Johannesburg: " 
                + DateConverters.toDayPeriod(new Date(), ZoneId.of("Africa/Johannesburg")));
        
        System.out.println();
        
        // Asia/Saigon
        System.out.println("Asia/Saigon: " 
                + DateConverters.toDayPeriod(new Date(), ZoneId.of("Asia/Saigon")));
        
        System.out.println();
        
        // America/Resolute
        System.out.println("America/Resolute: " 
                + DateConverters.toDayPeriod(new Date(), ZoneId.of("America/Resolute")));
    }
}