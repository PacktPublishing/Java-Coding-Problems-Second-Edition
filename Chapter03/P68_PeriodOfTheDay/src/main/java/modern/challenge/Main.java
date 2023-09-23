package modern.challenge;

import java.time.ZoneId;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println(ZoneId.getAvailableZoneIds());

        System.out.println();

        // Africa/Johannesburg
        System.out.println("Good "
                + DateConverters.toDayPeriodV1(new Date(), ZoneId.of("Africa/Johannesburg"))
                + ", Africa/Johannesburg");
        System.out.println("Africa/Johannesburg: "
                + DateConverters.toDayPeriodV2(new Date(), ZoneId.of("Africa/Johannesburg")));

        System.out.println();

        // Asia/Saigon
        System.out.println("Good "
                + DateConverters.toDayPeriodV1(new Date(), ZoneId.of("Asia/Saigon"))
                + ", Asia/Saigon");
        System.out.println("Asia/Saigon: "
                + DateConverters.toDayPeriodV2(new Date(), ZoneId.of("Asia/Saigon")));

        System.out.println();

        // Australia/Melbourne
        System.out.println("Good "
                + DateConverters.toDayPeriodV1(new Date(), ZoneId.of("Australia/Melbourne"))
                + ", Australia/Melbourne");
        System.out.println("Australia/Melbourne: "
                + DateConverters.toDayPeriodV2(new Date(), ZoneId.of("Australia/Melbourne")));

        System.out.println();

        // America/Resolute
        System.out.println("Good "
                + DateConverters.toDayPeriodV1(new Date(), ZoneId.of("America/Resolute"))
                + ", America/Resolute");
        System.out.println("America/Resolute: "
                + DateConverters.toDayPeriodV2(new Date(), ZoneId.of("America/Resolute")));
        
        System.out.println();
        
        //  America/Argentina/Buenos_Aires
        System.out.println("Good "
                + DateConverters.toDayPeriodV1(new Date(), ZoneId.of("America/Argentina/Buenos_Aires"))
                + ", America/Argentina/Buenos_Aires");
        System.out.println("America/Argentina/Buenos_Aires: "
                + DateConverters.toDayPeriodV2(new Date(), ZoneId.of("America/Argentina/Buenos_Aires")));
        
        // print hour-by-hour
        System.out.println();
        DateConverters.printToDayPeriod();
    }
}