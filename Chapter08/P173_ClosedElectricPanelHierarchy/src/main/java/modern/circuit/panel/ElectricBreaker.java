package modern.circuit.panel;

import modern.circuit.ElectricComponent;

interface ElectricBreaker extends ElectricComponent {

    void switchOn();
    void switchOff();
}
