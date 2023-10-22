package modern.challenge;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    private static final ScopedValue<String> SCOPED_VALUE = ScopedValue.newInstance();

    public static void main(String[] args) throws InterruptedException, Exception {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");        
        
        Runnable taskr1 = () -> {
            logger.info(Thread.currentThread().toString());
            logger.info(() -> SCOPED_VALUE.orElse("Not bound"));
        };
        
        Runnable taskr2 = () -> {
            logger.info(Thread.currentThread().toString());
            logger.info(() -> SCOPED_VALUE.orElseThrow(() -> new RuntimeException("Not bound")));
        };                
        
        // taskr1.run();
        // taskr2.run();
        
        Runnable taskr = () -> {
            logger.info(Thread.currentThread().toString());
            logger.info(() -> SCOPED_VALUE.get());
        };
                
        Thread.ofVirtual().start(() -> ScopedValue.runWhere(
                SCOPED_VALUE, SCOPED_VALUE.orElse("Kaboooom"), taskr)).join();
        
        Thread.ofVirtual().start(() -> ScopedValue.runWhere(
                SCOPED_VALUE, SCOPED_VALUE.orElseThrow(() -> new RuntimeException("Not bound")), taskr)).join();         
    }  
}