package modern.challenge;

import java.util.concurrent.Callable;
import java.util.logging.Logger;
import jdk.incubator.concurrent.ScopedValue;
import jdk.incubator.concurrent.ScopedValue.Carrier;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    private static final ScopedValue<String> SCOPED_VALUE = ScopedValue.newInstance();

    public static void main(String[] args) throws InterruptedException, Exception {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");        
        
        Runnable taskr = () -> {
            logger.info(Thread.currentThread().toString());
            logger.info(() -> SCOPED_VALUE.isBound() ? SCOPED_VALUE.get() : "Not bound");
        };
        
        Callable<Boolean> taskc = () -> {
            logger.info(Thread.currentThread().toString());
            logger.info(() -> SCOPED_VALUE.isBound() ? SCOPED_VALUE.get() : "Not bound");
            return true;
        };
        
        logger.info("------------------------");        
        logger.info("ScopedValue and Runnable");
        logger.info("------------------------");        
        
        taskr.run();
        ScopedValue.where(SCOPED_VALUE, "Kaboooom!").run(taskr);
        ScopedValue.where(SCOPED_VALUE, "Kaboooom!", taskr);
        Carrier cr = ScopedValue.where(SCOPED_VALUE, "Kaboooom!");
        cr.run(taskr);
        taskr.run();
        
        logger.info("------------------------");        
        logger.info("ScopedValue and Callable");
        logger.info("------------------------");        
        
        taskc.call();
        ScopedValue.where(SCOPED_VALUE, "Kaboooom-1!").call(taskc);
        ScopedValue.where(SCOPED_VALUE, "Kaboooom-2!", taskc);
        Carrier cc = ScopedValue.where(SCOPED_VALUE, "Kaboooom-3!");
        cc.call(taskc);
        taskc.call();
    }  
}