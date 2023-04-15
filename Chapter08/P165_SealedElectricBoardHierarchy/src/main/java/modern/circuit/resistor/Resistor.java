package modern.circuit.resistor;

import modern.circuit.ElectricComponent;

public sealed abstract class Resistor implements ElectricComponent 
        permits CarbonResistor, MetalResistor {}   





