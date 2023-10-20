package modern.challenge;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        System.setProperty("jdk.virtualThreadScheduler.maxPoolSize", "1");
        System.setProperty("jdk.virtualThreadScheduler.maxPoolSize", "1");
        System.setProperty("jdk.virtualThreadScheduler.maxPoolSize", "1");

        Runnable slowTask = () -> {
            logger.info(() -> Thread.currentThread().toString() + " | working on something");            
            logger.info(() -> Thread.currentThread().toString() + " | break time (blocking)");
            try { Thread.sleep(Duration.ofSeconds(5)); } catch (InterruptedException ex) {} // blocking            
            logger.info(() -> Thread.currentThread().toString() + " | work done");
        };
        
        Runnable fastTask = () -> {
            logger.info(() -> Thread.currentThread().toString() + " | working on something");            
            logger.info(() -> Thread.currentThread().toString() + " | break time (blocking)");
            try { Thread.sleep(Duration.ofSeconds(1)); } catch (InterruptedException ex) {} // blocking            
            logger.info(() -> Thread.currentThread().toString() + " | work done");
        };

        Thread st = Thread.ofVirtual().name("slow-", 0).start(slowTask);
        Thread ft = Thread.ofVirtual().name("fast-", 0).start(fastTask);
        
        st.join();
        ft.join();
    }
}