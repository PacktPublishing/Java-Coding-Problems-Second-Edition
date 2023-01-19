package modern.challenge;

import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        // invoke Printable.print(String doc)
        System.out.println("Invoke Printable.print(String doc):");
        Printable pproxy = (Printable) Proxy.newProxyInstance(
                Printable.class.getClassLoader(),
                new Class<?>[]{Printable.class}, (o, m, p) -> {

                    if (m.isDefault()) {

                        Constructor<Lookup> cntr = Lookup.class
                                .getDeclaredConstructor(Class.class);

                        cntr.setAccessible(true);

                        return cntr.newInstance(Printable.class)
                                .in(Printable.class)
                                .unreflectSpecial(m, Printable.class)
                                .bindTo(o)
                                .invokeWithArguments(p);
                    }

                    return null;
                });
        pproxy.print("Chapter 2");

        // invoke Writable.write(String doc)
        System.out.println("\nInvoke Writable.write(String doc):");
        Writable wproxy = (Writable) Proxy.newProxyInstance(
                Writable.class.getClassLoader(),
                new Class<?>[]{Writable.class}, (o, m, p) -> {

                    if (m.isDefault()) {
                        Constructor<Lookup> cntr = Lookup.class
                                .getDeclaredConstructor(Class.class);

                        cntr.setAccessible(true);

                        return cntr.newInstance(Writable.class)
                                .in(Writable.class)
                                .unreflectSpecial(m, Writable.class)
                                .bindTo(o)
                                .invokeWithArguments(p);
                    }

                    return null;
                });
        wproxy.write("Chapter 5");

        // invoke Draft.write(String doc)
        System.out.println("\nInvoke Draft.write(String doc):");
        Draft wdproxy = (Draft) Proxy.newProxyInstance(
                Draft.class.getClassLoader(),
                new Class<?>[]{Draft.class}, (o, m, p) -> {

                    if (m.isDefault()) {
                        Constructor<Lookup> cntr = Lookup.class
                                .getDeclaredConstructor(Class.class);

                        cntr.setAccessible(true);

                        return cntr.newInstance(Draft.class)
                                .in(Draft.class)
                                .unreflectSpecial(m, Draft.class)
                                .bindTo(o)
                                .invokeWithArguments(p);
                    }

                    return null;
                });
        wdproxy.write("Chapter 13");

        // invoke Draft.write(String doc) and Writable.write(String doc)
        System.out.println("\nInvoke Draft.write(String doc) and Writable.write(String doc):");
        Writable dpproxy = (Writable) Proxy.newProxyInstance(
                Writable.class.getClassLoader(),
                new Class<?>[]{Writable.class, Draft.class}, (o, m, p) -> {

                    if (m.isDefault() && m.getName().equals("write")) {

                        Constructor<Lookup> cntr = Lookup.class
                                .getDeclaredConstructor(Class.class);

                        cntr.setAccessible(true);                      

                        cntr.newInstance(Draft.class)
                                .in(Draft.class)
                                .findSpecial(Draft.class, "write",
                                        MethodType.methodType(void.class, String.class), Draft.class)
                                .bindTo(o)
                                .invokeWithArguments(p);
                        
                        return cntr.newInstance(Writable.class)
                                .in(Writable.class)
                                .findSpecial(Writable.class, "write",
                                        MethodType.methodType(void.class, String.class), Writable.class)
                                .bindTo(o)
                                .invokeWithArguments(p);
                    }

                    return null;
                });
        dpproxy.write("Chapter 1");

        // invoke Book.print(String doc)
        System.out.println("\nInvoke Book.print(String doc):");
        Book bpproxy = (Book) Proxy.newProxyInstance(
                Book.class.getClassLoader(),
                new Class<?>[]{Book.class}, (o, m, p) -> {

                    if (m.isDefault()) {
                        Constructor<Lookup> cntr = Lookup.class
                                .getDeclaredConstructor(Class.class);

                        cntr.setAccessible(true);

                        return cntr.newInstance(Book.class)
                                .in(Book.class)
                                .unreflectSpecial(m, Book.class)
                                .bindTo(o)
                                .invokeWithArguments(p);
                    }

                    return null;
                });
        bpproxy.print("Chapter 7");
    }
}
