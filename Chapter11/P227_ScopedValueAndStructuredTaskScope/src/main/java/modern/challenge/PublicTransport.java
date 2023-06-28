package modern.challenge;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static modern.challenge.Main.DEST;
import static modern.challenge.Main.LOC;
import static modern.challenge.Main.PUBLIC_TRANSPORT_TICKET;

public final class PublicTransport {

    public static List<PublicTransportOffer> busTransportServer() {

        List<PublicTransportOffer> listOfOffers = new ArrayList<>();

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer && PUBLIC_TRANSPORT_TICKET.isBound() && PUBLIC_TRANSPORT_TICKET.get()) {

            for (int i = 0; i < rnd.nextInt(10); i++) {
                LocalTime goTime = LocalTime.now()
                        .plusHours(rnd.nextInt(0, 4)).plusMinutes(rnd.nextInt(0, 61));
                listOfOffers.add(new PublicTransportOffer("Bus", "Bus_station_" + i, goTime));
            }
        }

        if (listOfOffers.isEmpty()) {
            throw new RidesharingException("No public bus-transport is available for route: "
                    + LOC.get() + " -> " + DEST.get());
        }

        return listOfOffers;
    }

    public static List<PublicTransportOffer> tramTransportServer() {

        List<PublicTransportOffer> listOfOffers = new ArrayList<>();

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer && PUBLIC_TRANSPORT_TICKET.isBound() && PUBLIC_TRANSPORT_TICKET.get()) {

            for (int i = 0; i < rnd.nextInt(10); i++) {
                LocalTime goTime = LocalTime.now()
                        .plusHours(rnd.nextInt(0, 4)).plusMinutes(rnd.nextInt(0, 61));
                listOfOffers.add(new PublicTransportOffer("Tram", "Tram_station_" + i, goTime));
            }
        }

        if (listOfOffers.isEmpty()) {
            throw new RidesharingException("No public tram-transport is available for route: "
                    + LOC.get() + " -> " + DEST.get());
        }

        return listOfOffers;
    }

    public static List<PublicTransportOffer> subwayTransportServer() {

        List<PublicTransportOffer> listOfOffers = new ArrayList<>();

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer && PUBLIC_TRANSPORT_TICKET.isBound() && PUBLIC_TRANSPORT_TICKET.get()) {

            for (int i = 0; i < rnd.nextInt(10); i++) {
                LocalTime goTime = LocalTime.now()
                        .plusHours(rnd.nextInt(0, 4)).plusMinutes(rnd.nextInt(0, 61));
                listOfOffers.add(new PublicTransportOffer("Subway", "Subway_station_" + i, goTime));
            }
        }

        if (listOfOffers.isEmpty()) {
            throw new RidesharingException("No public subway-transport is available for route: "
                    + LOC.get() + " -> " + DEST.get());
        }

        return listOfOffers;
    }

    public static List<PublicTransportOffer> trainTransportServer() {

        List<PublicTransportOffer> listOfOffers = new ArrayList<>();

        Random rnd = new Random();
        boolean makeAnOffer = rnd.nextBoolean();

        if (makeAnOffer && PUBLIC_TRANSPORT_TICKET.isBound() && PUBLIC_TRANSPORT_TICKET.get()) {

            for (int i = 0; i < rnd.nextInt(10); i++) {
                LocalTime goTime = LocalTime.now()
                        .plusHours(rnd.nextInt(0, 4)).plusMinutes(rnd.nextInt(0, 61));
                listOfOffers.add(new PublicTransportOffer("Train", "Train_station_" + i, goTime));
            }
        }

        if (listOfOffers.isEmpty()) {
            throw new RidesharingException("No public train-transport is available for route: "
                    + LOC.get() + " -> " + DEST.get());
        }

        return listOfOffers;
    }
}
