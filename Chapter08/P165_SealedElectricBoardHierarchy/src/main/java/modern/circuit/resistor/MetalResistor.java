package modern.circuit.resistor;

public sealed abstract class MetalResistor extends Resistor 
        permits MetalFilmResistor, MetalOxideResistor {}
