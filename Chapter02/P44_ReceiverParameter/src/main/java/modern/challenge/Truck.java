package modern.challenge;

public class Truck {
    
    public void revision1(Truck this) {
        Truck thisTruck = this;
        
        System.out.println("Truck: " + thisTruck);
    }
    
    public void revision2() {
        Truck thisTruck = this;
        
        System.out.println("Truck: " + thisTruck);
    }
}
