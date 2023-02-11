package modern.challenge;

import java.util.HashSet;
import java.util.Set;

public record MelonRecord(String type, float weight) {

    private static final String DEFAULT_MELON_TYPE = "Crenshaw";
    private static final float DEFAULT_MELON_WEIGHT = 1000;

    private static Set<String> countries = new HashSet<>();

    // using the compact constructor specific to records
    public MelonRecord  {

        if (type == null) {
            throw new IllegalArgumentException("The melon's type cannot be null");
        }

        if (weight < 1000 || weight > 10000) {
            throw new IllegalArgumentException("The melon's weight must be between 1000 and 10000 grams");
        }
    }

    MelonRecord() {
        this(DEFAULT_MELON_TYPE, DEFAULT_MELON_WEIGHT);
    }
    
    MelonRecord(String type) {
        this(type, DEFAULT_MELON_WEIGHT);
    }

    MelonRecord(float weight) {
        this(DEFAULT_MELON_TYPE, weight);
    }

    MelonRecord(String type, int weight, String country) {
        this(type, weight);
        MelonRecord.countries.add(country);
    }
}
