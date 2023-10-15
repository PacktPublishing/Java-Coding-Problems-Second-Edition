package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String text = """
                      test, a, 1, 4, 5, 0xf5, 0x5, 4.5d, 6, 5.6, 50000, 345, 
                      4.0f, 6$3, 2$1.1, 5.5, 6.7, 8, a11, 3e+1, -11199, 55                      
                      """;
        
        // [1.0, 4.0, 5.0, 4.5, 6.0, 5.6, 50000.0, 345.0, 4.0, 5.5, 6.7, 8.0, 30.0, -11199.0, 55.0]
        List<Double> doubleValues = parseText(text, Double::valueOf);
        System.out.println("Doubles: " + doubleValues);
        
        // [1.0, 4.0, 5.0, 4.5, 6.0, 5.6, 50000.0, 345.0, 4.0, 5.5, 6.7, 8.0, 30.0, -11199.0, 55.0]
        List<Float> floatValues = parseText(text, Float::valueOf);
        System.out.println("Floats: " + floatValues);
        
        // [1, 4, 5, 6, 50000, 345, 8, -11199, 55]
        List<Long> longValues = parseText(text, Long::valueOf);
        System.out.println("Longs: " + longValues);
        
        // [1, 4, 5, 6, 50000, 345, 8, -11199, 55]
        List<Integer> integerValues = parseText(text, Integer::valueOf);
        System.out.println("Integers: " + integerValues);
        
        // [1, 4, 5, 6, 345, 8, -11199, 55]
        List<Short> shortValues = parseText(text, Short::valueOf);
        System.out.println("Shorts: " + shortValues);
        
        // [1, 4, 5, 6, 8, 55]
        List<Byte> byteValues = parseText(text, Byte::valueOf);
        System.out.println("Bytes: " + byteValues);

        List<Double> moreDoubleValues = parseText(text, 
                t -> Double.valueOf(t.replaceAll("\\$", "").replaceAll("xf", ".").replaceAll("x", ".")));
        
        System.out.println();
        // [1.0, 4.0, 5.0, 0.5, 0.5, 4.5, 6.0, 5.6, 50000.0, 345.0, 4.0, 63.0, 21.1, 5.5, 6.7, 8.0, 30.0, -11199.0, 55.0]
        System.out.println("More doubles: " + moreDoubleValues);

        Double[] doubleArr = moreDoubleValues.toArray(Double[]::new);
        System.out.println();
        System.out.println("More doubles array: " + Arrays.toString(doubleArr));
    }

    public static <T> List<T> parseText(String text, Function<String, T> func) {
        return Arrays.stream(text.split(","))
                .filter(s -> !s.isEmpty())
                .map(s -> {
                    try {
                        return func.apply(s.trim());
                    } catch (Exception e) {}
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}