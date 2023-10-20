package modern.challenge;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final int NUMBER_OF_TASKS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");                                
       
        Runnable taskr = () -> logger.info(Thread.currentThread().toString());        
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < NUMBER_OF_TASKS + 1; i++) {

                executor.submit(taskr);
            }
        }
    }
}
