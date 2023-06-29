package modern.challenge;

import java.util.logging.Logger;

public class SignaledObject {

    private static final Logger logger = Logger.getLogger(SignaledObject.class.getName());

    private int counter;

    public void callWait() throws InterruptedException {
        
        synchronized (this) {

            counter = counter - 1;

            if (counter >= 0) {
                logger.info(() -> Thread.currentThread() 
                        + " | Missed signals: " + counter + " | 'wait() will not be called'");
                return;
            }

            logger.info("Before calling wait()");
            logger.info(() -> Thread.currentThread() + " | " + Thread.currentThread().getState());
            wait();
            logger.info("After calling notify()");
            logger.info(() -> Thread.currentThread() + " | " + Thread.currentThread().getState());
        }
    }

    public void callNotify() {
        
        synchronized (this) {
            
            counter = counter + 1;
            
            logger.info(() -> "Signal counter: " + counter);

            notify();
        }
    }
}