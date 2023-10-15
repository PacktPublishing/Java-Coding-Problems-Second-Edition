package modern.challenge;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Car> cars = Map.of(
                1, new Car("Dacia", "diesel", 100),
                2, new Car("Lexus", "gasoline", 300),
                3, new Car("Chevrolet", "electric", 150),
                4, new Car("Mercedes", "gasoline", 150),
                5, new Car("Chevrolet", "diesel", 250),
                6, new Car("Ford", "electric", 80),
                7, new Car("Chevrolet", "diesel", 450),
                8, new Car("Mercedes", "electric", 200),
                9, new Car("Chevrolet", "gasoline", 350),
                10, new Car("Lexus", "diesel", 300)
        );

        // Map -> Stream -> Filter -> String
        String electricBrands1 = cars.entrySet().stream()
                .filter(c -> "electric".equals(c.getValue().getFuel()))
                .map(c -> c.getValue().getBrand())
                .collect(Collectors.joining(", "));
        
        String electricBrands2 = cars.values().stream()
                .filter(c -> "electric".equals(c.getFuel()))
                .map(c -> c.getBrand())
                .collect(Collectors.joining(", "));

        System.out.println("Electric brands (1):" + electricBrands1);
        System.out.println("Electric brands (2):" + electricBrands2);
        
        // Map -> Stream -> Filter -> String
        Car newCar = new Car("No name", "gasoline", 350);

        String carsAsNewCar1 = cars.entrySet().stream()
                .filter(c -> (c.getValue().getFuel().equals(newCar.getFuel())
                           && c.getValue().getHorsepower() == newCar.getHorsepower()))
                .map(map -> map.getValue().getBrand())
                .collect(Collectors.joining(", "));
        
        String carsAsNewCar2 = cars.values().stream()
                .filter(c -> (c.getFuel().equals(newCar.getFuel())
                           && c.getHorsepower() == newCar.getHorsepower()))
                .map(map -> map.getBrand())
                .collect(Collectors.joining(", "));
        
        System.out.println("\nCars as new car (1):" + carsAsNewCar1);                
        System.out.println("Cars as new car (2):" + carsAsNewCar2);              

        // Map -> Stream -> Filter -> Map
        Map<Integer, Car> carsTop5a = cars.entrySet().stream()
                .filter(c -> c.getKey() <= 5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        //or, .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));
        
         Map<Integer, Car> carsTop5s = Filters.byKey(cars, c -> c <= 5);

        System.out.println("\nTop 5:\n" + carsTop5a);
        System.out.println("\nTop 5:\n" + carsTop5s);
        
        // Map -> Stream -> Filter -> Map
        Map<Integer, Car> hp100Top5a = cars.entrySet().stream()
                .filter(c -> c.getValue().getHorsepower() > 100)
                .sorted(Entry.comparingByValue(Comparator.comparingInt(Car::getHorsepower)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
                        (c1, c2) -> c2, LinkedHashMap::new));
        //or, .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue(), 
        //              (c1, c2) -> c2, LinkedHashMap::new));
        
        Map<Integer, Car> hp100Top5s = Filters.byValue(cars, c -> c.getHorsepower() > 100);                
        
        Map<Integer, Car> hp100Top5d = Filters.sortedbyValue(cars, c -> c.getHorsepower() > 100,
                Comparator.comparingInt(Car::getHorsepower));                

        System.out.println("\nTop 5 cars with more than 100 HP (sorted):\n" + hp100Top5a);
        System.out.println("\nTop 5 cars with more than 100 HP (not sorted):\n" + hp100Top5s);                
        System.out.println("\nTop 5 cars with more than 100 HP (sorted):\n" + hp100Top5d);
    }
}