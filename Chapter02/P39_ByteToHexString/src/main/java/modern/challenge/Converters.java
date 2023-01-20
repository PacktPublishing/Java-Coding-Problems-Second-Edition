package modern.challenge;

import java.math.BigInteger;
import java.util.HexFormat;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Converters {

    private Converters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String byteToHexStringV1(byte v) {

        int higher = (v >> 4) & 0xF;
        int lower = v & 0xF;

        String result = String.valueOf(
                new char[]{
                    Character.forDigit(higher, 16),
                    Character.forDigit(lower, 16)}
        );

        return result;
    }

    public static String byteToHexStringV2(byte v) {

        char[] hexArray = "0123456789abcdef".toCharArray();
        int hex = v & 0xFF;

        String result = String.valueOf(
                new char[]{
                    hexArray[hex >>> 4],
                    hexArray[hex & 0x0F]}
        );

        return result;
    }

    public static String byteToHexStringV3(byte v) {

        return Integer.toHexString(v & 0xFF);
    }

    // this is slow, better avoid
    public static String byteToHexStringV4(byte v) {

        return String.format("%02x ", v);
    }

    public static String byteToHexStringV5(byte v) {

        HexFormat hex = HexFormat.of();

        return hex.toHexDigits(v);
    }

    public static String byteArrToHexStringV1(byte[] varr) {

        if (varr == null || varr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        char[] hexArray = "0123456789abcdef".toCharArray();

        int l = varr.length;
        char[] cs = new char[l * 2];

        for (int i = 0; i < l; i++) {

            int hex = varr[i] & 0xFF;;
            int higher = hex >>> 4;
            int lower = hex & 0x0F;

            cs[i * 2 + 0] = hexArray[higher];
            cs[i * 2 + 1] = hexArray[lower];
        }
        return String.valueOf(cs);
    }

    public static String byteArrToHexStringV2(byte[] varr) {

        if (varr == null || varr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        return new BigInteger(1, varr).toString(16);
    }

    // this is slow, better avoid
    public static String byteArrToHexStringV3(byte[] varr) {

        if (varr == null || varr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        return IntStream.range(0, varr.length)
                .mapToObj(i -> String.format("%02x", varr[i]))
                .collect(Collectors.joining());
    }

    public static String byteArrToHexStringV4(byte[] varr) {

        if (varr == null || varr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        HexFormat hex = HexFormat.of();

        return hex.formatHex(varr);
    }

    public static byte hexToByteV1(String s) {

        if (s == null || s.length() != 2) {
            throw new IllegalArgumentException("The given string is not a valid hexadecimal number");
        }

        int d1 = Character.digit(s.charAt(0), 16);
        int d2 = Character.digit(s.charAt(1), 16);

        if (d1 == -1 || d2 == -1) {
            throw new IllegalArgumentException("The given string is not a valid hexadecimal number");
        }

        return (byte) ((d1 << 4) + d2);
    }

    public static byte hexToByteV2(String s) {

        if (s == null || s.length() != 2) {
            throw new IllegalArgumentException("The given string is not a valid hexadecimal number");
        }

        HexFormat hex = HexFormat.of();

        return hex.parseHex(s)[0];
    }

    public static byte[] hexStringToByteArrV1(String s) {

        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("The given string cannot be null or empty");
        }

        char[] sc = s.toCharArray();
        int l = sc.length / 2;
        byte[] b = new byte[l];

        for (int i = 0; i < l; i++) {

            int higher = Character.digit(sc[i * 2], 16);
            int lower = Character.digit(sc[i * 2 + 1], 16);
            int r = (higher << 4) | lower;

            if (r > 127) {
                r -= 256;
            }

            b[i] = (byte) r;
        }

        return b;
    }

    public static byte[] hexStringToByteArrV2(String s) {

        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("The given string cannot be null or empty");
        }

        HexFormat hex = HexFormat.of();

        return hex.parseHex(s);
    }

}
