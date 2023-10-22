package modern.challenge;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final ThreadLocal<String> threadLocal
            = ThreadLocal.<String>withInitial(() -> {
                return "";
            });

    private static final ScopedValue<String> SCOPED_VALUE = ScopedValue.newInstance();

    public static void sayHelloTL() {
        
        logger.info(Thread.currentThread().toString());
        logger.info(() -> "Hello " + threadLocal.get());
    }
    
    public static void sayGoodByeTL() {
        
        logger.info(Thread.currentThread().toString());
        logger.info(() -> "Good bye " + threadLocal.get());
    }
    
    public static void sayHelloSV() {
        
        logger.info(Thread.currentThread().toString());
        logger.info(() -> "Hello " + SCOPED_VALUE.orElse("you"));
    }
    
    public static void sayGoodByeSV() {
        
        logger.info(Thread.currentThread().toString());
        logger.info(() -> "Good bye " + SCOPED_VALUE.orElse("you"));
    }
    
    public static void main(String[] args) throws InterruptedException, Exception {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        threadLocal.set("Mike");
        sayHelloTL();
        sayGoodByeTL();
        
        ScopedValue.where(SCOPED_VALUE, "Mike").run(() -> sayHelloSV());
        // ScopedValue.where(SCOPED_VALUE, "Mike").run(() -> sayGoodByeSV());
        sayGoodByeSV();
    }
}
