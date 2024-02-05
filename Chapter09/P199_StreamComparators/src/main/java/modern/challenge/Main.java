package modern.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsLast;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> nrs = new ArrayList<>();
        nrs.add(1); nrs.add(6); nrs.add(3); nrs.add(8); nrs.add(2); nrs.add(3); nrs.add(0);

        List<String> strs = new ArrayList<>();
        strs.add("book"); strs.add("old"); strs.add("new"); strs.add("quiz"); strs.add("around"); strs.add("tick");

        List<Car> cars = List.of(
                new Car("Dacia", "diesel", 100),
                new Car("Lexus", "gasoline", 300),
                new Car("Chevrolet", "electric", 150),
                new Car("Mercedes", null, 150),
                new Car("Chevrolet", "diesel", 250),
                new Car("Ford", "electric", 80),
                new Car("Chevrolet", "diesel", 450),
                new Car("Mercedes", "electric", 200),
                new Car("Chevrolet", null, 350),
                new Car("Lexus", "diesel", 300)
        );

        System.out.println("Natural order:");

        System.out.println();

        nrs.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        strs.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        
        nrs.stream()
                .sorted((n1, n2) -> n1.compareTo(n2))
                .forEach(System.out::println);
        
        System.out.println();
        
        strs.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .forEach(System.out::println);
        
        System.out.println();

        nrs.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        System.out.println();

        strs.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        System.out.println();
        
        System.out.println("Reverse natural order:");

        System.out.println();

        nrs.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println();

        strs.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        
        System.out.println();
        
        System.out.println("Null first:");

        System.out.println();
        
        nrs.add(null);
        
        /* - NPE
        nrs.stream()
                .sorted()
                .forEach(System.out::println);
        */               
        
        System.out.println();
        
        nrs.stream()
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .forEach(System.out::println);
        
        System.out.println();
        
        nrs.stream()
                .sorted(Comparator.nullsLast(Comparator.naturalOrder()))
                .forEach(System.out::println);
        
        System.out.println();
        
        nrs.stream()
                .sorted(Comparator.nullsFirst(Comparator.reverseOrder()))
                .forEach(System.out::println);
        
        System.out.println();
        
        System.out.println("Custom comparator:");

        System.out.println();
        
        strs.stream()
                .sorted((s1, s2) -> Character.compare(s1.charAt(s1.length() - 1), 
                        s2.charAt(s2.length() - 1)))
                .forEach(System.out::println);
                
        System.out.println();
        
        /* - we need to implement java.lang.Comparable 
        cars.stream()
                .sorted()
                .forEach(System.out::println);
        */
        
        cars.stream()
                .sorted(Comparator.comparingInt(Car::getHorsepower))
                .forEach(System.out::println);
        
        System.out.println();
        
        cars.stream()
                .sorted(Comparator.comparingInt(Car::getHorsepower).reversed())
                .forEach(System.out::println);
        
        System.out.println();
        
        cars.stream()
                .sorted(Comparator.comparing(Car::getFuel, 
                        Comparator.nullsLast(Comparator.naturalOrder())))
                .forEach(System.out::println);
        
        System.out.println();
        
        cars.stream()
                .sorted(Comparator.comparing(Car::getFuel, 
                        Comparator.nullsLast(
                                (s1, s2) -> Character.compare(s1.charAt(s1.length() - 1), 
                                        s2.charAt(s2.length() - 1)))))
                .forEach(System.out::println);
        
         System.out.println();
         
        // same result as the previous example but more readable
        Comparator<String> byCharAt = nullsLast(
                                (s1, s2) -> Character.compare(s1.charAt(s1.length() - 1), 
                                        s2.charAt(s2.length() - 1)));
        Comparator<Car> byFuelAndCharAt = comparing(Car::getFuel, byCharAt);
        cars.stream()
                .sorted(byFuelAndCharAt)
                .forEach(System.out::println);
    }
}