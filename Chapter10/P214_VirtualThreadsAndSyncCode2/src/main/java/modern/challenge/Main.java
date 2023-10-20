package modern.challenge;

import java.time.Duration;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable taskp = () -> {
            logger.info(() -> Thread.currentThread().toString() + " sleeps for 5 seconds");
            try { Thread.sleep(Duration.ofSeconds(5)); } catch (InterruptedException ex) {}
            logger.info(() -> Thread.currentThread().toString() + " inserts in the queue");
            
            queue.add(Integer.MAX_VALUE);
        };
        
        Runnable taskv = () -> {
            logger.info(() -> Thread.currentThread().toString()
                + " can't take from the queue yet");
                
            try {
                int maxint = queue.take();
                logger.info(() -> Thread.currentThread().toString() + " took from queue: " + maxint);
            } catch (InterruptedException ex) {} 
        };

        logger.info("Before running the task ...");

        Thread pThread = Thread.ofPlatform().start(taskp);

        logger.info(pThread.toString());
        
        Thread vThread = Thread.ofVirtual().start(taskv);
        vThread.join();
        
        logger.info("After running the task ...");
    }
}