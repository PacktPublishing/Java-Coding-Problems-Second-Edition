package modern.challenge;

import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        int x = Integer.MIN_VALUE;        
        
        int quotient = x/-1;
        System.out.println("The quotient is " + quotient);
                
        // throw ArithmeticException
        int quotientExact = Math.divideExact(x, -1); 
        System.out.println("The quotient is " + quotientExact);
        
        // throw ArithmeticException
        BinaryOperator<Integer> operator = Math::divideExact;
        int quotientExactBo = operator.apply(x, -1);
        System.out.println("The quotient is " + quotientExactBo);
    }
}
