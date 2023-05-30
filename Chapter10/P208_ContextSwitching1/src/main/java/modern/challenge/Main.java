package modern.challenge;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final int MAX_THREADS = 10;

    static class SimpleThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            // return new Thread(r);                     // classic thread
            return Thread.ofVirtual().unstarted(r);      // virtual thread
        }
    }

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        try (ExecutorService executor = Executors.newThreadPerTaskExecutor(new SimpleThreadFactory())) {

            for (int i = 0; i < MAX_THREADS; i++) {
                int index = i;
                executor.submit(() -> doSomething(index));
            }
        }
    }

    public static void doSomething(int index) {

        logger.info(() -> index + " " + Thread.currentThread().toString());
        try { Thread.sleep(Duration.ofSeconds(3)); } catch (InterruptedException ex) {}
        logger.info(() -> index + " " + Thread.currentThread().toString());
    }
}