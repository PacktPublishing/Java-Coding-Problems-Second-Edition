package modern.circuit.type;

import modern.circuit.ElectricComponent;

public abstract class ElectricCircuit implements ElectricComponent {
    
    ElectricCircuit() {} 
    
    public abstract void on();
    public abstract void off();
}