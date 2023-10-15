package modern.challenge;

public class Print {
    
    public void start() {
            
        // Runnable p1 = Printer::printNoReset;
        // Runnable p2 = () -> Printer.printNoReset();
        
        Runnable p1 = new Printer()::printReset;
        Runnable p2 = () -> new Printer().printReset();
                
        System.out.print("p1:");p1.run();
        System.out.print("p1:");p1.run();
        System.out.print("p2:");p2.run();
        System.out.print("p2:");p2.run();
        System.out.print("p1:");p1.run();
        System.out.print("p2:");p2.run();
        }
}