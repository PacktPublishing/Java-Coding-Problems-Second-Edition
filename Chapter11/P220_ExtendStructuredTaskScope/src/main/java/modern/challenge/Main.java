package modern.challenge;

import java.util.Comparator;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import java.util.stream.Stream;
import jdk.incubator.concurrent.StructuredTaskScope;

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

            Future<RidesharingOffer> carOneOffer
                    = scope.fork(() -> Ridesharing.carOneServer(loc, dest));
            Future<RidesharingOffer> starCarOffer
                    = scope.fork(() -> Ridesharing.starCarServer(loc, dest));
            Future<RidesharingOffer> topCarOffer
                    = scope.fork(() -> Ridesharing.topCarServer(loc, dest));

            scope.join();

            RidesharingOffer offer = Stream.of(carOneOffer, starCarOffer, topCarOffer)
                    .filter(f -> f.state() == Future.State.SUCCESS)
                    .<RidesharingOffer>mapMulti((f, c) -> {
                        c.accept((RidesharingOffer) f.resultNow());
                    })
                    .min(Comparator.comparingDouble(RidesharingOffer::price))
                    .orElseThrow(() -> {
                        RidesharingException exceptionWrapper
                                = new RidesharingException("Ridesharing exception");
                        Stream.of(carOneOffer, starCarOffer, topCarOffer)
                                .filter(f -> f.state() == Future.State.FAILED)
                                .<Throwable>mapMulti((f, c) -> {
                                    c.accept(f.exceptionNow());
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