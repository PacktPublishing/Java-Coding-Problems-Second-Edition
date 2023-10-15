package modern.circuit.resistor;

public sealed class MetalResistor extends Resistor 
        permits MetalFilmResistor, MetalOxideResistor {}
