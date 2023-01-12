package modern.challenge;

import java.util.random.RandomGenerator;
import java.util.random.RandomGenerator.JumpableGenerator;
import java.util.random.RandomGenerator.LeapableGenerator;
import java.util.random.RandomGenerator.SplittableGenerator;
import java.util.random.RandomGenerator.StreamableGenerator;
import java.util.random.RandomGeneratorFactory;

public class Main {

    public static void main(String[] args) {
        
        // get the default random generator
        RandomGenerator defaultGenerator = RandomGenerator.getDefault();                
        System.out.println("Default generator: " + defaultGenerator);

        // using RandomGenerator.of()
        RandomGenerator generator1 = RandomGenerator.of("L128X256MixRandom");
        
        // using RandomGeneratorFactory.of()
        RandomGenerator generator2 = RandomGeneratorFactory.of("Xoroshiro128PlusPlus")
                .create();       

        // create a splittable generator ('L128X256MixRandom' is splittable)
        RandomGenerator.SplittableGenerator splittableGenerator1 = RandomGeneratorFactory
                .<RandomGenerator.SplittableGenerator>of("L128X256MixRandom")
                .create();        
        // or, like this
        SplittableGenerator splittableGenerator2 = RandomGeneratorFactory
                .<SplittableGenerator>of("L128X256MixRandom")
                .create();        
        // or, like this
        RandomGenerator.SplittableGenerator splittableGenerator3 = 
             RandomGenerator.SplittableGenerator.of("L128X256MixRandom");
        // or, like this
        SplittableGenerator splittableGenerator4 = SplittableGenerator.of("L128X256MixRandom");        
        // or, like this:
        java.util.SplittableRandom splittableGenerator5 = new java.util.SplittableRandom();              

        // create a streamable generator ('L64X128MixRandom' is streamable)
        RandomGenerator.StreamableGenerator streamableGenerator1 = RandomGeneratorFactory
                .<RandomGenerator.StreamableGenerator>of("L64X128MixRandom")
                .create();
        // or, like this
        StreamableGenerator streamableGenerator2 = RandomGeneratorFactory
                .<StreamableGenerator>of("L64X128MixRandom")
                .create();
        // or, like this
        RandomGenerator.StreamableGenerator streamableGenerator3 = 
             RandomGenerator.StreamableGenerator.of("L64X128MixRandom");
        // or, like this
        StreamableGenerator streamableGenerator4 = StreamableGenerator.of("L64X128MixRandom");
        
        // create a leapable generator ('Xoshiro256PlusPlus' is leapable)
        RandomGenerator.LeapableGenerator leapableGenerator1 = RandomGeneratorFactory
                .<RandomGenerator.LeapableGenerator>of("Xoshiro256PlusPlus")
                .create();
        // or, like this
        LeapableGenerator leapableGenerator2 = RandomGeneratorFactory
                .<LeapableGenerator>of("Xoshiro256PlusPlus")
                .create();
        // or, like this
        RandomGenerator.LeapableGenerator leapableGenerator3 = 
             RandomGenerator.LeapableGenerator.of("Xoshiro256PlusPlus");
        // or, like this
        LeapableGenerator leapableGenerator4 = LeapableGenerator.of("Xoshiro256PlusPlus");
        
        // create a jumpable generator ('Xoshiro256PlusPlus' is jumpable)
        RandomGenerator.JumpableGenerator jumpableGenerator1 = RandomGeneratorFactory
                .<RandomGenerator.JumpableGenerator>of("Xoshiro256PlusPlus")
                .create();                
        // or, like this
        JumpableGenerator jumpableGenerator2 = RandomGeneratorFactory
                .<JumpableGenerator>of("Xoshiro256PlusPlus")
                .create();                
        // or, like this
        RandomGenerator.JumpableGenerator jumpableGenerator3 = 
             RandomGenerator.JumpableGenerator.of("Xoshiro256PlusPlus");
        // or, like this
        JumpableGenerator jumpableGenerator4 = JumpableGenerator.of("Xoshiro256PlusPlus");
    }
}