package modern.challenge;

public class Main {

    public static String buy1(Vegetable vegetable) {
        
        return switch(vegetable) {
            case Eggplant(SeedRecord seed, float weight) -> "This is a " + seed.type() + " eggplant";
            // case MelonRecord(null, float weight) -> "Ops! What's this?!"; // DOESN'T COMPILE
            case MelonRecord(SeedRecord seed, float weight) -> "This is a " + seed.type() + " melon";
            case Vegetable v -> "This is an unknown vegetable";
        };
    }
    
    public static String buy2(Vegetable vegetable) {
        
        if(vegetable instanceof MelonRecord(SeedRecord seed, float weight)) {
           return "This is a " + seed.type() + " melon";
        }
        
        // if(vegetable instanceof MelonRecord(null, float weight)) { // DOESN'T COMPILE
        //   return "Ops! What's this?!";
        // }
        
        return "";
    }
    
    public static void main(String[] args) {      
        
      // System.out.println(buy1(null));
      // System.out.println(buy2(null));
      
      /*
      Eggplant eggplant = new Eggplant(new SeedRecord("Fairytale", "India"), 300);
      System.out.println(buy1(eggplant));
      */
      
      MelonRecord melon = new MelonRecord(null, 1000);
      System.out.println(buy1(melon));      
    }
}