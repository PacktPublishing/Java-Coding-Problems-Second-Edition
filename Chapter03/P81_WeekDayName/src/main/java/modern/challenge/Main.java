package modern.challenge;

import java.text.DateFormatSymbols;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        String[] weekdays = new DateFormatSymbols().getWeekdays();                
        
        IntStream.range(1, weekdays.length)                 
                 .mapToObj(t -> String.format("Day: %d -> %s", t, weekdays[t]))
                 .forEach(System.out::println);          
    }
}