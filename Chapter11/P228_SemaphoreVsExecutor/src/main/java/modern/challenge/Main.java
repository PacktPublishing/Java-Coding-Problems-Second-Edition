package modern.challenge;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final int NUMBER_OF_TASKS = 15;
    private static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable task = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) { /* handle exception */ }
            logger.info(Thread.currentThread().toString());
        };

        // using cached platform threads
        try (ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {

                executor.submit(task);
            }
        }

        // using virtual threads and Semaphore
        Semaphore semaphore = new Semaphore(NUMBER_OF_THREADS);

        Thread vt = Thread.currentThread();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {

            vt = Thread.ofVirtual().start(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException ex) { /* handle exception */ }
                try {
                    task.run();
                } finally {
                    semaphore.release();
                }
            });
        }
        
        vt.join();
    }
}