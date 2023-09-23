package modern.challenge;

public class Main {

    public static void main(String[] args) {

        printerTest();
    }

    public static void printerTest() {

        // before JDK 16                
        /*
        Printer printer = new Printer() {

            @Override
            public void print(String quality) {

                if ("best".equals(quality)) {

                    Tools tools = new Tools();

                    tools.enableLaserGuidance();
                    tools.setHighResolution();
                }

                System.out.println("Printing photo-test ...");
            }

            class Tools {

                private void enableLaserGuidance() {
                    System.out.println("Adding laser guidance ...");
                }

                private void setHighResolution() {
                    System.out.println("Set high resolution ...");
                }
            }
        };    
        */
        
        // before JDK 16 
        /*
        Printer printer = new Printer() {

            @Override
            public void print(String quality) {

                class Tools {

                    private void enableLaserGuidance() {
                        System.out.println("Adding laser guidance ...");
                    }

                    private void setHighResolution() {
                        System.out.println("Set high resolution ...");
                    }
                }

                if ("best".equals(quality)) {

                    Tools tools = new Tools();

                    tools.enableLaserGuidance();
                    tools.setHighResolution();
                }

                System.out.println("Printing photo-test ...");
            }            
        };
        */
        
        // JDK 16+        
        /*
        Printer printer = new Printer() {

            @Override
            public void print(String quality) {

                if ("best".equals(quality)) {
                    enableLaserGuidance();
                    setHighResolution();
                }

                System.out.println("Printing photo-test ...");
            }

            private static void enableLaserGuidance() {
                System.out.println("Adding laser guidance ...");
            }

            private static void setHighResolution() {
                System.out.println("Set high resolution ...");
            }
        };
        */           
        
        Printer printer = new Printer() {

            @Override
            public void print(String quality) {

                if ("best".equals(quality)) {
                    Tools.enableLaserGuidance();
                    Tools.setHighResolution();
                }

                System.out.println("Printing photo-test ...");
            }

            private final static class Tools {

                private static void enableLaserGuidance() {
                    System.out.println("Adding laser guidance ...");
                }

                private static void setHighResolution() {
                    System.out.println("Set high resolution ...");
                }
            }
        };
         
        printer.print("ok");
        System.out.println();
        printer.print("best");
    }
}
