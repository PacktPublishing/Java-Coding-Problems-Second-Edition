package modern.circuit.inductor;

import modern.circuit.ElectricComponent;

public sealed abstract class Inductor implements ElectricComponent 
        permits AirInductor, FerriteInductor, IronInductor {}
