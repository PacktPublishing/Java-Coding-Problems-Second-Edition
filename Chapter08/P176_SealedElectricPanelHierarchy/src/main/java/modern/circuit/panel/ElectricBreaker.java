package modern.circuit.panel;

import modern.circuit.ElectricComponent;

public sealed interface ElectricBreaker extends ElectricComponent
        permits ElectricPanel {

    void switchOn();
    void switchOff();
}
