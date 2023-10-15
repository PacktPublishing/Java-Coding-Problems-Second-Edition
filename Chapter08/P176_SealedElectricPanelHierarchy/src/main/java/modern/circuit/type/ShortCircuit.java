package modern.circuit.type;

import modern.circuit.ElectricComponent;

public final class ShortCircuit extends ElectricCircuit {
    
    public ShortCircuit(ElectricComponent... comp) {}       

    @Override
    public void on() {}

    @Override
    public void off() {}
}