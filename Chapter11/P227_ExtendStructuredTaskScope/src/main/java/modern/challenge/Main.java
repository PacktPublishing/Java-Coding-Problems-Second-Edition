package modern.challenge;

import java.util.Comparator;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        String loc = "124 NW Bobcat L, St. Robert"; // collected from user
        String dest = "129 West 81st Street";       // collected from user
        
        RidesharingOffer roffer = fetchRidesharingOffers(loc, dest);
        PublicTransportOffer ptoffer = fetchPublicTransportOffers(loc, dest);
        
        logger.info(roffer.toString());
        logger.info(ptoffer.toString());
    }

    public static RidesharingOffer fetchRidesharingOffers(String loc, String dest) 
            throws InterruptedException {

        try (StructuredTaskScope scope = new StructuredTaskScope<RidesharingOffer>()) {

            Subtask<RidesharingOffer> carOneOffer
                    = scope.fork(() -> Ridesharing.carOneServer(loc, dest));
            Subtask<RidesharingOffer> starCarOffer
                    = scope.fork(() -> Ridesharing.starCarServer(loc, dest));
            Subtask<RidesharingOffer> topCarOffer
                    = scope.fork(() -> Ridesharing.topCarServer(loc, dest));

            scope.join();

            RidesharingOffer offer = Stream.of(carOneOffer, starCarOffer, topCarOffer)
                    .filter(s -> s.state() == Subtask.State.SUCCESS)
                    .<RidesharingOffer>mapMulti((s, c) -> {
                        c.accept((RidesharingOffer) s.get());
                    })
                    .min(Comparator.comparingDouble(RidesharingOffer::price))
                    .orElseThrow(() -> {
                        RidesharingException exceptionWrapper
                                = new RidesharingException("Ridesharing exception");
                        Stream.of(carOneOffer, starCarOffer, topCarOffer)
                                .filter(s -> s.state() == Subtask.State.FAILED)
                                .<Throwable>mapMulti((s, c) -> {
                                    c.accept(s.exception());
                                }).forEach(exceptionWrapper::addSuppressed);
                        throw exceptionWrapper;
                    });            

            return offer;
        }
    }

    public static PublicTransportOffer fetchPublicTransportOffers(String loc, String dest) 
            throws InterruptedException {

        try (PublicTransportScope scope = new PublicTransportScope()) {

            scope.fork(() -> PublicTransport.busTransportServer(loc, dest));
            scope.fork(() -> PublicTransport.subwayTransportServer(loc, dest));
            scope.fork(() -> PublicTransport.trainTransportServer(loc, dest));
            scope.fork(() -> PublicTransport.tramTransportServer(loc, dest));

            scope.join();

            PublicTransportOffer offer = scope.recommendedPublicTransport();           

            return offer;
        }
    }
}