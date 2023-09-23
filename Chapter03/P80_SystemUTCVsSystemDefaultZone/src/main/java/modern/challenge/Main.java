package modern.challenge;

import java.time.Clock;
import static java.time.Clock.system;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {

        System.out.println(Clock.systemDefaultZone());       
        System.out.println(system(ZoneId.systemDefault()));        
        System.out.println(Clock.systemUTC());
        
        System.out.println();
        
        System.out.println(Clock.systemDefaultZone().instant());
        System.out.println(system(ZoneId.systemDefault()).instant());        
        System.out.println(Clock.systemUTC().instant());
        
        System.out.println();
        
        System.out.println(LocalDateTime.now(Clock.systemUTC()));
        System.out.println(LocalDateTime.now(Clock.systemDefaultZone()));       
        System.out.println(LocalDateTime.now(system(ZoneId.systemDefault())));       
    }
}