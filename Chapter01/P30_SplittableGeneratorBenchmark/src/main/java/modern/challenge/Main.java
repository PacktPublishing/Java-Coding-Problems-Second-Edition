package modern.challenge;

import java.io.IOException;
import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.random.RandomGenerator.SplittableGenerator;
import java.util.random.RandomGeneratorFactory;

public class Main {

    public static void main(String[] args) throws IOException {

        SplittableRandom splittableRandom = new SplittableRandom();                
        
        SplittableGenerator splittableRndL64X256 = RandomGeneratorFactory
                .<SplittableGenerator>of("L64X256MixRandom")
                .create();
        
        long[] arr = new long[100_000_000];
        Arrays.parallelSetAll(arr, x -> splittableRndL64X256.nextLong());
        Arrays.parallelSetAll(arr, x -> splittableRandom.nextLong());
    }
}