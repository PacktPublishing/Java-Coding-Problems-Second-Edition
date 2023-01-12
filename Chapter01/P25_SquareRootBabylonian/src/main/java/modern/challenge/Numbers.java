package modern.challenge;

public final class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static double squareRootBabylonian(double v) {

        if (v == 0) {
            return 0;
        }

        if (v < 0) {
            throw new IllegalArgumentException("The given value must be positive");
        }

        double x = v / 2;
        
        double y = 1;

        double e = 0.000000000001; // precision

        while (x - y > e) {
            x = (x + y) / 2;
            y = v / x;
        }

        return x;
    }

    public static long perfectSquareRootBabylonian(double v) {
        
        if (v == 0) {
            return 0;
        }

        if (v < 0) {
            throw new IllegalArgumentException("The given value must be positive perfect square");
        }

        double x = v / 2;
        double y = 1;

        while (x > y) {
            x = (x + y) / 2;
            y = v / x;
        }

        return (long) x;
    }
}
