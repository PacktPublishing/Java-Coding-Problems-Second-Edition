package modern.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final List<String> strings = new ArrayList<>();

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        logger.info("Application started ...");
        String string = "prefixedString_";

        // Add in heap 5 millions String instances
        for (int i = 0; i < 5_000_000; i++) {
            String newString = string + i;
            strings.add(newString);
        }
        
        logger.info(() -> "List size: " + strings.size());

        // Force GC execution
        System.gc();

        // Remove 10_000 out of 5 millions
        for (int i = 0; i < 10_000; i++) {
            String newString = string + i;
            strings.remove(newString);            
        }

        logger.info(() -> "List size: " + strings.size());
        logger.info("Application done ...");
    }
}