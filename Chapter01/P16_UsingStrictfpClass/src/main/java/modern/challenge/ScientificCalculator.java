package modern.challenge;

// strictfp is not required starting with Java 17
public strictfp final class ScientificCalculator {
    
    private ScientificCalculator() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    public static double multiply(final double v1, final double v2) {
        return v1 * v2;
    }

    public static double division(final double v1, final double v2) { 
        return v1 / v2; 
    }
    
    // more computational methods
}
