package modern.challenge;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Logger;
import static modern.challenge.Main.CAR_ONE_DISCOUNT;
import static modern.challenge.Main.DEST;
import static modern.challenge.Main.LOC;
import static modern.challenge.Main.USER;

public final class Ridesharing {

    private static final Logger logger = Logger.getLogger(Ridesharing.class.getName());

    public static RidesharingOffer carOneServer() {

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer) {

            int minutesToYou = rnd.nextInt(10);
            int minutesToDest = rnd.nextInt(5, 50);
            double price = minutesToYou * 0.25 + minutesToDest * 0.35;

            if (CAR_ONE_DISCOUNT.isBound()) {
                logger.info(() -> "Congrats " + USER.get()
                        + "! You have a discount of " + CAR_ONE_DISCOUNT.orElse(0.0));
                price = price - CAR_ONE_DISCOUNT.orElse(0.0);
            }

            return new RidesharingOffer("CarOne", Duration.ofMinutes(minutesToYou),
                    Duration.ofMinutes(minutesToDest), price);
        }

        throw new RidesharingException("No drivers are available at CarOne for route: "
                + LOC.get() + " -> " + DEST.get());
    }

    public static RidesharingOffer starCarServer() {

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer) {

            int minutesToYou = rnd.nextInt(10);
            int minutesToDest = rnd.nextInt(5, 50);
            double price = minutesToYou * 0.23 + minutesToDest * 0.37;

            return new RidesharingOffer("StarCar", Duration.ofMinutes(minutesToYou),
                    Duration.ofMinutes(minutesToDest), price);
        }

        throw new RidesharingException("No drivers are available at StarCar for route: "
                + LOC.get() + " -> " + DEST.get());
    }

    public static RidesharingOffer topCarServer() {

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer) {

            int minutesToYou = rnd.nextInt(10);
            int minutesToDest = rnd.nextInt(5, 50);
            double price = minutesToYou * 0.26 + minutesToDest * 0.33;

            return new RidesharingOffer("TopCar", Duration.ofMinutes(minutesToYou),
                    Duration.ofMinutes(minutesToDest), price);
        }

        throw new RidesharingException("No drivers are available at TopCar for route: "
                + LOC.get() + " -> " + DEST.get());
    }
}
