package modern.circuit.transistor;

import modern.circuit.ElectricComponent;

public sealed abstract class Transistor implements ElectricComponent 
        permits FieldEffectTransistor, BipolarTransistor {} 
