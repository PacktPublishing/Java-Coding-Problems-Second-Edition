package modern.challenge;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        List<Thread> vtThreads = IntStream.range(0, 5)
                .mapToObj(i -> Thread.ofVirtual().unstarted(() -> {

            if (i == 0) { logger.info(Thread.currentThread().toString()); }

            try { Thread.sleep(1000); } catch (InterruptedException ex) {}

            if (i == 0) { logger.info(Thread.currentThread().toString()); }
        })).toList();
        

        vtThreads.forEach(Thread::start);
        vtThreads.forEach(thread -> {
            try { thread.join(); } catch (InterruptedException ex) {}
        });               
    }
}