package modern.challenge;

import java.nio.charset.Charset;

public class Charsets {

    private Charsets() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String stringToBinaryEncoding(String str, String encoding) {

        if (str == null) {
            throw new IllegalArgumentException("The given string cannot be null");
        }

        final Charset charset = Charset.forName(encoding);
        final byte[] strBytes = str.getBytes(charset);
        final StringBuilder strBinary = new StringBuilder();

        for (byte strByte : strBytes) {
           
            for (int i = 0; i < 8; i++) {

                strBinary.append((strByte & 128) == 0 ? 0 : 1);
                strByte <<= 1;
            }

            strBinary.append(" ");
        }
        return strBinary.toString().trim();

    }
}
