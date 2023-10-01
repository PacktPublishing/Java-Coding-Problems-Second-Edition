package modern.challenge;

public class Main {

    public static void main(String[] args) {

        Car<? extends EngineType> car1 = new Car(new DSLEngine());
        Car<? extends EngineType> car2 = new Car(new ESSEngine());
        Car<? extends EngineType> car3 = new Car(new LPGEngine());
        
        System.out.println(addCarburetor1(car1));
        System.out.println(addCarburetor1(car2));
        System.out.println(addCarburetor1(car3));
        
        System.out.println(addCarburetor2(car1, 1));
        System.out.println(addCarburetor2(car2, 2));
        System.out.println(addCarburetor2(car3, 1));
    }
    
    public static String addCarburetor1(Car c) {
        
        return switch(c) {
            // case Car(DSLEngine dsl), Car(ESSEngine ess) -> "Adding a carburetor to a ESS or DSL car";
            case Car(DSLEngine _), Car(ESSEngine _) -> "Adding a carburetor to a ESS or DSL car";
            case Car(LPGEngine lpg) -> "Adding a carburetor to a LPG car";
        };
    }
    
    public static String addCarburetor2(Car c, int carburetorType) {                
        
        return switch(c) {            
            case Car(DSLEngine _), Car(ESSEngine _) when carburetorType == 1
                -> "Adding a carburetor of type 1 to a ESS or DSL car";
            case Car(DSLEngine _), Car(ESSEngine _) 
                -> "Adding a carburetor of tpye " + carburetorType + " to a ESS or DSL car";
            case Car(LPGEngine lpg) -> "Adding a carburetor " + carburetorType + " to a LPG car";
        };
    }
}