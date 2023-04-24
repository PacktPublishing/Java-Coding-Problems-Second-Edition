package modern.challenge;

import com.refinery.fuel.Coke;
import com.refinery.fuel.Fuel;
import com.refinery.fuel.Methane;
import com.refinery.fuel.SolidFuel;
import modern.reflection.Inspector;

public class Main {    

    public static void main(String[] args) {
        
        Coke coke = new Coke();
        Methane methane = new Methane();
                
        System.out.println("Fuel subclasses: " + Inspector.permittedClasses(Fuel.class));
        System.out.println("SolidFuel subclasses: " + Inspector.permittedClasses(SolidFuel.class));
        System.out.println("Coke subclasses: " + Inspector.permittedClasses(coke.getClass()));
        System.out.println("Methane subclasses: " + Inspector.permittedClasses(methane.getClass()));        
    }
}