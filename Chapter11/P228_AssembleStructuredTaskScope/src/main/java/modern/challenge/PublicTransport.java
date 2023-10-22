package modern.challenge;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class PublicTransport {

    public static List<PublicTransportOffer> busTransportServer(String loc, String dest) {

        List<PublicTransportOffer> listOfOffers = new ArrayList<>();

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer) {

            for (int i = 0; i < rnd.nextInt(10); i++) {
                LocalTime goTime = LocalTime.now()
                        .plusHours(rnd.nextInt(0, 4)).plusMinutes(rnd.nextInt(0, 61));
                listOfOffers.add(new PublicTransportOffer("Bus", "Bus_station_" + i, goTime));
            }
        }

        if (listOfOffers.isEmpty()) {
            throw new RidesharingException("No public bus-transport is available for route: " + loc + " -> " + dest);
        }

        return listOfOffers;
    }

    public static List<PublicTransportOffer> tramTransportServer(String loc, String dest) {

        List<PublicTransportOffer> listOfOffers = new ArrayList<>();

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer) {

            for (int i = 0; i < rnd.nextInt(10); i++) {
                LocalTime goTime = LocalTime.now()
                        .plusHours(rnd.nextInt(0, 4)).plusMinutes(rnd.nextInt(0, 61));
                listOfOffers.add(new PublicTransportOffer("Tram", "Tram_station_" + i, goTime));
            }
        }

        if (listOfOffers.isEmpty()) {
            throw new RidesharingException("No public tram-transport is available for route: " + loc + " -> " + dest);
        }

        return listOfOffers;
    }

    public static List<PublicTransportOffer> subwayTransportServer(String loc, String dest) {

        List<PublicTransportOffer> listOfOffers = new ArrayList<>();

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer) {

            for (int i = 0; i < rnd.nextInt(10); i++) {
                LocalTime goTime = LocalTime.now()
                        .plusHours(rnd.nextInt(0, 4)).plusMinutes(rnd.nextInt(0, 61));
                listOfOffers.add(new PublicTransportOffer("Subway", "Subway_station_" + i, goTime));
            }
        }

        if (listOfOffers.isEmpty()) {
            throw new RidesharingException("No public subway-transport is available for route: " + loc + " -> " + dest);
        }

        return listOfOffers;
    }

    public static List<PublicTransportOffer> trainTransportServer(String loc, String dest) {

        List<PublicTransportOffer> listOfOffers = new ArrayList<>();

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer) {

            for (int i = 0; i < rnd.nextInt(10); i++) {
                LocalTime goTime = LocalTime.now()
                        .plusHours(rnd.nextInt(0, 4)).plusMinutes(rnd.nextInt(0, 61));
                listOfOffers.add(new PublicTransportOffer("Train", "Train_station_" + i, goTime));
            }
        }

        if (listOfOffers.isEmpty()) {
            throw new RidesharingException("No public train-transport is available for route: " + loc + " -> " + dest);
        }

        return listOfOffers;
    }
}
