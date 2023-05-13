package modern.challenge;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> Counter.count();
        Consumer<Integer> consumer = c -> {c = c + Counter.count(); 
                                           System.out.println("Consumer: " + c ); }; // 2

        System.out.println("Counter: " + Counter.c);       // 0        
        System.out.println("Supplier: " + supplier.get()); // 0        
        System.out.println("Counter: " + Counter.c);       // 1        
        
        consumer.accept(Counter.c);         
        
        System.out.println("Counter: " + Counter.c);       // 2        
        System.out.println("Supplier: " + supplier.get()); // 2
        System.out.println("Counter: " + Counter.c);       // 3
    }

    static class Counter {

        static int c;

        public static int count() {
            System.out.println("Incrementing c from " + c + " to " + (c + 1));
            return c++;                                    
        }
    }
}