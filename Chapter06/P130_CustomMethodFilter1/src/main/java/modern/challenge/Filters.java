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
            // or, clazz.getName().equals("modern.challenge.Melon")
            return !(clazz.getPackage().getName().equals("modern.challenge")
                    && clazz.getSimpleName().equals("Melon"))
                    ? Status.ALLOWED : Status.REJECTED;
        }

        return Status.UNDECIDED;
    }
}