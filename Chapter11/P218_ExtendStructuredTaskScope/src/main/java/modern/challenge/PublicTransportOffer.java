package modern.challenge;

import java.time.LocalTime;

public record PublicTransportOffer(String transport, 
        String station, LocalTime goTime) {}