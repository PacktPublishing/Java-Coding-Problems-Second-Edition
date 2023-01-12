package modern.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Primes {

    private Primes() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<Integer> factorsV1(int v) {

        if (v <= 1) {
            // for negatives please consider reading:
            // https://primes.utm.edu/notes/faq/negative_primes.html
            return Collections.emptyList();
        }

        List<Integer> factorsList = new ArrayList<>();
        int s = 2;
        
        while (v > 1) {
            // each perfect division give us a prime factor
            if (v % s == 0) {
                factorsList.add(s);
                v = v / s;
            } else {
                s++;
            }
        }
        
        return factorsList;
    }

    public static List<Integer> factorsV2(int v) {

        if (v <= 1) {
            // for negatives please consider reading:
            // https://primes.utm.edu/notes/faq/negative_primes.html
            return Collections.emptyList();
        }

        List<Integer> factorsList = new ArrayList<>();

        // compute v % 2, 3, ..., v-1
        for (int i = 2; i < v; i++) {
            // each perfect division give us a prime factor
            while (v % i == 0) {
                factorsList.add(i);
                v = v / i;
            }
        }

        // collect the last prime factor when 'v' is a prime number greater than 2
        if (v > 2) {
            factorsList.add(v);
        }

        return factorsList;
    }

    public static List<Integer> factorsV3(int v) {

        if (v <= 1) {
            // for negatives please consider reading:
            // https://primes.utm.edu/notes/faq/negative_primes.html
            return Collections.emptyList();
        }

        List<Integer> factorsList = new ArrayList<>();

        // compute v % 2 as long as modulus return 0 and collect prime factors (2)
        while (v % 2 == 0) {
            factorsList.add(2);
            v = v / 2;
        }

        // now, 'v' should be odd
        // so, skip one element
        for (int i = 3; i <= Math.sqrt(v); i += 2) {
            // While 'i' divides 'v', collect 'i' as a prime factor and continue division
            while (v % i == 0) {
                factorsList.add(i);
                v = v / i;
            }
        }

        // collect the last prime factor when 'v' is a prime number greater than 2
        if (v > 2) {
            factorsList.add(v);
        }

        return factorsList;
    }
}
