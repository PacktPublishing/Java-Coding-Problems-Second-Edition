package modern.challenge;

public interface ElectricComponentVisitor {
    
    String visit(Capacitor capacitor);
    String visit(Transistor transistor);
    String visit(Resistor resistor);
    String visit(ElectricCircuit circuit);
}