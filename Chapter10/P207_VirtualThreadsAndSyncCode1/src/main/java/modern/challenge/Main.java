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

        Runnable task = () -> {
            logger.info(() -> Thread.currentThread().toString() + " sleeps for 5 seconds");
            try { Thread.sleep(Duration.ofSeconds(5)); } catch (InterruptedException ex) {}
            logger.info(() -> Thread.currentThread().toString() + " inserts in the queue");
            
            queue.offer(Integer.MAX_VALUE);
        };

        logger.info("Before running the task ...");

        // Thread.startVirtualThread(task);
        Thread vThread = Thread.ofVirtual().start(task);     

        logger.info(vThread.toString());

        logger.info(() -> Thread.currentThread().toString()
                + " can't take from the queue yet");
        
        int maxint = queue.take();                        
                
        logger.info(() -> Thread.currentThread().toString() + "took from queue: " + maxint);                
        
        logger.info(vThread.toString());

        logger.info("After running the task ...");
    }
}
