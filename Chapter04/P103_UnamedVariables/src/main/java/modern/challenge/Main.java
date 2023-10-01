package modern.challenge;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        // in a catch block         
        int divisor = 0;
        try {
            int result = 1 / divisor;  
            // use result
        } catch (ArithmeticException _) {
            System.out.println("Divisor " + divisor + " is not good");
        }        
        
        // in a simple for loop        
        int[] arr = new int[]{1, 2, 3};
        for (int i = 0, _ = logLoopStart(i); i < arr.length; i++) {
            // use i
        }        
        
        // in an enhanced for loop        
        int score = 0;
        List<String> cards = List.of("12 spade", "6 diamond", "14 diamond");
        for (String _ : cards) {
            if (score < 10) { 
                score ++;
            } else {
                score --;
            }
        }        
        
        // in an assignment that ignores the result        
        boolean _ = Files.deleteIfExists(Path.of("/file.txt"));        
        // var _ = Files.deleteIfExists(Path.of("/file.txt"));                
        
        // in try-with-resources        
        try (Arena _ = Arena.ofConfined()) {
            // don't use arena
        }        
        
        // in lambda expressions        
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600)
        );
        
        Map<String, Integer> resultToMap = melons.stream()
                .collect(Collectors.toMap(Melon::getType, Melon::getWeight,
                        (oldValue, _) -> oldValue));         
    }
    
    private static int logLoopStart(int i) {
        System.out.println("Loop started ...");
        
        return i;
    }
}