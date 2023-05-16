package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(new Car("Dacia", "diesel", 100),
                new Car("Lexus", "gasoline", 300), new Car("Chevrolet", "electric", 150),
                new Car("Mercedes", "gasoline", 150), new Car("Chevrolet", "diesel", 250),
                new Car("Ford", "electric", 80), new Car("Chevrolet", "diesel", 450),
                new Car("Mercedes", "electric", 200), new Car("Chevrolet", "gasoline", 350),
                new Car("Lexus", "diesel", 300), new Car("Ford", "electric", 200)
        );

        Car car = new Car("Ford", "electric", 80);

        Predicate<Car> predicate = cars::contains;
        System.out.println(predicate.test(car));

        System.out.println(cars.stream().anyMatch(p -> p.equals(car)));

        BiPredicate<List<Car>, Car> biPredicate = List::contains;
        System.out.println(biPredicate.test(cars, car));
    }
}
