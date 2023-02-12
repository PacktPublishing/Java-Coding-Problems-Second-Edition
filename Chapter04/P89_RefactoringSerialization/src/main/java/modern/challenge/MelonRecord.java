package modern.challenge;

import java.io.Serializable;
import java.util.Objects;

public record MelonRecord(String type, float weight) implements Serializable {
    
    public MelonRecord {
        Objects.requireNonNull(type, "The melon's type cannot be null");
        
        if (weight < 1000 || weight > 10000) { 
            throw new IllegalArgumentException(
                    "The melon's weight must be between 1000 and 10000 grams");
        } 
    }
}
