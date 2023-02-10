package modern.challenge;

public record MelonRecord(String type, float weight) {

    private static final String DEFAULT_MELON_TYPE = "Crenshaw";
    private static final float DEFAULT_MELON_WEIGHT = 1000;

    public float weightToKg() {

        return weight / 1_000;
    }

    public static MelonRecord getDefaultMelon() {

        return new MelonRecord(DEFAULT_MELON_TYPE, DEFAULT_MELON_WEIGHT);
    }

    public static class Slicer {

        public void slice(MelonRecord mr, int n) {
            start();
            System.out.println("Slicing a " + mr.type() + " of " 
                    + mr.weightToKg() + " kg in " + n + " slices ...");
            stop();
        }

        private static void start() {
            System.out.println("Start slicer ...");
        }

        private static void stop() {
            System.out.println("Stop slicer ...");
        }
    }
}
