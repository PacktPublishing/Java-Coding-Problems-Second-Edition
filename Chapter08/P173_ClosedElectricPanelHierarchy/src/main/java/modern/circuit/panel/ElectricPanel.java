package modern.circuit.panel;

import modern.circuit.type.ElectricCircuit;
import modern.circuit.capacitor.CeramicCapacitor;
import modern.circuit.capacitor.ElectrolyticCapacitor;
import modern.circuit.resistor.CarbonResistor;
import modern.circuit.resistor.MetalFilmResistor;
import modern.circuit.resistor.MetalOxideResistor;
import modern.circuit.resistor.MetalResistor;
import modern.circuit.transistor.BipolarTransistor;
import modern.circuit.transistor.FieldEffectTransistor;
import modern.circuit.type.ParallelCircuit;
import modern.circuit.type.SeriesCircuit;
import modern.circuit.type.ShortCircuit;

public final class ElectricPanel implements ElectricBreaker {

    private final ElectricCircuit centralCircuit;
    private final ElectricCircuit peripheralCircuit;
    private final ElectricCircuit auxiliaryCircuit;        

    public ElectricPanel() {

        peripheralCircuit = new SeriesCircuit(
                new ElectrolyticCapacitor(), new ElectrolyticCapacitor(), 
                new MetalFilmResistor(), new CarbonResistor()
        );

        auxiliaryCircuit = new ShortCircuit(
                new CeramicCapacitor(), new ElectrolyticCapacitor(), new MetalResistor(),
                new FieldEffectTransistor(), new FieldEffectTransistor()
        );

        centralCircuit = new ParallelCircuit(peripheralCircuit, auxiliaryCircuit,
                new CeramicCapacitor(), new BipolarTransistor(), new MetalOxideResistor()              
        );        
    }
       
    @Override
    public void switchOn() {
 
        auxiliaryCircuit.off();
        peripheralCircuit.on();
        centralCircuit.on();        
    }

    @Override
    public void switchOff() {
        
        auxiliaryCircuit.on();
        peripheralCircuit.off();
        centralCircuit.off();        
    }
}