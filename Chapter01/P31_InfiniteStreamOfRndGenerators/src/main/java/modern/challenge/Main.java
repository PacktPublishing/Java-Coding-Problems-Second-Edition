package modern.challenge;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.random.RandomGenerator.JumpableGenerator;
import java.util.random.RandomGenerator.LeapableGenerator;
import java.util.random.RandomGenerator.StreamableGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        // doubles between 0.0 and 0.5
        Supplier<Double> doubles = Math::random;
        double[] arrOfDoubles = Stream.generate(doubles) // or, Stream.generate(Math::random)
                .takeWhile(t -> t < 0.5d) // without this condition the stream will be infinite
                .mapToDouble(i -> i)
                .toArray();

        System.out.println("Doubles: " + Arrays.toString(arrOfDoubles));

        // 10 integers via Random        
        Random rnd = new Random();
        int[] arrOfInts = rnd.ints(10) // if we use the ints() alternative then the stream will be infinite
                .toArray();
        // or, shortly: int[] arrOfInts = new Random().ints(10).toArray();

        System.out.println("Integers: " + Arrays.toString(arrOfInts));

        // 10 integers via SecureRandom
        SecureRandom secureRnd = SecureRandom.getInstanceStrong();
        int[] arrOfSecInts = secureRnd.ints(10) // if we use the ints() alternative then the stream will be infinite
                .toArray();
        // or, shortly: int[] arrOfSecInts = SecureRandom.getInstanceStrong().ints(10).toArray();

        System.out.println("Integers (via SecureRandom): " + Arrays.toString(arrOfSecInts));

        ThreadLocalRandom tlRnd = ThreadLocalRandom.current();
        int[] arrOfTlInts = tlRnd.ints(10) // if we use the ints() alternative then the stream will be infinite
                .toArray();
        // or, shortly: int[] arrOfTlInts = ThreadLocalRandom.current().ints(10).toArray();

        System.out.println("Integers (via ThreadLocalRandom): " + Arrays.toString(arrOfTlInts));

        // using StreamableGenerator   
        StreamableGenerator streamableRnd = StreamableGenerator.of("L128X1024MixRandom");

        // 10 integers via StreamableGenerator
        int[] arrOfStRndInts = streamableRnd.ints(10)
                .toArray();

        // or, shortly StreamableGenerator.of("L128X1024MixRandom").ints(10).toArray();
        System.out.println("Integers (via StreamableGenerator): " + Arrays.toString(arrOfStRndInts));

        System.out.println();
        System.out.println("StreamableGenerator generators:");
        streamableRnd.rngs(5) // generate 5 objects, each of which implements the RandomGenerator interface
                // if we use rngs() then the stream is infinite
                .forEach(System.out::println);

        // each of the 5 generators generates 10 integers in an array
        List<int[]> listOfArrOfIntsSG = streamableRnd.rngs(5) // obtain 5 generators
                .map(r -> r.ints(10)) // each generator generates 10 integers
                .map(r -> r.toArray()) // every 10 integers are mapped into an array
                .collect(Collectors.toList()); // all 5 arrays are collected into a list

        System.out.println();
        System.out.println("List of arrays:");
        for (int i = 0; i < listOfArrOfIntsSG.size(); i++) {
            System.out.println("Array " + i + ": " + Arrays.toString(listOfArrOfIntsSG.get(i)));
        }

        // using JumpableGenerator   
        System.out.println();
        JumpableGenerator jumpableRnd = JumpableGenerator.of("Xoshiro256PlusPlus");

        // 10 integers via JumpableGenerator
        int[] arrOfJpRndInts = jumpableRnd.ints(10)
                .toArray();

        // or, shortly JumpableGenerator.of("Xoshiro256PlusPlus").ints(10).toArray();
        System.out.println("Integers (via JumpableGenerator): " + Arrays.toString(arrOfJpRndInts));

        System.out.println();
        System.out.println("JumpableGenerator generators:");
        jumpableRnd.jumps(5) // generate 5 objects, each of which implements the RandomGenerator interface
                // if we use jumps()/rngs() then the stream is infinite
                .forEach(System.out::println);

        // each of the 5 generators generates 10 integers in an array
        List<int[]> listOfArrOfIntsJG = jumpableRnd.jumps(5) // obtain 5 generators
                .map(r -> {
                    JumpableGenerator jg = (JumpableGenerator) r;
                    int[] ints = new int[10];
                    for (int i = 0; i < 10; i++) {
                        ints[i] = jg.nextInt();
                        jg.jump();
                    }
                    
                    return ints;
                }) // each generator generates 10 integers                               
                .collect(Collectors.toList()); // all 5 arrays are collected into a list

        System.out.println();
        System.out.println("List of arrays:");
        for (int i = 0; i < listOfArrOfIntsJG.size(); i++) {
            System.out.println("Array " + i + ": " + Arrays.toString(listOfArrOfIntsJG.get(i)));
        }

        // using LeapableGenerator   
        System.out.println();
        LeapableGenerator leapableRnd = LeapableGenerator.of("Xoshiro256PlusPlus");

        // 10 integers via LeapableGenerator
        int[] arrOfLpRndInts = leapableRnd.ints(10)
                .toArray();

        // or, shortly LeapableGenerator.of("Xoshiro256PlusPlus").ints(10).toArray();
        System.out.println("Integers (via LeapableGenerator): " + Arrays.toString(arrOfLpRndInts));

        System.out.println();
        System.out.println("LeapableGenerator generators:");
        leapableRnd.leaps(5) // generate 5 objects, each of which implements the RandomGenerator interface
                // if we use leaps()/rngs() then the stream is infinite
                .forEach(System.out::println);

        // each of the 5 generators generates 10 integers in an array
        List<int[]> listOfArrOfIntsLG = leapableRnd.leaps(5) // obtain 5 generators
                .map(r -> {
                    LeapableGenerator lg = (LeapableGenerator) r;                    
                    int[] ints = new int[10];
                    for (int i = 0; i < 10; i++) {
                        ints[i] = lg.nextInt();
                        lg.leap();
                    }
                    
                    return ints;
                }) // each generator generates 10 integers                               
                .collect(Collectors.toList()); // all 5 arrays are collected into a list

        System.out.println();
        System.out.println("List of arrays:");
        for (int i = 0; i < listOfArrOfIntsLG.size(); i++) {
            System.out.println("Array " + i + ": " + Arrays.toString(listOfArrOfIntsLG.get(i)));
        }
    }
}
