package modern.challenge;

public final class PressureRegulator {

    private static final int MIN_PRESSURE = 10;
    private static final int MAX_PRESSURE = 50;

    private PressureRegulator() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int adjustV1(int pressure) {

        if (pressure < MIN_PRESSURE) {
            return MIN_PRESSURE;
        }

        if (pressure > MAX_PRESSURE) {
            return MAX_PRESSURE;
        }

        return pressure;
    }

    public static int adjustV2(int pressure) {

        return Math.clamp(pressure, MIN_PRESSURE, MAX_PRESSURE);
    }
}
