package modern.challenge;

import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class Records {

    private Records() {
        throw new AssertionError("Cannot be instantiated");
    }

    // this method is from the official documentation of JDK
    // https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Class.html#getRecordComponents()
    public static <T extends Record> Constructor<T> getCanonicalConstructor(Class<T> cls)
            throws NoSuchMethodException {
        Class<?>[] paramTypes
                = Arrays.stream(cls.getRecordComponents())
                        .map(RecordComponent::getType)
                        .toArray(Class<?>[]::new);

        return cls.getDeclaredConstructor(paramTypes);
    }
}
