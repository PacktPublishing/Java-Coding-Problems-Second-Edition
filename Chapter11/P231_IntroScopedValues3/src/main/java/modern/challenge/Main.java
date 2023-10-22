package modern.challenge;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

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

        Thread tpr = new Thread(() -> ScopedValue.where(SCOPED_VALUE, "Kaboooom-r!").run(taskr));
        // or, via of Platform()
        // Thread tpr = Thread.ofPlatform().unstarted(
        //     () -> ScopedValue.where(SCOPED_VALUE, "Kaboooom-r!").run(taskr));               

        Thread tpc = new Thread(() -> {
            try {
                ScopedValue.where(SCOPED_VALUE, "Kaboooom-c!").call(taskc);
            } catch (Exception ex) { /* handle exception */ }
        });
        // or, via of Platform()
        // Thread tpc = Thread.ofPlatform().unstarted(()-> {
        //    try {
        //        ScopedValue.where(SCOPED_VALUE, "Kaboooom-c!").call(taskc);
        //    } catch (Exception ex) { /* handle exception */ }
        // });              

        tpr.start();
        tpc.start();
        tpr.join();
        tpc.join();

        Thread tvr = Thread.ofVirtual().unstarted(
                () -> ScopedValue.where(SCOPED_VALUE, "Kaboooom-r!").run(taskr));

        Thread tvc = Thread.ofVirtual().unstarted(() -> {
            try {
                ScopedValue.where(SCOPED_VALUE, "Kaboooom-c!").call(taskc);
            } catch (Exception ex) { /* handle exception */ }
        });

        tvr.start();
        tvc.start();
        tvr.join();
        tvc.join();                

        Thread tpcx = new Thread(()
                -> ScopedValue.where(SCOPED_VALUE, "Kaboooom-tpcx!").run(taskr));
        Thread tpcy = new Thread(()
                -> ScopedValue.where(SCOPED_VALUE, "Kaboooom-tpcy!").run(taskr));

        tpcx.start();
        tpcy.start();
        tpcx.join();
        tpcy.join();

        Thread tpca = new Thread(()
                -> ScopedValue.where(SCOPED_VALUE, "Kaboooom-tpca!").run(taskr));
        Thread tpcb = new Thread(taskr);

        tpca.start();
        tpcb.start();
        tpca.join();
        tpcb.join();
    }
}