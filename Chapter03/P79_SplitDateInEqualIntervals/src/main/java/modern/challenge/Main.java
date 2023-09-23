package modern.challenge;

import java.time.LocalDateTime;

public class Main {
    
    public static void main(String[] args) {
                
        int n = 25;
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusYears(10);
        
        System.out.println(DateCheckers.splitInEqualIntervals(start, end, n));        
    }
}
