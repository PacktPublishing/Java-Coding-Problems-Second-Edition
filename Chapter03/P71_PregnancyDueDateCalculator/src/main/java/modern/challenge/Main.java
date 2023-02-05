package modern.challenge;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

       DateCheckers.pregnancyCalculator(LocalDate.now().minusDays(100));
    }
}
