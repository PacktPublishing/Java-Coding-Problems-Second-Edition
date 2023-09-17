package modern.challenge;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class Main {

    public static void main(String[] args) {
        
        Random legacyRnd1 = Random.from(RandomGenerator.of("L128X256MixRandom"));
        Random legacyRnd2 = Random.from(RandomGeneratorFactory.
                of("Xoroshiro128PlusPlus").create());
        Random legacyRnd3 = Random.from(RandomGeneratorFactory
                .<RandomGenerator.SplittableGenerator>of("L128X256MixRandom")
                .create());
                       
        Random legacyRnd4 = SecureRandom.from(RandomGenerator.of("L128X256MixRandom"));
        Random legacyRnd5 = SecureRandom.from(RandomGeneratorFactory.
                of("Xoroshiro128PlusPlus").create());
        Random legacyRnd6 = SecureRandom.from(RandomGeneratorFactory
                .<RandomGenerator.SplittableGenerator>of("L128X256MixRandom")
                .create());
        
        Random legacyRnd7 = ThreadLocalRandom.from(RandomGenerator.of("L128X256MixRandom"));
        Random legacyRnd8 = ThreadLocalRandom.from(RandomGeneratorFactory.
                of("Xoroshiro128PlusPlus").create());
        Random legacyRnd9 = ThreadLocalRandom.from(RandomGeneratorFactory
                .<RandomGenerator.SplittableGenerator>of("L128X256MixRandom")
                .create());
    }
}