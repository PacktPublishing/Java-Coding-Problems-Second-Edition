package modern.challenge;

public record MelonRecord(String type, int weight) {
    
    private static final String DEFAULT_MELON_TYPE = "Crenshaw";
    
    public float weightToKg() {
        
        return weight/1_000f;
    }
    
    public static String getDefaultMelon() {
        
        return DEFAULT_MELON_TYPE;
    }      
}
