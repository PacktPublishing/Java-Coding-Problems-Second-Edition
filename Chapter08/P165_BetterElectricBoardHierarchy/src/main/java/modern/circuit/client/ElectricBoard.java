package modern.circuit.client;

import modern.circuit.type.ElectricCircuit;
import modern.circuit.capacitor.CeramicCapacitor;
import modern.circuit.capacitor.ElectrolyticCapacitor;
import modern.circuit.diode.AvalancheDiode;
import modern.circuit.diode.LaserDiode;
import modern.circuit.inductor.AirInductor;
import modern.circuit.inductor.FerriteInductor;
import modern.circuit.inductor.IronInductor;
import modern.circuit.resistor.MetalFilmResistor;
import modern.circuit.resistor.MetalOxideResistor;
import modern.circuit.transistor.BipolarTransistor;
import modern.circuit.transistor.FieldEffectTransistor;
import modern.circuit.type.ParallelCircuit;
import modern.circuit.type.SeriesCircuit;
import modern.circuit.type.ShortCircuit;

public class ElectricBoard {

    private final ElectricCircuit centralCircuit;
    private final ElectricCircuit peripheralCircuit;
    private final ElectricCircuit auxiliaryCircuit;

    public ElectricBoard() {

        centralCircuit = new ParallelCircuit(
                new CeramicCapacitor(), new LaserDiode(), new LaserDiode(),
                new FerriteInductor(), new BipolarTransistor(), new MetalOxideResistor()
        );

        peripheralCircuit = new SeriesCircuit(
                new ElectrolyticCapacitor(), new ElectrolyticCapacitor(),
                new AvalancheDiode(), new AirInductor(), new MetalFilmResistor()
        );

        auxiliaryCircuit = new ShortCircuit(
                new CeramicCapacitor(), new ElectrolyticCapacitor(), new IronInductor(),
                new FieldEffectTransistor(), new FieldEffectTransistor()
        );
    }

    public void on() {

        peripheralCircuit.on();
        centralCircuit.on();
        auxiliaryCircuit.on();
    }

    public void off() {
        centralCircuit.off();
        peripheralCircuit.off();
        auxiliaryCircuit.off();
    }
}