package modern.circuit.type;

import modern.circuit.ElectricComponent;

public sealed abstract class ElectricCircuit implements ElectricComponent
        permits ParallelCircuit, SeriesCircuit, ShortCircuit {
   
    public abstract void on();
    public abstract void off();
}
