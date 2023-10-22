package modern.challenge;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final int NUMBER_OF_TASKS = 25;    

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable task1 = () -> {
            synchronized (Main.class) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) { /* handle exception */ }
                logger.info(() -> "Task-1 | " + Thread.currentThread().toString());
            }
        };

        Lock lock = new ReentrantLock();
        Runnable task2 = () -> {
            lock.lock();
            try {
                Thread.sleep(1000);
                logger.info(() -> "Task-2 | " + Thread.currentThread().toString());
            } catch (InterruptedException ex) { /* handle exception */
            } finally {
                lock.unlock();
            }
        };

        // using virtual threads that are pinned
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {

                executor.submit(task1);
            }
        }

        // using virtual threads that are not pinned
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {

                executor.submit(task2);
            }
        }
    }
}