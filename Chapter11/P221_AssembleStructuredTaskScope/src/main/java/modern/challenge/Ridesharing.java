package modern.challenge;

import java.time.Duration;
import java.util.Random;

public final class Ridesharing {        
    
    public static RidesharingOffer carOneServer(String loc, String dest) {
        
        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();
        
        if(makeAnOffer) {
            
            int minutesToYou = rnd.nextInt(10);
            int minutesToDest = rnd.nextInt(5, 50);
            double price = minutesToYou * 0.25 + minutesToDest * 0.35;
            
            return new RidesharingOffer("CarOne", Duration.ofMinutes(minutesToYou), 
                    Duration.ofMinutes(minutesToDest), price);
        }
        
        throw new RidesharingException("No drivers are available at CarOne for route: " + loc + " -> " + dest);
    }
    
    public static RidesharingOffer starCarServer(String loc, String dest) {
        
        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();
        
        if(makeAnOffer) {
            
            int minutesToYou = rnd.nextInt(10);
            int minutesToDest = rnd.nextInt(5, 50);
            double price = minutesToYou * 0.23 + minutesToDest * 0.37;
            
            return new RidesharingOffer("StarCar", Duration.ofMinutes(minutesToYou), 
                    Duration.ofMinutes(minutesToDest), price);
        }
        
        throw new RidesharingException("No drivers are available at StarCar for route: " + loc + " -> " + dest);
    }
    
    public static RidesharingOffer topCarServer(String loc, String dest) {
        
        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();
        
        if(makeAnOffer) {
            
            int minutesToYou = rnd.nextInt(10);
            int minutesToDest = rnd.nextInt(5, 50);
            double price = minutesToYou * 0.26 + minutesToDest * 0.33;
            
            return new RidesharingOffer("TopCar", Duration.ofMinutes(minutesToYou), 
                    Duration.ofMinutes(minutesToDest), price);
        }
        
        throw new RidesharingException("No drivers are available at TopCar for route: " + loc + " -> " + dest);
    }
}