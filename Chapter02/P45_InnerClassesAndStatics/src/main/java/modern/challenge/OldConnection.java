package modern.challenge;

public class OldConnection { // singleton

    private OldConnection() {
    }

    private static class LazyConnection { // holder

        static final OldConnection INSTANCE = new OldConnection();

        static {
            System.out.println("Initializing old connection ..." + INSTANCE);
        }
    }

    public static OldConnection get() {
        return LazyConnection.INSTANCE;
    }
}
