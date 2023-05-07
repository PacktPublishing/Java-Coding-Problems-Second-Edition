package modern.challenge;

public final class Exceptions {

    private Exceptions() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void throwChecked(Throwable t) {
        Exceptions.<RuntimeException>throwIt(t);
    }

    @SuppressWarnings({"unchecked"})
    private static <X extends Throwable> void throwIt(Throwable t) throws X {
        throw (X) t;
    }
}
