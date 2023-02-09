package modern.challenge;
 
import java.util.Map;

public record MarketRecord(Map<String, Integer> retailPrices) {

    public MarketRecord {
        retailPrices = Map.copyOf(retailPrices);
    }
}
