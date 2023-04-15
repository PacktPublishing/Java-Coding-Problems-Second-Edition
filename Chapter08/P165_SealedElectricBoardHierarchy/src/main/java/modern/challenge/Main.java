package modern.challenge;

import modern.circuit.client.ElectricBoard;

public class Main {

    public static void main(String[] args) {
         
        ElectricBoard board = new ElectricBoard();
        
        board.on();
        
        System.out.println("Power on ...");               
    }
}
