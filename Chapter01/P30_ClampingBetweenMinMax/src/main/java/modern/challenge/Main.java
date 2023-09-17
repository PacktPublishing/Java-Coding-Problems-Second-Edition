package modern.challenge;

public class Main {

    public static void main(String[] args) {

        int lowPressure = 7;
        int normalPressure = 23;
        int highPressure = 55;
        
        int adjustLowPressureV1 = PressureRegulator.adjustV1(lowPressure);
        int adjustHighPressureV1 = PressureRegulator.adjustV1(highPressure);
        int adjustNormalPressureV1 = PressureRegulator.adjustV1(normalPressure);
        
        System.out.println("Adjust low pressure(V1): " + adjustLowPressureV1);        
        System.out.println("Adjust high pressure (V1): " + adjustHighPressureV1);        
        System.out.println("Adjust normal pressure (V1): " + adjustNormalPressureV1);        
        
        int adjustLowPressureV2 = PressureRegulator.adjustV2(lowPressure);
        int adjustHighPressureV2 = PressureRegulator.adjustV2(highPressure);
        int adjustNormalPressureV2 = PressureRegulator.adjustV2(normalPressure);
        
        System.out.println("Adjust low pressure(V2): " + adjustLowPressureV2);        
        System.out.println("Adjust high pressure (V2): " + adjustHighPressureV2);        
        System.out.println("Adjust normal pressure (V2): " + adjustNormalPressureV2);                    
    }
}