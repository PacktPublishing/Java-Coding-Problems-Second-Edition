package modern.challenge;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("""
            ////////////////////////////////////////////////////////////////////////
            // For Unicode characters having code point less than 65,535 (0xFFFF) //
            ////////////////////////////////////////////////////////////////////////
            """);

        int cp1 = "A".charAt(0);
        String hcp1 = Integer.toHexString(cp1);
        String bcp1 = Integer.toBinaryString(cp1);
        System.out.println("Decimal code point of 'A': " + cp1);
        System.out.println("Hexadecimal code point of 'A': " + hcp1);
        System.out.println("Binary encoding of 'A': " + bcp1);

        System.out.println();

        int cp2 = "暗".charAt(0);
        String hcp2 = Integer.toHexString(cp2);
        String bcp2 = Integer.toBinaryString(cp2);
        System.out.println("Decimal code point of '暗': " + cp2);
        System.out.println("Hexadecimal code point of '暗': " + hcp2);
        System.out.println("Binary encoding of '暗': " + bcp2);

        System.out.println();

        // this return a wrong result because the code point of 😍 is 128525 > 65535
        int cp3 = "😍".charAt(0);
        String hcp3 = Integer.toHexString(cp3);
        String bcp3 = Integer.toBinaryString(cp3);
        System.out.println("Wrong decimal code point of '😍': " + cp3);
        System.out.println("Wrong hexadecimal code point of '😍': " + hcp3);
        System.out.println("Wrong binary encoding of '😍': " + bcp3);

        System.out.println();

        String result1 = Charsets.strToBinary("Hello World");
        System.out.println("Binary 'Hello World':" + result1);

        String result2 = Charsets.strToBinary("A");
        System.out.println("Binary 'A':" + result2);

        String result3 = Charsets.strToBinary("暗");
        System.out.println("Binary '暗':" + result3);

        // this return a wrong result because the code point of 😍 is 128525 > 65535
        String result4 = Charsets.strToBinary("😍");
        System.out.println("Binary '😍':" + result4);
        
        System.out.println();
        System.out.println("""
            /////////////////////////////////
            // For all Unicode characters  //
            /////////////////////////////////
            """);
        
        int ucp1 = "A".codePointAt(0);
        String uhcp1 = Integer.toHexString(ucp1);
        String ubcp1 = Integer.toBinaryString(ucp1);
        System.out.println("Decimal code point of 'A': " + ucp1);
        System.out.println("Hexadecimal code point of 'A': " + uhcp1);
        System.out.println("Binary encoding of 'A': " + ubcp1);

        System.out.println();

        int ucp2 = "暗".codePointAt(0);
        String uhcp2 = Integer.toHexString(ucp2);
        String ubcp2 = Integer.toBinaryString(ucp2);
        System.out.println("Decimal code point of '暗': " + ucp2);
        System.out.println("Hexadecimal code point of '暗': " + uhcp2);
        System.out.println("Binary encoding of '暗': " + ubcp2);

        System.out.println();

        int a1 = "A".charAt(0);
        int a2 = "A".codePointAt(0);
        System.out.println("'a1', code point via charAt():" + a1);
        System.out.println("'a2', code point codePointAt():" + a2);

        int b1 = "暗".charAt(0);
        int b2 = "暗".codePointAt(0);
        System.out.println("'b1', code point via charAt():" + b1);
        System.out.println("'b2', code point codePointAt():" + b2);

        int c1 = "😍".charAt(0);
        int c2 = "😍".codePointAt(0);
        System.out.println("'c1', code point via charAt():" + c1);
        System.out.println("'c2', code point codePointAt():" + c2);

        System.out.println();

        int ucp3 = "😍".codePointAt(0);
        String uhcp3 = Integer.toHexString(ucp3);
        String ubcp3 = Integer.toBinaryString(ucp3);
        System.out.println("Wrong decimal code point of '😍': " + ucp3);
        System.out.println("Wrong hexadecimal code point of '😍': " + uhcp3);
        System.out.println("Binary encoding of '😍': " + ubcp3);

        System.out.println();

        String result5 = Charsets.codePointToBinary("Hello World");
        System.out.println("Binary 'Hello World':" + result5);

        String result6 = Charsets.codePointToBinary("A");
        System.out.println("Binary 'A':" + result6);

        String result7 = Charsets.codePointToBinary("暗");
        System.out.println("Binary '暗':" + result7);

        String result8 = Charsets.codePointToBinary("😍");
        System.out.println("Binary '😍':" + result8);

        String result9 = Charsets.codePointToBinary("😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!");
        System.out.println("Binary of a combined string:" + result9);

        System.out.println();

        String str1 = String.valueOf(Character.toChars(65));
        System.out.println("Get the string from code point 65: " + str1 + "  Length:" + str1.length());
        String str2 = String.valueOf(Character.toChars(128525));
        System.out.println("Get the string from code point 128525: " + str2 + "  Length:" + str2.length());

        int cp = Character.codePointOf("Smiling Face with Heart-Shaped Eyes");
        System.out.println("Code point of 'Smiling Face with Heart-Shaped Eyes': " + cp);

        int cpc = Character.codePointCount("😍", 0, "😍".length());
        System.out.println("Code point count of 'Smiling Face with Heart-Shaped Eyes': " + cpc);
    }
}