package modern.reflection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Inspector {

    private Inspector() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<Class> permittedClasses(Class clazz) {

        if (clazz != null && clazz.isSealed()) {
            return Arrays.asList(clazz.getPermittedSubclasses());
        }

        return Collections.emptyList();
    }
}
