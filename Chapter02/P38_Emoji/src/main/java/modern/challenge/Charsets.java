package modern.challenge;

import java.util.List;
import java.util.regex.Pattern;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

public class Charsets {

    private Charsets() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean containsEmojiV1(String str) {

        if (str == null) {
            throw new IllegalArgumentException("The given string cannot be null");
        }

        return str.codePoints().anyMatch(Character::isEmoji);
    }

    public static boolean containsEmojiV2(String str) {

        if (str == null) {
            throw new IllegalArgumentException("The given string cannot be null");
        }

        // using snake-regex you can write {IsEmoji_Modifier_Base}, {IsEmoji_Presentation}, and so on
        return Pattern.compile("\\p{IsEmoji}").matcher(str).find();
    }

    public static List<String> getAllEmoji() {

        return IntStream.range(0, Integer.MAX_VALUE)
                .filter(Character::isEmoji)
                .mapToObj(Character::toChars)
                .map(String::valueOf)
                .collect(toList());
    }
}
