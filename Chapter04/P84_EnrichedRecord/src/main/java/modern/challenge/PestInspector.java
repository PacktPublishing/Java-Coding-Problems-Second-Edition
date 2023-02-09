package modern.challenge;

public interface PestInspector {

    public default boolean detectPest() {
        return Math.random() > 0.5d;
    }

    public void exterminatePest();
}
