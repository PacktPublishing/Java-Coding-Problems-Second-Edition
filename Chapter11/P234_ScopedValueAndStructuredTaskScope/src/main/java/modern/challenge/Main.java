package modern.challenge;

import java.util.Comparator;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static final ScopedValue<String> USER = ScopedValue.newInstance();
    public static final ScopedValue<String> LOC = ScopedValue.newInstance();
    public static final ScopedValue<String> DEST = ScopedValue.newInstance();
    public static final ScopedValue<Double> CAR_ONE_DISCOUNT = ScopedValue.newInstance();
    public static final ScopedValue<Boolean> PUBLIC_TRANSPORT_TICKET = ScopedValue.newInstance();

    public static void main(String[] args) throws InterruptedException, Exception {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
        
        String user = "marcelo1978";                // login user
        String loc = "124 NW Bobcat L, St. Robert"; // collected from user
        String dest = "129 West 81st Street";       // collected from user

        TravelOffer offer;
        if (user != null && !user.isBlank()) { // is user login ?
            offer = ScopedValue.where(USER, user)
                    .call(() -> fetchTravelOffers(loc, dest));
        } else {
            offer = fetchTravelOffers(loc, dest);
        }        
    }

    public static TravelOffer fetchTravelOffers(String loc, String dest) throws Exception {

        return ScopedValue
                .where(LOC, loc)
                .where(DEST, dest)
                .call(() -> {
                    try (TravelScope scope = new TravelScope()) {

                        if (USER.isBound()) {
                            scope.fork(() -> fetchRidesharingOffers());
                        } else {
                            logger.warning("Ridesharing services can be accessed only by login users");
                        }
                        scope.fork(() -> ScopedValue.where(PUBLIC_TRANSPORT_TICKET, true)
                                .call(Main::fetchPublicTransportOffers));

                        scope.join();

                        return scope.recommendedTravelOffer();
                    }
                });
    }

    public static RidesharingOffer fetchRidesharingOffers() throws InterruptedException, Exception {

        logger.info(() -> "Ridesharing: Processing request for "
                + USER.orElseThrow(() -> new RuntimeException("Ridesharing: User not login")));

        try (StructuredTaskScope scope = new StructuredTaskScope<RidesharingOffer>()) {

            Subtask<RidesharingOffer> carOneOffer
                    = scope.fork(() -> ScopedValue.where(CAR_ONE_DISCOUNT, 0.5)
                    .call(Ridesharing::carOneServer));
            Subtask<RidesharingOffer> starCarOffer
                    = scope.fork(Ridesharing::starCarServer);
            Subtask<RidesharingOffer> topCarOffer
                    = scope.fork(Ridesharing::topCarServer);

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

    public static PublicTransportOffer fetchPublicTransportOffers() throws InterruptedException {

        logger.info(() -> "Public Transport: Processing request for " + USER.orElse("anonymous"));

        try (PublicTransportScope scope = new PublicTransportScope()) {

            scope.fork(PublicTransport::busTransportServer);
            scope.fork(PublicTransport::subwayTransportServer);
            scope.fork(PublicTransport::trainTransportServer);
            scope.fork(PublicTransport::tramTransportServer);

            scope.join();

            PublicTransportOffer offer = scope.recommendedPublicTransport();

            return offer;
        }
    }
}