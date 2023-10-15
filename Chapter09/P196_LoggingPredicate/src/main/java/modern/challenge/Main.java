package modern.challenge;

import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<Car> cars = Arrays.asList(new Car("Dacia", "diesel", 100),
                new Car("Lexus", "gasoline", 300), new Car("Chevrolet", "electric", 150),
                new Car("Mercedes", "gasoline", 150), new Car("Chevrolet", "diesel", 250),
                new Car("Ford", "electric", 80), new Car("Chevrolet", "diesel", 450),
                new Car("Mercedes", "electric", 200), new Car("Chevrolet", "gasoline", 350),
                new Car("Lexus", "diesel", 300), new Car("Ford", "electric", 200)
        );
        
        LogPredicate<Car> predicate = car -> car.getFuel().equals("electric");
        
        cars.stream()
                .filter(t -> predicate.testAndLog(t, "electric"))
                .forEach(System.out::println);
        
        System.out.println();
        
        cars.stream()
                .filter(Predicates.testAndLog(car -> car.getFuel().equals("electric"), "electric"))
                .forEach(System.out::println);
    }
}