package modern.challenge;

import java.util.List;

public final class ChainSaw {

    private static final String UNKNOWN_POWER = "UNKNOWN";
            
    private static final List<String> MODELS
            = List.of("T300", "T450", "T700", "T800", "T900");

    private final String model;
    private final String power;
    private final int speed;

    public boolean started;

    private ChainSaw(String model, String power, int speed) {
        this.model = model;
        this.power = power;
        this.speed = speed;
    }

    public static ChainSaw initChainSaw(String model) {

        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("The given model cannot be null/empty");
        }

        for (String m : MODELS) {
            if (model.endsWith(m)) { // m.endsWith(model) will not fix NPE as in equals() case
                // TO DO (JIRA ####): replace UNKNOWN_POWER with code
                return new ChainSaw(model, UNKNOWN_POWER, (int) (Math.random() * 100));
            }
        }

        throw new UnsupportedOperationException("Model " + model + " is not supported");
    }

    public int performance(ChainSaw[] css) {

        if (css == null) {
            throw new IllegalArgumentException("The given models cannot be null");
        }

        int score = 0;
        for (ChainSaw cs : css) {
            if (cs != null) {
                score += Integer.compare(this.speed, cs.speed);
            }
        }

        return score;
    }

    public void start() {
        if (!started) {
            System.out.println("Started ...");
            started = true;
        }
    }

    public void stop() {
        if (started) {
            System.out.println("Stopped ...");
            started = false;
        }
    }

    public String getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "ChainSaw{" + "model=" + model
                + ", speed=" + speed + ", started=" + started + '}';
    }
}
