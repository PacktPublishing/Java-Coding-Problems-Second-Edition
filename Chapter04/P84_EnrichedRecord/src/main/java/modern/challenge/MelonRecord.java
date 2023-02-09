package modern.challenge;

public record MelonRecord(String type, int weight) implements PestInspector {
    
    private static final String DEFAULT_MELON_TYPE = "Crenshaw";
    
    public float weightToKg() {
        
        return weight/1_000f;
    }
    
    public static String getDefaultMelon() {
        
        return DEFAULT_MELON_TYPE;
    }
  
    @Override
    public void exterminatePest() {        
        if(detectPest()) {
            System.out.println("All pests have been exterminated");
        } else {
            System.out.println("This melon is clean, no pests have been found");
        }
    }
}
