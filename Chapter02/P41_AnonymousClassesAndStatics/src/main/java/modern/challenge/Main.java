package modern.challenge;

public class Main {

    public static void main(String[] args) {

        // before JDK 16
        /*
        Printer printer = new Printer() {

            @Override
            public void print(String quality) {

                if ("excellent".equals(quality)) {

                    Tools tools = new Tools();

                    tools.enableLaserGuidance();
                    tools.setHighResolution();
                }

                System.out.println("Printing your photos ...");
            }

            private final class Tools {

                private void enableLaserGuidance() {
                    System.out.println("Adding laser guidance ...");
                }

                private void setHighResolution() {
                    System.out.println("Set high resolution ...");
                }
            }
        };
        */
        
        // JDK 16+
        /*
        Printer printer = new Printer() {

            @Override
            public void print(String quality) {

                if ("excellent".equals(quality)) {
                    enableLaserGuidance();
                    setHighResolution();
                }

                System.out.println("Printing your photos ...");
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

                if ("excellent".equals(quality)) {
                    Tools.enableLaserGuidance();                  
                    Tools.setHighResolution();
                }

                System.out.println("Printing your photos ...");
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

        printer.print("excellent");
    }
}
