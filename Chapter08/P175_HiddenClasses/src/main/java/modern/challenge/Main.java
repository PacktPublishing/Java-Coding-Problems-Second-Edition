package modern.challenge;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args)
            throws IOException, IllegalAccessException, NoSuchMethodException,
            InstantiationException, IllegalArgumentException, InvocationTargetException {

        /* creating a hidden class */
        
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        Class<?> clazz = InternalMath.class;
        String clazzPath = clazz.getName().replace('.', '/') + ".class";
        InputStream stream = clazz.getClassLoader().getResourceAsStream(clazzPath);
        byte[] clazzBytes = stream.readAllBytes();

        Class<?> hiddenClass = lookup.defineHiddenClass(clazzBytes,
                true, ClassOption.NESTMATE).lookupClass();

        /* using a hidden class */
        
        // Object obj = hiddenClass.getConstructor().newInstance();   // without the Math interface
        Math obj = (Math) hiddenClass.getConstructor().newInstance(); // with the Math interface

        Method method = obj.getClass()
                .getDeclaredMethod("sum", int[].class);

        System.out.println(method.invoke(obj, new int[]{4, 1, 6, 7}));
    }
}