package modern.challenge;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(new Car("Dacia", "diesel", 100),
                new Car("Lexus", "gasoline", 300), new Car("Chevrolet", "electric", 150),
                new Car("Mercedes", "gasoline", 150), new Car("Chevrolet", "diesel", 250),
                new Car("Ford", "electric", 80), new Car("Chevrolet", "diesel", 450),
                new Car("Mercedes", "electric", 200), new Car("Chevrolet", "gasoline", 350),
                new Car("Lexus", "diesel", 300), new Car("Ford", "electric", 200)
        );

        Car car1 = new Car("Lexus", "diesel", 300);
        Car car2 = new Car("Ford", "electric", 80);
        Car car3 = new Car("Chevrolet", "electric", 150);

        List<Car> cars123 = List.of(car1, car2, car3);

        cars.stream().forEach(System.out::println);
        
        System.out.println();
        Streams.from(cars.stream())
                .remove(car1)
                .stream()                
                .forEach(System.out::println);

        System.out.println();
        Streams.from(Streams.from(cars.stream().distinct())
                .retainAll(car1, car2, car3)
                .stream()
                .filter(car -> car.getFuel().equals("electric")))
                .removeAll(car2)
                .stream()
                .forEach(System.out::println);

        System.out.println();
        Streams.from(cars.stream())
                .retainAll(cars123)
                .stream()
                .forEach(System.out::println);

        System.out.println();
        Streams.from(cars.stream())
                .retainAll(cars123)
                .removeAll(car1, car3)
                .stream()
                .forEach(System.out::println);
    }
}