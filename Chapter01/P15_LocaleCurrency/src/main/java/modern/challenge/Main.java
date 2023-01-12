package modern.challenge;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        // just a list of locales to randomly choose from
        List<Locale> myLocales = List.of(Locale.GERMANY, Locale.ITALY,
                Locale.JAPAN, Locale.TAIWAN, Locale.US);

        int rnd = ThreadLocalRandom.current().nextInt(0, myLocales.size() - 1);
        Locale.setDefault(myLocales.get(rnd));

        // prepare the date for display
        String date = LocalDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        
        // prepare the royalty for display
        NumberFormat format = NumberFormat.getCurrencyInstance(myLocales.get(rnd));
        format.setMaximumFractionDigits(format.getCurrency().getDefaultFractionDigits());                
        String royalty = format.format(122005.9565);

        System.out.println("Locale: " + myLocales.get(rnd));
        System.out.println("Date: " + date);
        System.out.println("Royalty: " + royalty);

    }
}
