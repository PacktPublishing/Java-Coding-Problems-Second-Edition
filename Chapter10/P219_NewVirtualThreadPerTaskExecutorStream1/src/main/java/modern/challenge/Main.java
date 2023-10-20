package modern.challenge;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            List<Future<String>> futures = IntStream.range(0, 10)
                    .mapToObj(i -> executor.submit(() -> {
                return Thread.currentThread().toString() + "(" + i + ")";
            })).collect(toList());

            futures.forEach(f -> {
                try {
                    logger.info(f.get());
                } catch (InterruptedException | ExecutionException ex) {
                    // handle exception
                }
            });
        }
    }
}
