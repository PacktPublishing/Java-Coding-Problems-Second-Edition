package modern.challenge;

public class Main {

    public static void main(String[] args) {

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

    static class Printer {
        
        Printer() {
            System.out.println("Reset printer ...");
        }
        
        public static void printNoReset() {
            System.out.println("Printing (no reset) ..." + Printer.class.hashCode());
        }
        
        public void printReset() {
            System.out.println("Printing (with reset) ..." + Printer.class.hashCode());
        }
    }
}