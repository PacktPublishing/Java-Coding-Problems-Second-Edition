package modern.challenge;

import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static class SimpleThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            // return new Thread(r);                // platform thread
            return Thread.ofVirtual().unstarted(r); // virtual thread
        }
    }

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Runnable task = () -> logger.info(Thread.currentThread().toString());               
        
        // ThreadFactory tfVirtual = Thread.ofVirtual().factory();
        ThreadFactory tfVirtual = Thread.ofVirtual().name("vt-", 0).factory();
        // Thread.Builder builder = Thread.ofVirtual().name("vt-", 0);
        // ThreadFactory tfVirtual = builder.factory();        
        ThreadFactory tfPlatform = Thread.ofPlatform().name("pt-", 0).factory();
        SimpleThreadFactory stf = new SimpleThreadFactory();       
        
        tfVirtual.newThread(task).start();
        tfPlatform.newThread(task).start();
        stf.newThread(task).start();
    }
}