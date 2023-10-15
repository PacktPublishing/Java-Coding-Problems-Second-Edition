package modern.circuit.panel;

import modern.circuit.ElectricComponent;

public interface ElectricBreaker extends ElectricComponent {

    void switchOn();
    void switchOff();
}
