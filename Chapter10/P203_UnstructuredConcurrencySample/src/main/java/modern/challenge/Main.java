package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        buildTestingTeam();
    }

    public static void buildTestingTeam() throws InterruptedException {

        // STOP 1
        Future<String> future1 = futureUser(1);
        Future<String> future2 = futureUser(2); // Integer.MAX_VALUE
        Future<String> future3 = futureUser(3);

        try {
            // STOP 2
            String user1 = future1.get();
            String user2 = future2.get();
            String user3 = future3.get();

            logger.info(user1);
            logger.info(user2);
            logger.info(user3);
        } catch (ExecutionException ex) {
            // STOP 3
            throw new RuntimeException(ex);
        } finally {
            // STOP 4
            shutdownExecutor(executor);
        }
    }

    // STOP 5
    public static Future<String> futureUser(int id) {

        return executor.submit(() -> fetchUser(id));
    }

    public static String fetchUser(int id) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest requestGet = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://reqres.in/api/users/" + id))
                .build();

        HttpResponse<String> responseGet = client.send(
                requestGet, HttpResponse.BodyHandlers.ofString());

        if (responseGet.statusCode() == 200) {
            return responseGet.body();
        }

        throw new UserNotFoundException("Code: " + responseGet.statusCode());
    }

    private static boolean shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();

                return executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
            }

            return true;
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        }
        return false;
    }
}
