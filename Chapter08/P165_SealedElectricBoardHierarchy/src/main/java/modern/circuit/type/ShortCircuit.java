package modern.circuit.type;

import modern.circuit.ElectricComponent;

public final class ShortCircuit extends ElectricCircuit {
    
    public ShortCircuit(ElectricComponent... comp) {}
    
    @Override
    public void off() {}

    @Override
    public void on() {}   
}