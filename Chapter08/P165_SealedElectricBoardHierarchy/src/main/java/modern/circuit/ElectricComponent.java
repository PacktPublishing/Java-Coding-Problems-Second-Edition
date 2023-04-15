package modern.circuit;

import modern.circuit.type.ElectricCircuit;
import modern.circuit.capacitor.Capacitor;
import modern.circuit.diode.Diode;
import modern.circuit.inductor.Inductor;
import modern.circuit.resistor.Resistor;
import modern.circuit.transistor.Transistor;

public sealed interface ElectricComponent
        permits ElectricCircuit, Capacitor, Diode, Inductor, Resistor, Transistor {}
