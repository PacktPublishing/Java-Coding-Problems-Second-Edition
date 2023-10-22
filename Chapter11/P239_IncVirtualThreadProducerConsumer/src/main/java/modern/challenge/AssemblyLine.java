package modern.challenge;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("There is a single assembly line!");
    }

    private static final int MAX_NUMBER_OF_CONSUMERS = 50;
    private static final int MAX_QUEUE_SIZE_ALLOWED = 5;
    private static final int PRODUCERS = 3;
    private static final int CONSUMERS = 2;
    private static final int MAX_PROD_TIME_MS = 1 * 1000;
    private static final int MAX_CONS_TIME_MS = 10 * 1000;
    private static final int MONITOR_QUEUE_INITIAL_DELAY_MS = 5000;
    private static final int MONITOR_QUEUE_RATE_MS = 3000;
    private static final int EXTRA_TIME_MS = 4 * 1000;
    private static final int SLOW_DOWN_PRODUCER_MS = 150 * 1000;
    private static final int TIMEOUT_MS = MAX_PROD_TIME_MS + MAX_CONS_TIME_MS + 1000;

    private static int extraProdTime;

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final Random rnd = new Random();
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private final static Semaphore producerService = new Semaphore(PRODUCERS);
    private final static Semaphore consumerService = new Semaphore(CONSUMERS);

    private static ScheduledExecutorService monitorService;
    private static ScheduledExecutorService slowdownerService;

    private static final AtomicInteger nrOfConsumers = new AtomicInteger(CONSUMERS);
    private static final AtomicBoolean removeConsumer = new AtomicBoolean();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (runningProducer) {
                try {
                    String bulb = "bulb-" + rnd.nextInt(1000);

                    Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS) + extraProdTime);

                    queue.offer(bulb);

                    logger.info(() -> "Checked: " + bulb + " by producer: "
                            + Thread.currentThread().toString());
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    // logger.severe(() -> "Exception: " + ex);
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
                    String bulb = queue.poll(MAX_PROD_TIME_MS + extraProdTime, TimeUnit.MILLISECONDS);

                    if (bulb != null) {
                        Thread.currentThread().sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                        logger.info(() -> "Packed: " + bulb + " by consumer: "
                                + Thread.currentThread().toString());
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    // logger.severe(() -> "Exception: " + ex);
                    break;
                }

                if (removeConsumer.get()) {

                    nrOfConsumers.decrementAndGet();
                    removeConsumer.set(false);
                    Thread.currentThread().interrupt();
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
                } catch (InterruptedException ex) { /* handle exception */ }
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

        monitorQueueSize();
        slowdownProducer();
    }

    private static void monitorQueueSize() {
        monitorService = Executors.newSingleThreadScheduledExecutor();
        monitorService.scheduleAtFixedRate(() -> {

            if (queue.size() > MAX_QUEUE_SIZE_ALLOWED
                    && nrOfConsumers.get() < MAX_NUMBER_OF_CONSUMERS) {

                addNewConsumer();
            } else {
                if (nrOfConsumers.get() > CONSUMERS) {
                    removeConsumer();
                }
            }

            logger.warning(() -> "### Bulbs in queue: " + queue.size()
                    + " | Consumers waiting: " + consumerService.getQueueLength()
                    + " | Consumer available permits: " + consumerService.availablePermits()
                    + " | Running consumers: " + nrOfConsumers.get());
        },
                MONITOR_QUEUE_INITIAL_DELAY_MS, MONITOR_QUEUE_RATE_MS, TimeUnit.MILLISECONDS
        );
    }

    public static void stopAssemblyLine() {

        logger.info("Stopping assembly line ...");

        runningProducer = false;
        runningConsumer = false;

        shutdownSchedulers();
    }

    private static void addNewConsumer() {

        logger.warning("### Adding a new consumer ...");

        if (consumerService.availablePermits() == 0) {
            consumerService.release();
        }

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

        nrOfConsumers.incrementAndGet();
    }

    private static void removeConsumer() {

        logger.warning("### Removing a consumer ...");

        removeConsumer.set(true);        
    }

    private static void slowdownProducer() {
        slowdownerService = Executors.newSingleThreadScheduledExecutor();
        slowdownerService.schedule(() -> {
            logger.warning("### Slow down the producers ...");
            extraProdTime = EXTRA_TIME_MS;
        }, SLOW_DOWN_PRODUCER_MS, TimeUnit.MILLISECONDS);
    }

    private static boolean shutdownSchedulers() {
        if (!runningProducer || !runningConsumer) {
            return shutdownExecutor(monitorService) && shutdownExecutor(slowdownerService);
        }

        return false;
    }

    private static boolean shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_MS + extraProdTime, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();

                return executor.awaitTermination(TIMEOUT_MS + extraProdTime, TimeUnit.MILLISECONDS);
            }

            return true;
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        }
        return false;
    }
}