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
        
        List cars123 = List.of(car1, car2, car3);
         
        Streams.of(cars.stream()).stream().forEach(System.out::println);
        
        System.out.println();
        
        boolean f11 = Streams.of(cars.stream()).contains(car1);
        boolean f12 = Streams.of(cars.stream()).containsAll(car1, car2, car3);
        boolean f13 = Streams.of(cars.stream()).containsAll(cars123);
        boolean f14 = Streams.of(cars.stream()).containsAll(cars123.stream());
        boolean f15 = Streams.of(cars123.stream()).containsAll(cars.stream());
        
        System.out.println("f11: " + f11);
        System.out.println("f12: " + f12);
        System.out.println("f13: " + f13);
        System.out.println("f14: " + f14);                   
        System.out.println("f15: " + f15);                   
                
        System.out.println();
                
        boolean f21 = Streams.of(cars.stream()).containsAny(car1, car2, car3);
        boolean f22 = Streams.of(cars.stream()).containsAny(cars123);
        boolean f23 = Streams.of(cars.stream()).containsAny(cars123.stream());
        boolean f24 = Streams.of(cars123.stream()).containsAny(cars.stream());
        
        System.out.println("f21: " + f21);
        System.out.println("f22: " + f22);
        System.out.println("f23: " + f23);        
        System.out.println("f24: " + f24);        
    }
}