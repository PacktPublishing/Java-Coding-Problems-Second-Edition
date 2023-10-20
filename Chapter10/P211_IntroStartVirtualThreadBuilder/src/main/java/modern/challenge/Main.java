package modern.challenge;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable task = () -> logger.info(Thread.currentThread().toString());

        logger.info("Before running the task ...");

        Thread.Builder builder
                = Thread.ofVirtual().name("vThread-", 1);

        // name "vThread-1"
        Thread vThread1 = builder.start(task);
        vThread1.join();
        logger.info(() -> vThread1.getName() + " terminated");

        // name "vThread-2"
        Thread vThread2 = builder.start(task);
        vThread2.join();
        logger.info(() -> vThread2.getName() + " terminated");

        logger.info("After running the task ...");
    }
}