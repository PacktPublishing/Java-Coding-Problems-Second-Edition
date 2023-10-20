package modern.challenge;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            List<Future<String>> futures = executor.invokeAll(
                    List.of(() -> "pass01", () -> "pass02", () -> "pass03")
            );
            
            futures.forEach(f -> logger.info(() -> "State: " + f.state()));
        }
        
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            String result = executor.invokeAny(
                    List.of(() -> "pass01", () -> "pass02", () -> "pass03")
            );
            
            logger.info(result);
        }
    }
}