package modern.challenge;

import java.util.HashSet;
import java.util.Set;

public record MelonRecord(String type, int weight) {
    
    private static Set<String> countries = new HashSet<>();
       
    // using the compact constructor specific to records
    public MelonRecord {
        
        if (type == null) {
            throw new IllegalArgumentException("The melon's type cannot be null");
        }

        if (weight < 1000 || weight > 10000) { 
            throw new IllegalArgumentException("The melon's weight must be between 1000 and 10000 grams");
        }                  
    }               
            
    MelonRecord(String type) {
        this(type, 500);
    }
    
    MelonRecord(int weight) {
        this("Cantaloupe", weight);
    }
    
    MelonRecord(String type, int weight, String country) {
        this(type, weight);
        MelonRecord.countries.add(country);        
    }
}