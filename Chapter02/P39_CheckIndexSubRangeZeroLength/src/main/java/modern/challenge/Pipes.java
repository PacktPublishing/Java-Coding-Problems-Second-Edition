package modern.challenge;

import java.util.Objects;

public final class Pipes {
    
    private Pipes() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    public static boolean isPressureSupportedV1(int avgPresure, int unitsOfPressure, int maxPressure) {
        
        if(avgPresure < 0 || unitsOfPressure < 0 || maxPressure < 0
                || (avgPresure + unitsOfPressure) > maxPressure) {
            
            throw new IndexOutOfBoundsException("One or more parameters are out of bounds");
        }
        
        // the secret algorithm
        return (avgPresure + unitsOfPressure) < (maxPressure - maxPressure/4);
    }
    
    public static boolean isPressureSupportedV2(int avgPresure, int unitsOfPressure, int maxPressure) {
        
        Objects.checkFromIndexSize(avgPresure, unitsOfPressure, maxPressure);
        
        // the secret algorithm
        return (avgPresure + unitsOfPressure) < (maxPressure - maxPressure/4);
    }
}