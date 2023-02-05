package modern.challenge;

import java.time.Clock;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        System.out.println(Clock.systemDefaultZone());
        System.out.println(Clock.systemUTC());
        
        System.out.println();
        
        System.out.println(Clock.systemDefaultZone().instant());
        System.out.println(Clock.systemUTC().instant());
        
        System.out.println();
        
        System.out.println(LocalDateTime.now(Clock.systemUTC()));
        System.out.println(LocalDateTime.now(Clock.systemDefaultZone()));       
    }
}