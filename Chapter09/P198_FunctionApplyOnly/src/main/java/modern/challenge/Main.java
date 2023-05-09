package modern.challenge;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {       

        TriFunction<Double, Double, Double, Double> abc2 = (a, b, c)
                -> Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2) + 2.0*a*b + 2*b*c + 2*c*a;        

        System.out.println("abc2 (1): " + abc2.apply(1.0, 2.0, 1.0));
        System.out.println("abc2 (2): " + abc2.apply(1.0, 2.0, 2.0));
        System.out.println("abc2 (3): " + abc2.apply(1.0, 2.0, 3.0));
                                    
        Function<Double, Double> abc2Only1 = abc2.applyOnly(1.0, 2.0);
        
        System.out.println();
        System.out.println("abc2Only1 (1): " + abc2Only1.apply(1.0));
        System.out.println("abc2Only1 (2): " + abc2Only1.apply(2.0));
        System.out.println("abc2Only1 (3): " + abc2Only1.apply(3.0));
        
        BiFunction<Double, Double, Double> abc2Only2 = abc2.applyOnly(1.0);
        
        System.out.println();
        System.out.println("abc2Only2 (1): " + abc2Only2.apply(2.0, 3.0));
        System.out.println("abc2Only2 (2): " + abc2Only2.apply(1.0, 2.0));
        System.out.println("abc2Only2 (3): " + abc2Only2.apply(3.0, 2.0));
    }
}