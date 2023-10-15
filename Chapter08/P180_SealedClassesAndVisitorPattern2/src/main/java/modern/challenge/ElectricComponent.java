package modern.challenge;
 
public sealed interface ElectricComponent
        permits Capacitor, Transistor, Resistor, ElectricCircuit {}
