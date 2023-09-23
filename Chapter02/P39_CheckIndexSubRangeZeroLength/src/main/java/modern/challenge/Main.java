package modern.challenge;

import java.io.IOException;
import java.math.BigInteger;

public class Main {    

    public static void main(String[] args) throws IOException {
        
        boolean result1 = Pipes.isPressureSupportedV1(2, 5, 8);
        boolean result2 = Pipes.isPressureSupportedV2(2, 5, 12);
        System.out.println("Pressure supported (V1): " + result1);
        System.out.println("Pressure supported (V2): " + result2);
         
        // expected result, 365779719
        int x1 = NumberConverter.toLeIntV1(BigInteger.valueOf(123456789).toByteArray(), 0);
        int x2 = NumberConverter.toLeIntV1(BigInteger.valueOf(123456789).toByteArray(), 0);
        
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
    }
}
