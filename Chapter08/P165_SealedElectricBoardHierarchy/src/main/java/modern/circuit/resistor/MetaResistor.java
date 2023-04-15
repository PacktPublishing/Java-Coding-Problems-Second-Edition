package modern.circuit.resistor;

public sealed abstract class MetaResistor extends Resistor 
        permits MetalFilmResistor, MetalOxideResistor {}
