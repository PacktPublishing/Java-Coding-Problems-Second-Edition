package modern.challenge;

public class Main {

    public static String buyFruit1(Fruit fruit) {
        
        return switch(fruit) {   
            case null -> "Ops!";
            case SeedRecord(String type, String country) -> "This is a seed of " + type + " from " + country;
            case EggplantRecord(SeedRecord seed, float weight) when seed == null -> "Ops! What's this?!";                
            case EggplantRecord(SeedRecord seed, float weight) -> "This is a " + seed.type() + " eggplant";            
            // case EggplantRecord(null, float weight) -> "Ops! What's this?!"; // DOESN'T COMPILE            
            case MelonRecord(SeedRecord seed, float weight) -> "This is a " + seed.type() + " melon";            
            // case MelonRecord(null, float weight) -> "Ops! What's this?!"; // DOESN'T COMPILE
            case Fruit v -> "This is an unknown fruit";
        };
    }
    
    public static String buyFruit2(Fruit fruit) {
        
        if (fruit instanceof SeedRecord(String type, String country)) {
           return "This is a seed of " + type + " from " + country;
        }
        
        if (fruit instanceof EggplantRecord(SeedRecord seed, float weight) && seed == null) {
           return "Ops! What's this?!";
        }
        
        if (fruit instanceof EggplantRecord(SeedRecord seed, float weight)) {
           return "This is a " + seed.type() + " eggplant";
        }
        
        /* // DOESN'T COMPILE 
        if (fruit instanceof EggplantRecord(null, float weight)) {
           return "Ops! What's this?!";
        }
        */
        
        if (fruit instanceof MelonRecord(SeedRecord seed, float weight)) {
           return "This is a " + seed.type() + " melon";
        }                
        
        /* // DOESN'T COMPILE 
        if (fruit instanceof MelonRecord(null, float weight)) {
           return "Ops! What's this?!";
        }
        */
        
        return "This is an unknown fruit";
    }
    
    public static void main(String[] args) {                    
       
       SeedRecord seed = new SeedRecord("Fairytale", "India");
       EggplantRecord eggplant = new EggplantRecord(seed, 300);
       EggplantRecord badEggplant = new EggplantRecord(null, 300);
       
       System.out.println(buyFruit1(null));        // Ops
       System.out.println(buyFruit1(seed));        // This is a seed of Fairytale from India
       System.out.println(buyFruit1(eggplant));    // This is a Fairytale eggplant              
       System.out.println(buyFruit1(badEggplant)); // Ops! What's this?!
       
       System.out.println();
                
       System.out.println(buyFruit2(null));        // This is an unknown fruit         
       System.out.println(buyFruit2(seed));        // This is a seed of Fairytale from India 
       System.out.println(buyFruit2(eggplant));    // This is a Fairytale eggplant       
       System.out.println(buyFruit2(badEggplant)); // Ops! What's this?!
    }
}