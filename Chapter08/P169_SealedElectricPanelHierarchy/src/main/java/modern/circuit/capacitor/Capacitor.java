package modern.circuit.capacitor;

import modern.circuit.ElectricComponent;

public sealed abstract class Capacitor implements ElectricComponent
        permits CeramicCapacitor, ElectrolyticCapacitor {}
