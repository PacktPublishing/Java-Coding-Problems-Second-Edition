package modern.challenge;

import java.io.ObjectInputFilter;
import java.io.ObjectInputFilter.FilterInfo;
import java.io.ObjectInputFilter.Status;

public final class MelonFilter implements ObjectInputFilter {

    @Override
    public Status checkInput(FilterInfo filterInfo) {

        Class<?> clazz = filterInfo.serialClass();
        if (clazz != null) {
            // or, clazz.getName().equals("modern.challenge.Melon")
            return !(clazz.getPackage().getName().equals("modern.challenge")
                    && clazz.getSimpleName().equals("Melon"))
                    ? Status.ALLOWED : Status.REJECTED;
        }

        return Status.UNDECIDED;
    }
}
