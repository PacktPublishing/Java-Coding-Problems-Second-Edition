package modern.challenge;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class Main {

    public static void main(String[] args) {
                
        RandomGenerator generator = RandomGeneratorFactory.all()
                .filter(RandomGeneratorFactory::isLeapable)
                .filter(RandomGeneratorFactory::isStatistical)
                .findFirst()
                .map(RandomGeneratorFactory::create)
                .orElseThrow(() -> new RuntimeException("Cannot find this kind of generator"));              
        System.out.println("Leapable generator: " + generator);
    }
}
