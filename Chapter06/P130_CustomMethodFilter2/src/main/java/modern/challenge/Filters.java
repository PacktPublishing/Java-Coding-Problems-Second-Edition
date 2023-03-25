package modern.challenge;

import java.io.ObjectInputFilter;
import java.io.ObjectInputFilter.FilterInfo;
import java.io.ObjectInputFilter.Status;

public final class Filters {

    private Filters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static ObjectInputFilter.Status melonFilter(FilterInfo info) {

        Class<?> clazz = info.serialClass();
        if (clazz != null) {
            return (Melon.class.isAssignableFrom(clazz))
                    ? ObjectInputFilter.Status.REJECTED
                    : ObjectInputFilter.Status.ALLOWED;
        }

        return Status.UNDECIDED;
    }
}