package modern.circuit;

import modern.circuit.type.ElectricCircuit;
import modern.circuit.panel.ElectricBreaker;
import modern.circuit.capacitor.Capacitor;
import modern.circuit.resistor.Resistor;
import modern.circuit.transistor.Transistor;

public sealed interface ElectricComponent 
        permits ElectricCircuit, ElectricBreaker, Capacitor, Resistor, Transistor {}