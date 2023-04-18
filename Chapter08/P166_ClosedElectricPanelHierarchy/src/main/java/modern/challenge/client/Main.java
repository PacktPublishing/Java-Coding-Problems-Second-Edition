package modern.challenge.client;

import modern.circuit.panel.ElectricPanel;

public class Main {    

    public static void main(String[] args) {
         
        ElectricPanel panel = new ElectricPanel();
        
        panel.switchOn();
        
        System.out.println("Power on ...");
    }
}
