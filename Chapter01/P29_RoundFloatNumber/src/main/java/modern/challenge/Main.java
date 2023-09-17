package modern.challenge;

public class Main {

    public static void main(String[] args) {

        float v = 14.9877655f;
        int d = 5;
        
        float resultV1 = Numbers.roundToDecimalsV1(v, d);
        float resultV2 = Numbers.roundToDecimalsV2(v, d);
        float resultV3 = Numbers.roundToDecimalsV3(v, d);
        float resultV4 = Numbers.roundToDecimalsV4(v, d);
        
        System.out.println(v + " / result (V1): " + resultV1);
        System.out.println(v + " / result (V2): " + resultV2);
        System.out.println(v + " / result (V3): " + resultV3);
        System.out.println(v + " / result (V4): " + resultV4);
    }
}