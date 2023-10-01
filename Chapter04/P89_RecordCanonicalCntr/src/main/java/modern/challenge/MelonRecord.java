package modern.challenge;

public record MelonRecord(String type, float weight) {
 
    // explicit canonical constructor for validations       
    public MelonRecord(String type, float weight) {

        if (type == null) {
            throw new IllegalArgumentException("The melon's type cannot be null");
        }

        if (weight < 1000 || weight > 10000) {
            throw new IllegalArgumentException("The melon's weight must be between 1000 and 10000 grams");
        }                        
                
        this.type = type;
        this.weight = weight;                                        
    }        
    
    // explicit canonical constructor for reassigning components
    /*
    public MelonRecord(String type, float weight) {

        weight = weight/1_000; // overwriting the component 'weight'
        
        this.type = type;
        this.weight = weight;                   
    }
    */
    
    // explicit compact constructor for validations    
    /*
    public MelonRecord {
        
        if (type == null) {
            throw new IllegalArgumentException("The melon's type cannot be null");
        }

        if (weight < 1000 || weight > 10000) { 
            throw new IllegalArgumentException("The melon's weight must be between 1000 and 10000 grams");
        }              
    }
    */
    
    // explicit compact constructor for reassigning components
    /*
    public MelonRecord {
        
        weight = weight/1_000; // overwriting the component 'weight'
    } 
    */
}