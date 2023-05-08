package modern.challenge;

public final class Logistics {

    private Logistics() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void pl4(Double a, Double b, Double c, Double d, Double x) {
        
        System.out.println(d + ((a - d) / (1 + (Math.pow(x / c, b)))));
    }              
}