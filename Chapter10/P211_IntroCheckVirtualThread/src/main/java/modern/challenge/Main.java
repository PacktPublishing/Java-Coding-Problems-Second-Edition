package modern.challenge;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable task = () -> logger.info(Thread.currentThread().toString());

        Thread vThread = Thread.ofVirtual().name("my_vThread").unstarted(task);
        Thread pThread1 = Thread.ofPlatform().name("my_pThread").unstarted(task);
        Thread pThread2 = new Thread(() -> {});

        logger.info(() -> "Is vThread virtual ? " + vThread.isVirtual());
        logger.info(() -> "Is pThread1 virtual ? " + pThread1.isVirtual());
        logger.info(() -> "Is pThread2 virtual ? " + pThread2.isVirtual());

        logger.info(() -> "Is daemon ? " + vThread.isDaemon());
        // vThread.setDaemon(false); //  java.lang.IllegalArgumentException: 'false' not legal for virtual threads        

        logger.info(() -> "Priority ? " + vThread.getPriority()); // NORM_PRIORITY = 5
        vThread.setPriority(4);
        logger.info(() -> "Priority (after setting it 4) ? " + vThread.getPriority()); // NORM_PRIORITY = 5
        
        logger.info(() -> "Thread group ? " + vThread.getThreadGroup().getName());
    }
}
