package modern.challenge;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

    public static final String LETTER = "A";
    public static final String CHINESE = "暗";
    public static final String EMOJI = "😍";
    public static final String STR = "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    public static void main(String[] args) throws IOException {

        System.out.println("""
            ////////////////////////////////////////////////////////////////////////
            // For Unicode characters having code point less than 65,535 (0xFFFF) //
            ////////////////////////////////////////////////////////////////////////
            """);

        String l1 = Charsets.stringToBinaryEncoding(LETTER, "UTF-32");
        String l2 = Charsets.stringToBinaryEncoding(LETTER, StandardCharsets.UTF_16BE.name());
        String l3 = Charsets.stringToBinaryEncoding(LETTER, StandardCharsets.UTF_16LE.name());
        String l4 = Charsets.stringToBinaryEncoding(LETTER, StandardCharsets.UTF_8.name());
        System.out.println("LETTER (UTF-32): " + l1);
        System.out.println("LETTER (UTF_16BE): " + l2);
        System.out.println("LETTER (UTF_16LE): " + l3);
        System.out.println("LETTER (UTF_8): " + l4);

        System.out.println();

        String c1 = Charsets.stringToBinaryEncoding(CHINESE, "UTF-32");
        String c2 = Charsets.stringToBinaryEncoding(CHINESE, StandardCharsets.UTF_16BE.name());
        String c3 = Charsets.stringToBinaryEncoding(CHINESE, StandardCharsets.UTF_16LE.name());
        String c4 = Charsets.stringToBinaryEncoding(CHINESE, StandardCharsets.UTF_8.name());
        System.out.println("CHINESE (UTF-32): " + c1);
        System.out.println("CHINESE (UTF_16BE): " + c2);
        System.out.println("CHINESE (UTF_16LE): " + c3);
        System.out.println("CHINESE (UTF_8): " + c4);

        System.out.println();

        String e1 = Charsets.stringToBinaryEncoding(EMOJI, "UTF-32");
        String e2 = Charsets.stringToBinaryEncoding(EMOJI, StandardCharsets.UTF_16BE.name());
        String e3 = Charsets.stringToBinaryEncoding(EMOJI, StandardCharsets.UTF_16LE.name());
        String e4 = Charsets.stringToBinaryEncoding(EMOJI, StandardCharsets.UTF_8.name());
        System.out.println("EMOJI (UTF-32): " + e1);
        System.out.println("EMOJI (UTF_16BE): " + e2);
        System.out.println("EMOJI (UTF_16LE): " + e3);
        System.out.println("EMOJI (UTF_8): " + e4);

        System.out.println();
        
        String s1 = Charsets.stringToBinaryEncoding(STR, "UTF-32");
        String s2 = Charsets.stringToBinaryEncoding(STR, StandardCharsets.UTF_16BE.name());
        String s3 = Charsets.stringToBinaryEncoding(STR, StandardCharsets.UTF_16LE.name());
        String s4 = Charsets.stringToBinaryEncoding(STR, StandardCharsets.UTF_8.name());
        System.out.println("STR (UTF-32): " + s1);
        System.out.println("STR (UTF_16BE): " + s2);
        System.out.println("STR (UTF_16LE): " + s3);
        System.out.println("STR (UTF_8): " + s4);
    }
}