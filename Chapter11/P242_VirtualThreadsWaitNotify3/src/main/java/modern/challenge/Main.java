package modern.challenge;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        SignaledObject object = new SignaledObject();

        Thread wThread = Thread.ofVirtual().unstarted(() -> {
            try {            
                object.callWait();
            } catch (InterruptedException ex) {}
        });
        
        Thread nThread = Thread.ofVirtual().unstarted(() -> {            
                object.callNotify();
        });                
        
        // good signal
        /*
        wThread.start();
        Thread.sleep(1000); // give time to 'wThread' to start
        logger.info("'wThread' current status");
        logger.info(() -> wThread + " | " + wThread.getState());
        
        nThread.start();        
        Thread.sleep(1000); // give time to 'nThread' to start
        
        logger.info("After executing 'wThread'");
        logger.info(() -> wThread + " | " + wThread.getState());
        */
        
        // missed signal        
        nThread.start();        
        Thread.sleep(1000); // give time to 'nThread' to start
        
        wThread.start();
        Thread.sleep(1000); // give time to 'wThread' to start
        logger.info("'wThread' current status");
        logger.info(() -> wThread + " | " + wThread.getState());               
        
        wThread.join();
    }
}