package modern.challenge;

public class NewConnection { // singleton

    private NewConnection() {
    }

    public static NewConnection get() {

        class LazyConnection { // holder

            static final NewConnection INSTANCE = new NewConnection();

            static {
                System.out.println("Initializing new connection ..." + INSTANCE);
            }
        }

        return LazyConnection.INSTANCE;
    }
}
