package modern.challenge;

import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

public class Main {

    public static void main(String[] args) {
               
        int x = Integer.MIN_VALUE;     
        long y = Long.MIN_VALUE;
        
        long absofx = Math.abs(x);        
        long absofy = Math.abs(y);        
        System.out.println("The mathematical absolute value of " + x + " via abs() is: " + absofx);
        System.out.println("The mathematical absolute value of " + y + " via abs() is: " + absofy);
        
        // throw ArithmeticException
        int absofxExact = Math.absExact(x); 
        long absofyExact = Math.absExact(y); 
        System.out.println("The mathematical absolute value of " + x + " via absExact() is: " + absofxExact);
        System.out.println("The mathematical absolute value of " + y + " via absExact() is: " + absofyExact);
        
        // throw ArithmeticException
        IntUnaryOperator operatorInt = Math::absExact;
        LongUnaryOperator operatorLong = Math::absExact;
        int absofxExactUo = operatorInt.applyAsInt(x);
        long absofyExactUo = operatorLong.applyAsLong(y);
        System.out.println("The mathematical absolute value of " + x + " via IntUnaryOperator is: " + absofxExactUo);
        System.out.println("The mathematical absolute value of " + y + " via LongUnaryOperator is: " + absofyExactUo);
    }
}
