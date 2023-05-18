package modern.challenge;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Car> cars = Map.of(
                1, new Car("Dacia", "diesel", 350),
                2, new Car("Lexus", "gasoline", 350),
                3, new Car("Chevrolet", "electric", 150),
                4, new Car("Mercedes", "gasoline", 150),
                5, new Car("Chevrolet", "diesel", 250),
                6, new Car("Ford", "electric", 80),
                7, new Car("Chevrolet", "diesel", 450),
                8, new Car("Mercedes", "electric", 200),
                9, new Car("Chevrolet", "gasoline", 350),
                10, new Car("Lexus", "diesel", 300)
        );

        // [7(450), 1(350), 2(350), 9(350), 10(300), 5(250), 8(200), 3(150), 4(150), 6(80)]
        List<String> result1 = cars.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().getHorsepower() == c1.getValue().getHorsepower()
                ? c1.getKey().compareTo(c2.getKey())
                : Integer.valueOf(c2.getValue().getHorsepower())
                        .compareTo(c1.getValue().getHorsepower()))
                .map(c -> c.getKey() + "(" + c.getValue().getHorsepower() + ")")
                .toList();

        // [7(450), 1(350), 2(350), 9(350), 10(300), 5(250), 8(200), 3(150), 4(150), 6(80)]
        List<String> result2 = cars.entrySet().stream()
                .sorted(Entry.<Integer, Car>comparingByValue(
                        Comparator.comparingInt(Car::getHorsepower).reversed())
                        .thenComparing(Entry.comparingByKey()))
                .map(c -> c.getKey() + "(" + c.getValue().getHorsepower() + ")")
                .toList();

        System.out.println(result1);
        System.out.println(result2);
    }
}