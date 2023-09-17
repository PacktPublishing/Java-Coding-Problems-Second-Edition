package modern.challenge;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        double value = -9.33543545;

        // simple approach
        double fractionalPart1 = value % 1;
        double integralPart1 = value - fractionalPart1;

        System.out.println("Fractional part (1): " + fractionalPart1);
        System.out.println("Integral part (1): " + integralPart1);

        // alternatively, using BigDecimal
        BigDecimal bd = BigDecimal.valueOf(value);
        int integralPart2 = bd.intValue();
        double fractionalPart2 = bd.subtract(
                BigDecimal.valueOf(integralPart2)).doubleValue();

        System.out.println("Fractional part (2): " + fractionalPart2);
        System.out.println("Integral part (2): " + integralPart2);             
    }
}