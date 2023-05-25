package modern.challenge;

import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable task = () -> logger.info(Thread.currentThread().toString());

        logger.info("Before running the task ...");

        // Thread.ofVirtual().start(task);
        // Thread.ofVirtual().name("my_vThread").start(task);        
        Thread vThread = Thread.startVirtualThread(task);

        logger.info("While running the task ...");

        vThread.join();

        logger.info("After running the task ...");

        Thread pThread = new Thread(() -> {});

        logger.info(() -> "Is vThread virtual ? " + vThread.isVirtual());
        logger.info(() -> "Is vThread platform ? " + pThread.isVirtual());
        
        // creating a ThreadFactory of virtual threads
        
        // ThreadFactory tf = Thread.ofVirtual().factory();
         ThreadFactory tf = Thread.ofVirtual().name("cool-", 0).factory();
         Thread tfvThread = tf.newThread(task);
         tfvThread.start();         
         tfvThread.join();
    }
}