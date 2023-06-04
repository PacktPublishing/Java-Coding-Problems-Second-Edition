package modern.challenge;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Main {
    
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {
        
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
        
        logger.info("Sleeping 15s ... ");
        Thread.sleep(Duration.ofSeconds(15)); // connect 'jconsole' while sleeping
        logger.info("Done ... ");

        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
        scheduledExecutor.scheduleAtFixedRate(() -> {
            ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
            ThreadInfo[] threadInfo = threadBean.dumpAllThreads(false, false);
            logger.info(() -> "Platform threads: " + threadInfo.length);
        }, 500, 500, TimeUnit.MILLISECONDS);

        long start = System.currentTimeMillis();
        
        try (ExecutorService executorCached = Executors.newCachedThreadPool()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executorCached.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    logger.info(() -> "Task: " + i);
                    return i;
                });
            });
        }
        
        logger.info(() -> "Time (ms): " + (System.currentTimeMillis() - start));
    }
}