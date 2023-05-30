package modern.challenge;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;
 
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final int NUMBER_OF_TASKS = 15;

    static class SimpleThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);                     // classic thread
            //return Thread.ofVirtual().unstarted(r); // virtual thread
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable taskr = () -> logger.info(Thread.currentThread().toString());

        Callable<Boolean> taskc = () -> {
            logger.info(Thread.currentThread().toString());
            return true;
        };

        System.out.println("\nRunnable:");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {

                executor.submit(taskr);
                // Future<?> future = executor.submit(taskr);
                
            }
        }

        System.out.println("\nCallable:");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {

                executor.submit(taskc);
                // Future<Boolean> future = executor.submit(taskc);
            }
        }

        System.out.println("\nRunnable:");

        try (ExecutorService executor = Executors.newThreadPerTaskExecutor(new SimpleThreadFactory())) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {

                executor.submit(taskr);
                // Future<?> future = executor.submit(taskr);
            }
        }

        System.out.println("\nCallable:");

        try (ExecutorService executor = Executors.newThreadPerTaskExecutor(new SimpleThreadFactory())) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {

                executor.submit(taskc);
                // Future<Boolean> future = executor.submit(taskc);
            }
        }
    }
}