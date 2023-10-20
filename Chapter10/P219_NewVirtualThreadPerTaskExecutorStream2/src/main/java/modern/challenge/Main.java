package modern.challenge;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            List<String> results1 = executor.invokeAll(
                    List.of(() -> "pass01", () -> "pass02", () -> "pass03"))
                    .stream()
                    .filter(f -> f.state() == Future.State.SUCCESS)
                    .<String>mapMulti((f, c) -> {
                        c.accept((String) f.resultNow());
                    }).collect(Collectors.toList());

            List<String> results2 = executor.invokeAll(
                    List.of(() -> "pass01", () -> "pass02", () -> "pass03"))
                    .stream()
                    .filter(f -> f.state() == Future.State.SUCCESS)
                    .map(f -> f.resultNow().toString())
                    .toList();

            List<Object> results3 = executor.invokeAll(
                    List.of(() -> "pass01", () -> "pass02", () -> "pass03"))
                    .stream()
                    .filter(f -> f.state() == Future.State.SUCCESS)
                    .map(Future::resultNow)
                    .toList();

            logger.info(results1.toString());
            logger.info(results2.toString());
            logger.info(results3.toString());

            List<Throwable> exceptions1 = executor.invokeAll(
                    List.of(() -> "pass01", () -> "pass02".substring(50), () -> "pass03"))
                    .stream()
                    .filter(f -> f.state() == Future.State.FAILED)
                    .<Throwable>mapMulti((f, c) -> {
                        c.accept((Throwable) f.exceptionNow());
                    }).collect(Collectors.toList());
            
            List<Throwable> exceptions2 = executor.invokeAll(
                    List.of(() -> "pass01", () -> "pass02".substring(50), () -> "pass03"))
                    .stream()
                    .filter(f -> f.state() == Future.State.FAILED)
                    .map(Future::exceptionNow)
                    .toList();

            logger.severe(exceptions1.toString());
            logger.severe(exceptions2.toString());
        }
    }
}