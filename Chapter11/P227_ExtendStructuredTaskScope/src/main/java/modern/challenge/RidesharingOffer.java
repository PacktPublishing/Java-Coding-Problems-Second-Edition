package modern.challenge;

import java.time.Duration;

public record RidesharingOffer(String company, Duration minutesToYou, 
        Duration minutesToDest, double price) {}
