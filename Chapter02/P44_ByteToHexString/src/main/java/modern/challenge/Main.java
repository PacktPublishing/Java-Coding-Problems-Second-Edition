package modern.challenge;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        byte v = -125;
        byte[] varr = new byte[]{-3, 0, 12, 11, -5, 123};
        String s = "fd000c0bfb7b";

        System.out.println("Convert byte value to hexadecimal string:");
        System.out.println("byteToHexStringV1:" + Converters.byteToHexStringV1(v));
        System.out.println("byteToHexStringV2:" + Converters.byteToHexStringV2(v));
        System.out.println("byteToHexStringV3:" + Converters.byteToHexStringV3(v));
        System.out.println("byteToHexStringV4:" + Converters.byteToHexStringV4(v));
        System.out.println("byteToHexStringV5:" + Converters.byteToHexStringV5(v));

        System.out.println();
        System.out.println("Convert byte array to hexadecimal string:");
        System.out.println("byteArrToHexStringV1:" + Converters.byteArrToHexStringV1(varr));
        System.out.println("byteArrToHexStringV2:" + Converters.byteArrToHexStringV2(varr));
        System.out.println("byteArrToHexStringV3:" + Converters.byteArrToHexStringV3(varr));
        System.out.println("byteArrToHexStringV4:" + Converters.byteArrToHexStringV4(varr));

        System.out.println();
        System.out.println("Convert hexadecimal string to byte value:");
        System.out.println("hexToByteV1:" + Converters.hexToByteV1("09"));
        System.out.println("hexToByteV2:" + Converters.hexToByteV2("09"));

        System.out.println();
        System.out.println("Convert hexadecimal string to byte array:");
        System.out.println("hexStringToByteArrV1: " 
                + Arrays.toString(Converters.hexStringToByteArrV1(s)));
        System.out.println("hexStringToByteArrV1: " 
                + Arrays.toString(Converters.hexStringToByteArrV2(s)));
    }
}