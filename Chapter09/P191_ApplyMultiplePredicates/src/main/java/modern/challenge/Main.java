package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        
        // a predicate that keeps only Chevrolets
        Predicate<Car> pChevrolets = car -> car.getBrand().equals("Chevrolet");
        
        List<Car> chevrolets = cars.stream()                
                .filter(pChevrolets)
                .collect(Collectors.toList());
        System.out.println("Chevrolets:\n" + chevrolets);
                     
        // a predicate that keeps all the cars that are not Chevrolet
        Predicate<Car> pNotChevrolets1 = car -> !car.getBrand().equals("Chevrolet");
        Predicate<Car> pNotChevrolets2 = Predicate.not(pChevrolets);
        Predicate<Car> pNotChevrolets3 = pChevrolets.negate();       
        
        List<Car> notChevrolets1 = cars.stream()                
                .filter(pNotChevrolets1)                
                .collect(Collectors.toList());
        
        List<Car> notChevrolets2 = cars.stream()                
                .filter(pNotChevrolets2)                
                .collect(Collectors.toList());
        
        List<Car> notChevrolets3 = cars.stream()                
                .filter(pNotChevrolets3)                
                .collect(Collectors.toList());
        
        System.out.println("\nAll non-chevrolet cars (1):\n" + notChevrolets1);
        System.out.println("\nAll non-chevrolet cars (2):\n" + notChevrolets2);
        System.out.println("\nAll non-chevrolet cars (3):\n" + notChevrolets3);
        
        // a predicate that keeps only the cars with more than (or equal) 150 horsepower
        Predicate<Car> pHorsepower = car -> car.getHorsepower() >= 150;
                
        List<Car> notChevrolets150_1 = cars.stream()                
                .filter(pChevrolets.negate())
                .filter(pHorsepower)
                .collect(Collectors.toList());
        
        List<Car> notChevrolets150_2 = cars.stream()                
                .filter(pChevrolets.negate().and(pHorsepower))
                .collect(Collectors.toList());
        
        System.out.println("\nAll non-chevrolet cars with at least 150 horsepower (1):\n" + notChevrolets150_1);
        System.out.println("\nAll non-chevrolet cars with at least 150 horsepower (2):\n" + notChevrolets150_2);
        
        // a predicate that keeps only the electric cars
        Predicate<Car> pElectric = car -> car.getFuel().equals("electric");
        
        List<Car> chevroletsOrElectric = cars.stream()                
                .filter(pChevrolets.or(pElectric))
                .collect(Collectors.toList());
        
        System.out.println("\nAll chevrolets or electric cars:\n" + chevroletsOrElectric);
        
        /* using Predicates helpers */
        
        // and
        Predicate<Car> pLexus = car -> car.getBrand().equals("Lexus");
        Predicate<Car> pDiesel = car -> car.getFuel().equals("diesel");        
        Predicate<Car> p250 = car -> car.getHorsepower() > 250;                
                
        Predicate<Car> predicateAnd = Predicates.asOneAnd(pLexus, pDiesel, p250);
        
        List<Car> lexusDiesel250And = cars.stream()                
                .filter(predicateAnd)                
                .collect(Collectors.toList());
        
        System.out.println("\nLexus, diesel with more than 250 housepower:\n" + lexusDiesel250And);
        
        // or
        Predicate<Car> pGasoline = car -> car.getFuel().equals("gasoline");        
                
        Predicate<Car> predicateOr = Predicates.asOneOr(pDiesel, pGasoline);
                
        List<Car> dieselGasolineOr = cars.stream()                
                .filter(predicateOr)                
                .collect(Collectors.toList());
        
        System.out.println("\nAll diesel or gasoline car:\n" + dieselGasolineOr);
        
        // and-or combo
        Predicate<Car> p100 = car -> car.getHorsepower() >= 100;
        Predicate<Car> p200 = car -> car.getHorsepower() <= 200;
        
        Predicate<Car> p300 = car -> car.getHorsepower() >= 300;
        Predicate<Car> p400 = car -> car.getHorsepower() <= 400;
        
        Predicate<Car> pCombo = Predicates.asOneOr(
                Predicates.asOneAnd(p100, p200), Predicates.asOneAnd(p300, p400));
        
        List<Car> comboAndOr = cars.stream()                
                .filter(pCombo)                
                .collect(Collectors.toList());
        
        System.out.println("\nAll cars having horsepower between 100 and 200 or 300 and 400:\n" + comboAndOr);
    }
}