package modern.challenge;

import java.util.concurrent.Future;
import java.util.logging.Logger;
import jdk.incubator.concurrent.StructuredTaskScope;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        fetchRidesharingOffers();
    }

    public static RidesharingOffer fetchRidesharingOffers() throws InterruptedException {

        try (StructuredTaskScope scope = new StructuredTaskScope<RidesharingOffer>()) {

            Future<RidesharingOffer> carOneOffer 
                    = scope.fork(() -> Ridesharing.carOneServer(
                            "124 NW Bobcat L, St. Robert", "129 West 81st Street"));                        
            Future<RidesharingOffer> starCarOffer 
                    = scope.fork(() -> Ridesharing.starCarServer(
                            "124 NW Bobcat L, St. Robert", "129 West 81st Street"));            
            Future<RidesharingOffer> topCarOffer 
                    = scope.fork(() -> Ridesharing.topCarServer(
                            "124 NW Bobcat L, St. Robert", "129 West 81st Street"));            

            scope.join();

            logger.info(() -> "CarOne offer: " + carOneOffer.exceptionNow());
            logger.info(() -> "StarCar offer: " + starCarOffer.exceptionNow());
            logger.info(() -> "TopCar offer: " + topCarOffer.exceptionNow());
            
            return carOneOffer.resultNow();
        }
    }
}