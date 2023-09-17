package modern.challenge;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // before JDK 19
        Locale roDep = new Locale("ro", "RO");
        Locale deDep = new Locale("de", "DE"); // or, Locale de = Locale.GERMANY;
        System.out.println("roDep: " + roDep);
        System.out.println("deDep: " + deDep);

        // via Locale.Builder
        Locale aLocale = new Locale.Builder().setLanguage("ro").setRegion("RO").build();
        System.out.println("Locale via Locale.Builder: " + aLocale);

        // via Locale#forLanguageTag()
        Locale bLocale = Locale.forLanguageTag("zh-cmn-Hans-CN");
        System.out.println("Locale via Locale#forLanguageTag(): " + bLocale);

        // creating language ranges
        Locale.LanguageRange lr1 = new Locale.LanguageRange("de-*", 1.0);
        Locale.LanguageRange lr2 = new Locale.LanguageRange("ro-RO", 0.5);
        Locale.LanguageRange lr3 = new Locale.LanguageRange("en-*", 0.0);
        System.out.println("Language range (1): " + lr1);
        System.out.println("Language range (2): " + lr2);
        System.out.println("Language range (3): " + lr3);

        // creating priority list
        String rangeString = "es-ES;q=1.0,es-MX;q=0.5,pt-BR;q=0.0";
        List<Locale.LanguageRange> priorityList = Locale.LanguageRange.parse(rangeString);
        System.out.println("Priority list: " + priorityList);
        
        // JDK 19+, creating a Locale via of()        
        Locale ro = Locale.of("ro", "RO");
        Locale de = Locale.of("de", "DE"); // or, Locale de = Locale.GERMANY;

        DateFormat rodf = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, ro);
        DateFormat dedf = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, de);

        System.out.println("Locale:" + ro + " Date:" + rodf.format(new Date()));
        System.out.println("Locale:" + de + " Date:" + dedf.format(new Date()));
    }
}