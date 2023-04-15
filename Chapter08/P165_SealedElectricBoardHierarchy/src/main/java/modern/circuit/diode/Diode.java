package modern.circuit.diode;

import modern.circuit.ElectricComponent;

public sealed abstract class Diode implements ElectricComponent 
        permits AvalancheDiode, LaserDiode {}
