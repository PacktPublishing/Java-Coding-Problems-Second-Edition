package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println(DateCheckers.fetchFirstDayOfYearV1(2020, false));
        System.out.println(DateCheckers.fetchFirstDayOfYearV1(2020, true));
        System.out.println(DateCheckers.fetchLastDayOfYearV1(2020, false));
        System.out.println(DateCheckers.fetchLastDayOfYearV1(2020, true));

        System.out.println();
        
        System.out.println(DateCheckers.fetchFirstDayOfYearV2(2020, false));
        System.out.println(DateCheckers.fetchFirstDayOfYearV2(2020, true));
        System.out.println(DateCheckers.fetchLastDayOfYearV2(2020, false));
        System.out.println(DateCheckers.fetchLastDayOfYearV2(2020, true));
    }
}
