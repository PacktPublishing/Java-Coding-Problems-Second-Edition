package modern.challenge;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("There is a single assembly line!");
    }

    private static final int PRODUCERS = 3;
    private static final int CONSUMERS = 2;
    private static final int MAX_PROD_TIME_MS = 2 * 1000;
    private static final int MAX_CONS_TIME_MS = 2 * 1000;
    
    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final Random rnd = new Random();
    private static final Queue<String> queue = new ConcurrentLinkedQueue<>();

    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private final static Semaphore producerService = new Semaphore(PRODUCERS);
    private final static Semaphore consumerService = new Semaphore(CONSUMERS);

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (runningProducer) {
                try {
                    String bulb = "bulb-" + rnd.nextInt(1000);

                    Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));

                    queue.offer(bulb);

                    logger.info(() -> "Checked: " + bulb + " by producer: "
                            + Thread.currentThread().toString());
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception: " + ex);
                    break;
                }
            }
        }

    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (runningConsumer) {
                try {
                    String bulb = queue.poll();

                    if (bulb != null) {
                        Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                        logger.info(() -> "Packed: " + bulb + " by consumer: "
                                + Thread.currentThread().toString());
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception: " + ex);
                    break;
                }
            }
        }

    }

    public static void startAssemblyLine() throws InterruptedException {

        if (runningProducer || runningConsumer) {
            logger.info("Assembly line is already running ...");
            return;
        }

        logger.info("\n\nStarting assembly line ...");
        logger.info(() -> "Remaining bulbs from previous run: \n" + queue + "\n\n");

        runningProducer = true;                
        for (int i = 0; i < PRODUCERS; i++) {

            Thread.ofVirtual().start(() -> {
                try {
                    producerService.acquire();
                } catch (InterruptedException ex) {  /* handle exception */ }
                try {
                    producer.run();
                } finally {
                    producerService.release();
                }
            });
        }

        runningConsumer = true;                
        for (int i = 0; i < CONSUMERS; i++) {

            Thread.ofVirtual().start(() -> {
                try {
                    consumerService.acquire();
                } catch (InterruptedException ex) { /* handle exception */ }
                try {
                    consumer.run();
                } finally {
                    consumerService.release();
                }
            });
        }
    }
    
    public static void stopAssemblyLine() {

        logger.info("Stopping assembly line ...");

        runningProducer = false;
        runningConsumer = false;        
    }
}