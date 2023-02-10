package modern.challenge;
 
import java.util.Map;

public record MarketRecord(Map<String, Integer> retails) {

    public MarketRecord {
        retails.putIfAbsent("Celery", 4); // this is allowed
        
        retails = Map.copyOf(retails);
        
        // retails.putIfAbsent("Lemon", 11); // this is not allowed
    }
}