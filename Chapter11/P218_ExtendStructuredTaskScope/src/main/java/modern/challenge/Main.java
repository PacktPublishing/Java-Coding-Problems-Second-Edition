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

        fetchRidesharingOffers();
        fetchPublicTransportOffers();
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

            logger.info(offer.toString());

            return offer;
        }
    }

    public static PublicTransportOffer fetchPublicTransportOffers() throws InterruptedException {

        try (PublicTransportScope scope = new PublicTransportScope()) {

            scope.fork(() -> PublicTransport.busTransportServer(
                    "124 NW Bobcat L, St. Robert", "129 West 81st Street"));
            scope.fork(() -> PublicTransport.subwayTransportServer(
                    "124 NW Bobcat L, St. Robert", "129 West 81st Street"));
            scope.fork(() -> PublicTransport.trainTransportServer(
                    "124 NW Bobcat L, St. Robert", "129 West 81st Street"));
            scope.fork(() -> PublicTransport.tramTransportServer(
                    "124 NW Bobcat L, St. Robert", "129 West 81st Street"));

            scope.join();

            PublicTransportOffer offer = scope.recommendedPublicTransport();

            logger.info(offer.toString());

            return offer;
        }
    }
}
