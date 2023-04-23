package modern.challenge;

public class Main {
    
    public static void main(String[] args) {
    
        Capacitor c1 = new Capacitor(28, 20, 40);
        Capacitor c2 = new Capacitor(26, 22, 30);
        Resistor r1 = new Resistor(100, 2.5f, 5, 50, 0.25f);
        Transistor t1 = new Transistor(0.09f, 0.27f, 0.1f);
        
        Resistor r2 = new Resistor(98, 2.4f, 4, 40, 0.22f);
        Transistor t2 = new Transistor(0.07f, 0.25f, 0.2f);
        
        Capacitor c3 = new Capacitor(25, 21, 29);
        Resistor r3 = new Resistor(97, 2.3f, 5, 45, 0.20f);
        
        ElectricCircuit ec1 = new ElectricCircuit(1);
        ElectricCircuit ec2 = new ElectricCircuit(2);        
        ElectricCircuit ec3 = new ElectricCircuit(3);                
        ElectricCircuit ec4 = new ElectricCircuit(4);                
                
        ec1.add(c1, c2, r1, t1);
        ec2.add(r2, t2, ec1);
        ec3.add(c3, r3, ec2);
        ec4.add(ec3, c1, c2);
               
        export(ec4);
    }
    
    private static void export(ElectricComponent circuit) {
        XmlExportVisitor exportVisitor = new XmlExportVisitor();
        System.out.println(exportVisitor.export(circuit));
    }
}