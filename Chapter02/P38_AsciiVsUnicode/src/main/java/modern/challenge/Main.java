package modern.challenge;

import java.io.IOException;

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

        int cp1 = LETTER.charAt(0);
        String hcp1 = Integer.toHexString(cp1);
        String bcp1 = Integer.toBinaryString(cp1);
        System.out.println("LETTER, Decimal code point: " + cp1);
        System.out.println("LETTER, Hexadecimal code point: " + hcp1);
        System.out.println("LETTER, Binary encoding: " + bcp1);

        System.out.println();

        int cp2 = CHINESE.charAt(0);
        String hcp2 = Integer.toHexString(cp2);
        String bcp2 = Integer.toBinaryString(cp2);
        System.out.println("CHINESE, Decimal code point: " + cp2);
        System.out.println("CHINESE, Hexadecimal code point: " + hcp2);
        System.out.println("CHINESE, Binary encoding: " + bcp2);

        System.out.println();

        // this return a wrong result because the code point of 😍 is 128525 > 65535
        int cp3 = EMOJI.charAt(0);
        String hcp3 = Integer.toHexString(cp3);
        String bcp3 = Integer.toBinaryString(cp3);
        System.out.println("EMOJI, Wrong decimal code point: " + cp3);
        System.out.println("EMOJI, Wrong hexadecimal code point: " + hcp3);
        System.out.println("EMOJI, Wrong binary encoding: " + bcp3);

        System.out.println();

        String result1 = Charsets.strToBinary("Hello World");
        System.out.println("Binary 'Hello World':" + result1);

        String result2 = Charsets.strToBinary(LETTER);
        System.out.println("LETTER, Binary:" + result2);

        String result3 = Charsets.strToBinary(CHINESE);
        System.out.println("CHINESE, Binary:" + result3);

        // this return a wrong result because the code point of 😍 is 128525 > 65535
        String result4 = Charsets.strToBinary(EMOJI);
        System.out.println("EMOJI, Binary:" + result4);
        
        System.out.println();
        System.out.println("""
            /////////////////////////////////
            // For all Unicode characters  //
            /////////////////////////////////
            """);
        
        int ucp1 = LETTER.codePointAt(0);
        String uhcp1 = Integer.toHexString(ucp1);
        String ubcp1 = Integer.toBinaryString(ucp1);
        System.out.println("LETTER, Decimal code point: " + ucp1);
        System.out.println("LETTER, Hexadecimal code point: " + uhcp1);
        System.out.println("LETTER, Binary encoding: " + ubcp1);

        System.out.println();

        int ucp2 = CHINESE.codePointAt(0);
        String uhcp2 = Integer.toHexString(ucp2);
        String ubcp2 = Integer.toBinaryString(ucp2);
        System.out.println("CHINESE, Decimal code point: " + ucp2);
        System.out.println("CHINESE, Hexadecimal code point: " + uhcp2);
        System.out.println("CHINESE, Binary encoding: " + ubcp2);

        System.out.println();

        int a1 = LETTER.charAt(0);
        int a2 = LETTER.codePointAt(0);
        System.out.println("'a1', code point via charAt():" + a1);
        System.out.println("'a2', code point codePointAt():" + a2);

        int b1 = CHINESE.charAt(0);
        int b2 = CHINESE.codePointAt(0);
        System.out.println("'b1', code point via charAt():" + b1);
        System.out.println("'b2', code point codePointAt():" + b2);

        int c1 = EMOJI.charAt(0);
        int c2 = EMOJI.codePointAt(0);
        System.out.println("'c1', code point via charAt():" + c1);
        System.out.println("'c2', code point codePointAt():" + c2);

        System.out.println();

        int ucp3 = EMOJI.codePointAt(0);
        String uhcp3 = Integer.toHexString(ucp3);
        String ubcp3 = Integer.toBinaryString(ucp3);
        System.out.println("Is EMOJI ?: " + Character.isEmoji(ucp3)); // JDK 21
        System.out.println("EMOJI, Decimal code point: " + ucp3);
        System.out.println("EMOJI, Hexadecimal code point: " + uhcp3);
        System.out.println("EMOJI, Binary encoding: " + ubcp3);

        System.out.println();

        String result5 = Charsets.codePointToBinary("Hello World");
        System.out.println("Binary 'Hello World':" + result5);

        String result6 = Charsets.codePointToBinary(LETTER);
        System.out.println("LETTER, Binary:" + result6);

        String result7 = Charsets.codePointToBinary(CHINESE);
        System.out.println("CHINESE, Binary:" + result7);

        String result8 = Charsets.codePointToBinary(EMOJI);
        System.out.println("EMOJI, Binary:" + result8);

        String result9 = Charsets.codePointToBinary(STR);
        System.out.println("Binary of a combined string:" + result9);

        System.out.println();

        String str1 = String.valueOf(Character.toChars(65));
        System.out.println("Get the string from code point 65: " + str1 + "  Length:" + str1.length());
        String str2 = String.valueOf(Character.toChars(128525));
        System.out.println("Get the string from code point 128525: " + str2 + "  Length:" + str2.length());

        int cp = Character.codePointOf("Smiling Face with Heart-Shaped Eyes");
        System.out.println("Code point of 'Smiling Face with Heart-Shaped Eyes': " + cp);

        int cpc = Character.codePointCount(EMOJI, 0, EMOJI.length());
        System.out.println("Code point count of 'Smiling Face with Heart-Shaped Eyes': " + cpc);
    }
}