package modern.challenge;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, 2023);
        c1.set(Calendar.MONTH, 2);
        c1.set(Calendar.WEEK_OF_MONTH, 1);      
        
        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.YEAR, 2023);
        c2.set(Calendar.MONTH, 4);
        c2.set(Calendar.WEEK_OF_MONTH, 2);                
        
        System.out.println(DateCheckers.nrOfWeeks(c1.getTime(), c2.getTime()));        

        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = ldt1.minusWeeks(10);
        LocalDateTime ldt3 = ldt2.plusWeeks(10);
        LocalDateTime ldt4 = ldt2.minusWeeks(10);

        System.out.println();
        System.out.println(DateCheckers.nrOfWeeks(ldt1, ldt2));
        System.out.println(DateCheckers.nrOfWeeks(ldt2, ldt1));
        System.out.println(DateCheckers.nrOfWeeks(ldt1, ldt3));
        System.out.println(DateCheckers.nrOfWeeks(ldt3, ldt2));
        System.out.println(DateCheckers.nrOfWeeks(ldt4, ldt1));
        System.out.println(DateCheckers.nrOfWeeks(ldt3, ldt4));
    }
}
