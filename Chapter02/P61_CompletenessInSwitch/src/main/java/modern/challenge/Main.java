package modern.challenge;

import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDesc;
import java.lang.constant.DynamicConstantDesc;
import java.lang.constant.MethodHandleDesc;
import java.lang.constant.MethodTypeDesc;
import java.nio.CharBuffer;
import java.util.Arrays;
import javax.swing.text.Segment;

public class Main {     
    
    static class Vehicle {}
    static class Car extends Vehicle {}
    static class Van extends Vehicle {}
    static class Truck extends Vehicle {} // since there is no case Truck this 
                                          // will be handle by default label or case Vehicle
    
    private static String whatAmI(Vehicle vehicle) {
        
        return switch(vehicle) {
            case Car car -> "You're a car";
            case Van van -> "You're a van";
            case Vehicle v -> "You're a vehicle"; // this is a total pattern
                
            // default -> "I have no idea ... what are you?"; // can be used instead of the total pattern            
        };
    }
    
    private static String whatAmI(Object o) {
        
        return switch(o) {
            case Car car -> "You're a car";
            case Van van -> "You're a van";
            case Vehicle v -> "You're a vehicle";
            case Object obj -> "You're an object";
                
            // default -> "I have no idea ... what are you?"; // can be used instead of the total pattern            
        };
    }
    
    private static String whatAmI(CharSequence cs) {
        
        return switch(cs) {            
            case String str -> "You're a string";            
            case Segment segment -> "You're a Segment";
            case CharBuffer charbuffer -> "You're a CharBuffer";
            case StringBuffer strbuffer -> "You're a StringBuffer";
            case StringBuilder strbuilder -> "You're a StringBuilder";               
            case CoolChar cool -> "Welcome ... you're a CoolChar";  // we have created this
            case CharSequence charseq -> "You're a CharSequence";   // this is a total pattern
            
            // default -> "I have no idea ... what are you?"; // can be used instead of the total pattern            
        };
    }    
    
    private static class CoolChar implements CharSequence {
        @Override public int length() { return 0; }
        @Override public char charAt(int index) { return '0'; };
        @Override public CharSequence subSequence(int start, int end) { return null; }                
    }
        
    // ConstantDesc is sealed
    private static String whatAmI(ConstantDesc constantDesc) {
        
        return switch(constantDesc) {            
            case Integer i -> "You're an Integer";
            case Long l -> "You're a Long";
            case Float f -> " You're a Float";
            case Double d -> "You're a Double";
            case String s -> "You're a String";
            case ClassDesc cd -> "You're a ClassDesc";
            case DynamicConstantDesc dcd -> "You're a DCD";            
            case MethodHandleDesc mhd -> "You're a MethodHandleDesc";
            case MethodTypeDesc mtd -> "You're a MethodTypeDesc";                        
        };        
    }
           
    sealed interface Player {}
    final static class Tennis implements Player {}
    final static class Football implements Player {}
    final static class Snooker implements Player {}    
   // final static class Golf implements Player {} // enable this to see how the compiler warns you 
                                                   // about not covering all possible cases in switch
    
    private static String trainPlayer(Player p) {       

        return switch (p) {
            case Tennis t -> "Training the tennis player ..." + t;
            case Football f -> "Training the football player ..." + f;
            case Snooker s -> "Training the snooker player ..." + s;  
            // case Golf g -> "Training the snooker player ..." + g;      
            // case Player player -> "Training some player"; // most probably you don't want to do this   
            // default -> "No player";                       // most probably you don't want to do this   
        };
    }
    
    private enum PlayerTypes {
        TENNIS,
        FOOTBALL,
        SNOOKER,
        // GOLF // enable this to see how the compiler warns you 
                // about not covering all possible cases in switch
    }
    
    private static String createPlayer(PlayerTypes p) {       

        return switch (p) {
            case TENNIS -> "Creating a tennis player ...";
            case FOOTBALL -> "Creating a football player ...";
            case SNOOKER -> "Creating a snooker player ..."; 
            // case GOLF -> "Creating a golf player ...";   
            // case PlayerTypes pt -> "Creating some player"; // most probably you don't want to do this            
            // default -> "No player was created";            // most probably you don't want to do this   
        };
    }                

    public static void main(String[] args) {
        
        Arrays.asList(new Car(), new Van(), new Truck()).stream()
                .map(Main::whatAmI)
                .forEach(System.out::println);
        
        System.out.println();
        
        Arrays.asList(new Car(), new Van(), new Truck(), new String()).stream()
                .map(Main::whatAmI)
                .forEach(System.out::println);
        
        System.out.println();
        
        Arrays.asList(new String(), new StringBuilder(), new CoolChar()).stream()
                .map(Main::whatAmI)
                .forEach(System.out::println);
        
        System.out.println();
        
        Arrays.asList(new Football(), new Tennis(), new Snooker()).stream()
                .map(Main::trainPlayer)
                .forEach(System.out::println);
        
        System.out.println();
        
        Arrays.asList(PlayerTypes.FOOTBALL, PlayerTypes.SNOOKER, PlayerTypes.TENNIS).stream()
                .map(Main::createPlayer)
                .forEach(System.out::println);
    }
}