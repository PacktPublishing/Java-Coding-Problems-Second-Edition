
package modern.challenge;

import java.util.Arrays;
import static modern.challenge.Main.Hero.HULK;
import static modern.challenge.Main.Hero.IRON_MAN;

public class Main {
        
    static abstract class Pill {}
    static class Nurofen extends Pill {}      
    static class Ibuprofen extends Pill {}
    static class Piafen extends Pill {}    

    private static String headache(Pill o) {

        return switch(o) {                       
            case Nurofen nurofen -> "Get Nurofen ...";                                    
            case Ibuprofen ibuprofen -> "Get Ibuprofen ...";                     
            case Piafen piafen -> "Get Piafen ...";                          
                
            default -> "Sorry, we cannot solve your headache!";
        };                       
    }

    static abstract class Drink {}
    static class Small extends Drink {}
    static class Medium extends Small {}
    static class Large extends Medium {}
    static class Extra extends Medium {}
    static class Huge extends Extra {}
    static class Jumbo extends Extra {}
    
    private static String buyDrink(Drink o) {
        
        return switch(o) {         
            case Jumbo j: yield "We can give a Jumbo ...";                        
            case Huge h: yield "We can give a Huge ...";                        
            case Extra e: yield "We can give a Extra ...";            
            case Large l: yield "We can give a Large ...";
            case Medium m: yield "We can give a Medium ...";                                                
            case Small s: yield "We can give a Small ...";            
            default: yield "Sorry, we don't have this drink!";
        };
    }
    
    private static int oneHundredDividedBy(Integer value) {
        
        return switch(value) {                  
            case 0 -> 0;            
            case Integer i -> 100/i;                      
        };
    }
    
    enum Hero { CAPTAIN_AMERICA, IRON_MAN, HULK }
    
    private static String callMyMarvelHero(Hero hero) {
        
        return switch(hero) {        
            case HULK -> "Sorry, we cannot call this guy!";
            case Hero h -> "Calling " + h;            
        };
        
    }
    
    private static int oneHundredDividedByPositive(Integer value) {
        
        return switch(value) {      
            case 0 -> 0;
            case Integer i when i > 0 -> 100/i;                            
            case Integer i -> (-1) * 100/i;    
        };
    }
    
    public static void main(String[] args) {
        
        Arrays.asList(new Nurofen(), new Ibuprofen(), new Piafen()).stream()
                .map(Main::headache)
                .forEach(System.out::println);
        
        System.out.println();
        
        Arrays.asList(new Jumbo(), new Huge(), new Extra(), new Large(), new Medium(), new Small()).stream()
                .map(Main::buyDrink)
                .forEach(System.out::println);
        
        System.out.println();
                
        System.out.println(oneHundredDividedBy(10));
        System.out.println(oneHundredDividedBy(0));
        
        System.out.println();
        
        System.out.println(callMyMarvelHero(IRON_MAN));
        System.out.println(callMyMarvelHero(HULK));
        
        System.out.println();
                
        System.out.println(oneHundredDividedByPositive(10));
        System.out.println(oneHundredDividedByPositive(0));
        System.out.println(oneHundredDividedByPositive(-10));
    }
}