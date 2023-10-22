package modern.challenge;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    private static final ScopedValue<String> SCOPED_VALUE = ScopedValue.newInstance();

    public static void main(String[] args) throws InterruptedException, Exception {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");        
        
        Runnable task = () -> {           
                         
            logger.info(() -> Thread.currentThread().toString() 
                    + " | before sleep | " + (SCOPED_VALUE.isBound() ? SCOPED_VALUE.get() : "Not bound"));

            try {
                Thread.sleep(Duration.ofSeconds(new Random().nextInt(5)));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }                        
            
            logger.info(() -> Thread.currentThread().toString() 
                    + " | after sleep | " + (SCOPED_VALUE.isBound() ? SCOPED_VALUE.get() : "Not bound"));
        };
        
        // Executors.newFixedThreadPool(10)
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 10; i++) {
                int copy_i = i;
                executor.submit(() -> ScopedValue.where(SCOPED_VALUE, "Kaboooom-" + copy_i).run(task));
            }
        }
    }  
}