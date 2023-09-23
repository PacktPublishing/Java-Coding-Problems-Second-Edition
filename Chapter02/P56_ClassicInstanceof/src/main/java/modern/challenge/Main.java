package modern.challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    interface Furniture {};
    static class Plywood {};
    static class Wardrobe extends Plywood implements Furniture {};

    public static void main(String[] args) {

        Wardrobe wardrobe = new Wardrobe();
        System.out.println("wardrobe instanceof Wardrobe ? " 
                + (wardrobe instanceof Wardrobe));

        Plywood plywood = new Plywood();
        System.out.println("plywood instanceof Plywood ? " 
                + (plywood instanceof Plywood));
        
        System.out.println("wardrobe instanceof Plywood ? " 
                + (wardrobe instanceof Plywood));
        
        System.out.println("wardrobe instanceof Furniture ? " 
                + (wardrobe instanceof Furniture));
        
        System.out.println("plywood instanceof Furniture ? " 
                + (plywood instanceof Furniture));
        
        System.out.println("String instanceof Object ? " 
                + (String.valueOf("foo") instanceof Object));
        
        System.out.println("null instanceof Object ? " 
                + (null instanceof Object));
        
        List plywoods = List.of(new Plywood());
        System.out.println("plywoods instanceof List ? " 
                + (plywoods instanceof List));                 
        
        int[] ints = new int[] {1, 2, 3};
        System.out.println("ints instanceof int[] ? " 
                + (ints instanceof int[]));                                 
        
        listOf(1, 2, 3);
        listOf(List.of(1,2,3));
    }
    
    public static <T> void listOf(T... t) {        
        List<T> list = List.of(t);  
               
        System.out.println("list instanceof List ? " + (list instanceof List));
        System.out.println("list instanceof List<?> ? " + (list instanceof List<?>));        
        System.out.println("list instanceof List<T> ? " + (list instanceof List<T>));     
        
        // compile-time error
        // System.out.println("list instanceof List<Integer> ? " + (list instanceof List<Integer>));        
    }
    
    public static <T> void listOf(List<T> list) {
        
        System.out.println("list instanceof ArrayList<T> ? " + (list instanceof ArrayList<T>));         
        System.out.println("list instanceof ArrayList<?> ? " + (list instanceof ArrayList<?>));         
        
        // compile-time error
        // System.out.println("list instanceof ArrayList<Integer> ? " + (list instanceof ArrayList<Integer>));         
        
        System.out.println("list instanceof List<T> ? " + (list instanceof List<T>));         
        System.out.println("list instanceof List<?> ? " + (list instanceof List<?>));         
        
        // compile-time error
        // System.out.println("list instanceof List<String> ? " + (list instanceof List<String>));         
    }
}