package modern.challenge;

public record MelonRecord(String type, int weight) {

    // provide an explicit constructor for validation purposes
    /*
    public MelonRecord(String type, int weight) {

        if (type == null) {
            throw new IllegalArgumentException("The melon's type cannot be null");
        }

        if (weight < 1000 || weight > 10000) {
            throw new IllegalArgumentException("The melon's weight must be between 1000 and 10000 grams");
        }
                
        this.type = type;
        this.weight = weight;
    }
    */
    
    // using the compact constructor specific to records
    public MelonRecord {
        
        if (type == null) {
            throw new IllegalArgumentException("The melon's type cannot be null");
        }

        if (weight < 1000 || weight > 10000) { 
            throw new IllegalArgumentException("The melon's weight must be between 1000 and 10000 grams");
        }  
        
        weight = weight/1_000; // overwriting the field 'weight'
    }
}