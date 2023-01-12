package modern.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int v = 90;
        
        List<Integer> primeFactors1 = Primes.factorsV1(v);
        List<Integer> primeFactors2 = Primes.factorsV2(v);
        List<Integer> primeFactors3 = Primes.factorsV3(v);
        
        System.out.println("Prime factors (V1): " + primeFactors1);
        System.out.println("Prime factors (V2): " + primeFactors2);
        System.out.println("Prime factors (V3): " + primeFactors3);
    }
}

