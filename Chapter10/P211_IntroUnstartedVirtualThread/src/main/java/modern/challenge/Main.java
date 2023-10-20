package modern.challenge;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable task = () -> logger.info(Thread.currentThread().toString());

        logger.info("Before running the task ...");

        Thread vThread = Thread.ofVirtual().unstarted(task);
        
        // Thread.Builder builder = Thread.ofVirtual();
        // Thread vThread = builder.unstarted(task);

        logger.info(() -> "Virtual thread is created but not started ... " + vThread.isAlive());

        vThread.start();

        logger.info(() -> "While running the task (virtual thread started) ... " + vThread.isAlive());

        vThread.join();

        logger.info("After running the task ...");

        // this is an unstarted platform thread
        Thread pThread = Thread.ofPlatform().unstarted(task);
        logger.info("");
        logger.info(() -> "Platform thread is created but not started ... " + pThread.isAlive());                
    }
}