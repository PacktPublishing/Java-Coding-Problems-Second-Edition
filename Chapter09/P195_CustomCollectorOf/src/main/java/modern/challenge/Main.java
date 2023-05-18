package modern.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
        
        TreeSet<String> electricBrands = cars.values().stream()
                .filter(c -> "electric".equals(c.getFuel()))
                .map(c -> c.getBrand())
                .collect(MyCollectors.toTreeSet());

        System.out.println("Electric brands: " + electricBrands);
        
        LinkedHashSet<Integer> hpSorted = cars.values().stream()
                .map(c -> c.getHorsepower())
                .sorted()
                .collect(MyCollectors.toLinkedHashSet());
        
        System.out.println("Sorted horsepower: " + hpSorted);
        
        LinkedHashSet<Integer> excludeHp200 = cars.values().stream()
                .map(c -> c.getHorsepower())
                .sorted()
                .collect(MyCollectors.exclude(c -> c > 200, MyCollectors.toLinkedHashSet()));
        
        System.out.println("Sorted horsepower less than 200: " + excludeHp200);
        
        Vehicle mazda = new Car("Mazda", "diesel", 155);
        Vehicle ferrari = new Car("Ferrari", "gasoline", 500);
        
        Vehicle hov = new Submersible("HOV", 3000);
        Vehicle rov = new Submersible("ROV", 7000);
        
        List<Vehicle> vehicles = List.of(mazda, hov, ferrari, rov);
        
        List<Car> onlyCars = vehicles.stream()
                .collect(MyCollectors.toType(Car.class, ArrayList::new));
        
        Set<Submersible> onlySubmersible = vehicles.stream()
                .collect(MyCollectors.toType(Submersible.class, HashSet::new));
        
        System.out.println("Only cars:" + onlyCars);
        System.out.println("Only submersible:" + onlySubmersible);       
        
        SplayTree st = cars.values().stream()
                .map(c -> c.getHorsepower())
                .collect(MyCollectors.toSplayTree());
                
        System.out.println("SplayTree:");
        st.print(SplayTree.TraversalOrder.IN);
    }
}

