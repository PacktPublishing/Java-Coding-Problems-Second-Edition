package modern.challenge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // yyyy-MM-dd
        LocalDate localDate = LocalDate.now();
        
        // HH:mm:ss
        LocalTime localTime = LocalTime.now();
        
        // yyyy-MM-dd HH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.now();
        
        // E MMM yyyy HH:mm:ss.SSSZ
        ZonedDateTime zonedDateTime = ZonedDateTime.now();  
        
        // E MMM yyyy HH:mm:ss.SSSZ
        OffsetDateTime offsetDateTime = OffsetDateTime.now();   
        
        // HH:mm:ss,Z
        OffsetTime offsetTime = OffsetTime.now();                        
        
        DateTimeFormatter formatterLocalDate = 
                DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterLocalTime = 
                DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatterLocalDateTime = 
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterZonedDateTime = 
                DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ");
        DateTimeFormatter formatterOffsetDateTime = 
                DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ");
        DateTimeFormatter formatterOffsetTime = 
                DateTimeFormatter.ofPattern("HH:mm:ss,Z");
        
        String ld1 = formatterLocalDate.format(localDate);
        String lt1 = formatterLocalTime.format(localTime);
        String ldt1 = formatterLocalDateTime.format(localDateTime);
        String zdt1 = formatterZonedDateTime.format(zonedDateTime);
        String odt1 = formatterOffsetDateTime.format(offsetDateTime);
        String ot1 = formatterOffsetTime.format(offsetTime);

        // or shortly
        String ld2 = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("y-MM-dd"));
        String lt2 = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String ldt2 = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("y-MM-dd HH:mm:ss"));
        String zdt2 = ZonedDateTime.now()
                .format(DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ"));   
        String odt2 = OffsetDateTime.now()
                .format(DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ")); 
        String ot2 = OffsetTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss,Z"));
        
        System.out.println(ld1);
        System.out.println(ld2);
        System.out.println(lt1);
        System.out.println(lt2);
        System.out.println(ldt1);
        System.out.println(ldt2);
        System.out.println(zdt1);
        System.out.println(zdt2);
        System.out.println(odt1);
        System.out.println(odt2);
        System.out.println(ot1);
        System.out.println(ot2);
        System.out.println();
        
        // change current locale
        Locale.setDefault(Locale.GERMANY);
        
        // localized date        
        String ld3 = LocalDate.now()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String ld4 = LocalDate.now()
                .format(DateTimeFormatter.ofLocalizedPattern("yMM"));
        String lt3 = LocalTime.now()
                .format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        String lt4 = LocalTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("Hm"));
        String ldt3 = LocalDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        String ldt4 = LocalDateTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("yMMHm"));
        String zdt3 = ZonedDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
        String zdt4 = ZonedDateTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("yMMHmsv"));
        String odt3 = OffsetDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        String odt4 = OffsetDateTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("yMMHms"));
        String ot3 = OffsetTime.now()
                .format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        String ot4 = OffsetTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("Hms"));
        
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date (localized date):" + ld3);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date (localized pattern):" + ld4);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Time (localized time):" + lt3);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Time (localized pattern):" + lt4);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date/Time (localized date/time):" + ldt3);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date/Time (localized pattern):" + ldt4);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Zoned Date/Time (localized date/time):" + zdt3);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Zoned Date/Time (localized pattern):" + zdt4);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Offset Date/Time (localized date/time):" + odt3);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Offset Date/Time (localized pattern):" + odt4);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Offset Time (localized time):" + ot3);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Offset Time (localized pattern):" + ot4);
        
        // change current locale
        Locale.setDefault(Locale.of("ro", "RO"));
        
        String ld5 = LocalDate.now()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String ld6 = LocalDate.now()
                .format(DateTimeFormatter.ofLocalizedPattern("yMM"));
        String lt5 = LocalTime.now()
                .format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        String lt6 = LocalTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("Hm"));
        String ldt5 = LocalDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        String ldt6 = LocalDateTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("yMMHm"));
        String zdt5 = ZonedDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
        String zdt6 = ZonedDateTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("yMMHmsv"));
        String odt5 = OffsetDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        String odt6 = OffsetDateTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("yMMHms"));        
        String ot5 = OffsetTime.now()
                .format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        String ot6 = OffsetTime.now()
                .format(DateTimeFormatter.ofLocalizedPattern("Hms"));
        
        System.out.println();
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date (localized date):" + ld5);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date (localized pattern):" + ld6);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date (localized time):" + lt5);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date (localized pattern):" + lt6);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date/Time (localized date/time):" + ldt5);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Date/Time (localized pattern):" + ldt6);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Zoned Date/Time (localized date/time):" + zdt5);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Zoned Date/Time (localized pattern):" + zdt6);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Offset Date/Time (localized date/time):" + odt5);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Offset Date/Time (localized pattern):" + odt6);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Offset Time (localized time):" + ot5);
        System.out.println("Locale:" + Locale.getDefault() 
                + " Offset Time (localized pattern):" + ot6);
    }
}