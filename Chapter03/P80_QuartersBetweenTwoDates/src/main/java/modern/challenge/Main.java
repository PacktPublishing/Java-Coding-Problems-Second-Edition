package modern.challenge;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

      System.out.println(DateCheckers.nrOfQuarters(LocalDate.MIN, LocalDate.MAX));
      System.out.println(DateCheckers.nrOfQuarters(
              LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1)));
      System.out.println(DateCheckers.nrOfQuarters(
              LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 1)));
    }
}
