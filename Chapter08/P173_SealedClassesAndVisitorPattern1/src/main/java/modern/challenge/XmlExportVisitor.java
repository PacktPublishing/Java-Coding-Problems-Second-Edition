package modern.challenge;

public class XmlExportVisitor implements ElectricComponentVisitor {

    public String export(ElectricComponent... args) {

        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");

        for (ElectricComponent ec : args) {
            sb.append(ec.accept(this)).append("\n");
        }

        return sb.toString();
    }

    @Override
    public String visit(Capacitor capacitor) {
        return """
         <capacitor>
            <maxImpedance>%s</maxImpedance>
            <dielectricResistance>%s</dielectricResistance>
            <coreTemperature>%s</coreTemperature>   
         </capacitor>
      """.formatted(capacitor.getMaxImpedance(), capacitor.getDielectricResistance(), capacitor.getCoreTemperature());
    }

    @Override
    public String visit(Transistor transistor) {
        return """
         <transistor>
            <length>%s</length>
            <width>%s</width>
            <threshholdVoltage>%s</threshholdVoltage>   
         </transistor>
      """.formatted(transistor.getLength(), transistor.getWidth(), transistor.getThreshholdVoltage());
    }

    @Override
    public String visit(Resistor resistor) {
        return """
         <resistor>
            <resistance>%s</resistance>
            <clazz>%s</clazz>
            <voltage>%s</voltage>
            <current>%s</current>
            <power>%s</power>      
         </resistor>      
      """.formatted(resistor.getResistance(), resistor.getClazz(), 
                       resistor.getVoltage(), resistor.getCurrent(), resistor.getPower());
    }
    
    @Override
    public String visit(ElectricCircuit ec) {
        return """
         <electric_circuit_%s>            
         %s\
         </electric_circuit_%s>
         """.formatted(ec.getId(), subcircuit(ec), ec.getId()).indent(3);
    }

    private String subcircuit(ElectricCircuit ec) {
        
        StringBuilder sb = new StringBuilder();
        
        for (ElectricComponent comp : ec.getComps()) {
            String xml = comp.accept(this);
            
            sb.append(xml);
        }
        
        return sb.toString();
    }
}