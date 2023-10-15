package modern.challenge;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        // typical distinct (based on equals()
        cars.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        cars.stream()
                .collect(Collectors.toMap(Car::getBrand, Function.identity(), (c1, c2) -> c1))
                .values()
                .forEach(System.out::println);

        System.out.println();

        // works with nulls a well
        cars.stream()
                .collect(Streams.distinctByKeyV1(Car::getBrand))
                .values()
                .forEach(System.out::println);
        
        System.out.println();
        
        cars.stream()
                .collect(Streams.distinctByKeyV1(Car::getFuel))
                .values()
                .forEach(System.out::println);

        System.out.println();

        // doesn't work for nulls
        cars.stream()
                .filter(Streams.distinctByKeyV2(Car::getBrand))
                .forEach(System.out::println);

        System.out.println();

        // // doesn't work for nulls
        cars.stream()
                .filter(Streams.distinctByKeyV3(Car::getFuel))
                .forEach(System.out::println);
    }
}