package modern.challenge;
 
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
       
        MelonRecord melon = new MelonRecord("Cantaloupe", 2600);
        
        System.out.println(melon);
        System.out.println(melon.type());
        System.out.println(melon.weight());    
        
        Map<String, Integer> retails = new HashMap<>();
        retails.put("Gac", 10);
        retails.put("Cucumber", 5);
        retails.put("Eggplant", 8);
        
        MarketRecord market = new MarketRecord(retails);
                       
        System.out.println(retails);
        System.out.println(market.retails());
    }
}
