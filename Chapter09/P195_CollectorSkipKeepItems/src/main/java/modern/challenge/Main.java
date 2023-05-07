package modern.challenge;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = List.of(
                new Car("Chevrolet", "diesel", 350),
                new Car("Dacia", "diesel", 100),
                new Car("Lexus", "gasoline", 300),
                new Car("Chevrolet", "electric", 150),
                new Car("Mercedes", "electric", 150),
                new Car("Chevrolet", "diesel", 250),
                new Car("Lexus", "gasoline", 300),
                new Car("Ford", "electric", 80),
                new Car("Chevrolet", "diesel", 450),
                new Car("Mercedes", "electric", 200),
                new Car("Chevrolet", "gasoline", 350),
                new Car("Lexus", "diesel", 300)
        );

        List<Car> first5Cars = cars.stream()
                .collect(MyCollectors.toUnmodifiableListKeep(5));

        System.out.println("\nFirst 5 cars: " + first5Cars);

        List<Car> last5Cars1 = cars.stream()
                .collect(MyCollectors.toUnmodifiableListSkip(5));

        System.out.println("\nLast 5 cars: " + last5Cars1);
        
        List<Car> last5Cars2 = cars.stream()
                .collect(MyCollectors.toUnmodifiableListSkipOptimized(5));

        System.out.println("\nLast 5 cars: " + last5Cars2);
    }
}