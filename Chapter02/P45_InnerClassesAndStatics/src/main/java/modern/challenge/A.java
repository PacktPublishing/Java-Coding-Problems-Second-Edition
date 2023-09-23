package modern.challenge;

public class A {

    public class B {

        {
            System.out.println("Non-static initializer ...");
        }

        static {
            System.out.println("Static initializer ...");
        }
    }
}
