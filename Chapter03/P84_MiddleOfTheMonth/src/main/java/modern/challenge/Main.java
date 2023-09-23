package modern.challenge;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

      System.out.println(DateCheckers.middleOfTheMonthV1(new Date()));
      System.out.println(DateCheckers.middleOfTheMonthV2(LocalDate.now()));
    }
}
