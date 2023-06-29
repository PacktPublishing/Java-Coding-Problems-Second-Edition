package modern.challenge;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Object object = new Object();

        Thread wThread = Thread.ofVirtual().unstarted(() -> {
            synchronized (object) {
                try {
                    logger.info("Before calling wait()");
                    logger.info(() -> Thread.currentThread() + " | " + Thread.currentThread().getState());
                    object.wait();
                    logger.info("After calling notify()");
                    logger.info(() -> Thread.currentThread() + " | " + Thread.currentThread().getState());
                } catch (InterruptedException e) {}
            }
        });
        
        Thread nThread = Thread.ofVirtual().unstarted(() -> {
            synchronized (object) {
                logger.info(() -> Thread.currentThread() + " calls notify()");
                object.notify();
            }
        });                
        
        nThread.start();        
        Thread.sleep(1000); // give time to 'nThread' to start
        
        wThread.start();
        Thread.sleep(1000); // give time to 'wThread' to start
        logger.info("'wThread' current status");
        logger.info(() -> wThread + " | " + wThread.getState());               
        
        wThread.join(); // waits indefinitely since notify() was missed
    }
}