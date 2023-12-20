package modern.challenge;

import java.util.stream.Collectors;

public class Charsets {

    private Charsets() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String strToBinary(String str) {

        if (str == null) {
            throw new IllegalArgumentException("The given string cannot be null");
        }

        String binary = str.chars()
                .mapToObj(Integer::toBinaryString)
                .map(t -> "0" + t)
                .collect(Collectors.joining(" "));

        return binary;
    }
    
    public static String codePointToBinary(String str) {

        if (str == null) {
            throw new IllegalArgumentException("The given string cannot be null");
        }

        String binary = str.codePoints()
                .mapToObj(Integer::toBinaryString)
                .collect(Collectors.joining(" "));

        return binary;
    }
}
