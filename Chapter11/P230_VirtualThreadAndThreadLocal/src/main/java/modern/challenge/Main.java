package modern.challenge;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final ThreadLocal<StringBuilder> threadLocal
            = ThreadLocal.<StringBuilder>withInitial(() -> {
                return new StringBuilder("Nothing here ...");
            });

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable task = () -> {           
             
            threadLocal.set(new StringBuilder(Thread.currentThread().toString()));
        
            logger.info(() -> " before sleep -> " + Thread.currentThread().toString()
                    + " [" + threadLocal.get() + "]");

            try {
                Thread.sleep(Duration.ofSeconds(new Random().nextInt(5)));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }                        
            
            logger.info(() -> " after sleep -> " + Thread.currentThread().toString()
                    + " [" + threadLocal.get() + "]");
            
            threadLocal.remove();
        };

        // Executors.newFixedThreadPool(10)
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 10; i++) {

                executor.submit(task);
            }
        }
    }
}
