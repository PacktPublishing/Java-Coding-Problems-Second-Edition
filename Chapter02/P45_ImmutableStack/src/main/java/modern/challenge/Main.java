package modern.challenge;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Stack<String> s1 = ImmutableStack.empty(String.class);

        Stack<String> s2 = s1.push("Hello");
        Stack<String> s3 = s2.push("Immutable");
        Stack<String> s4 = s2.push("Stack"); // shares its tail with s3

        System.out.println("S1: " + s1.isEmpty());
        
        System.out.println("\nS2:");
        Iterator<String> it2 = s2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
        
        System.out.println("\nS3:");
        Iterator<String> it3 = s3.iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }
                
        System.out.println("\nS4:");
        Iterator<String> it4 = s4.iterator();
        while (it4.hasNext()) {
            System.out.println(it4.next());
        }
        
        // s4.pop().pop().pop(); // UnsupportedOperationException: Unsupported operation on an empty stack
    }
}
