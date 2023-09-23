package modern.challenge;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

       System.out.println(DateCheckers.quarterMonths(LocalDate.now()));
       
       System.out.println();
       
       System.out.println(DateCheckers.quarterMonths(1));
       System.out.println(DateCheckers.quarterMonths(2));
       System.out.println(DateCheckers.quarterMonths(3));
       System.out.println(DateCheckers.quarterMonths(4));
       
       System.out.println();
       
       System.out.println(DateCheckers.quarterMonths("Q1"));
       System.out.println(DateCheckers.quarterMonths("Q2"));
       System.out.println(DateCheckers.quarterMonths("Q3"));
       System.out.println(DateCheckers.quarterMonths("Q4"));
    }
}
