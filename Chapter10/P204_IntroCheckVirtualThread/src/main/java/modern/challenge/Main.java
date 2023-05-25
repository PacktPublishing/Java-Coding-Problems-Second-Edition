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
    }
}