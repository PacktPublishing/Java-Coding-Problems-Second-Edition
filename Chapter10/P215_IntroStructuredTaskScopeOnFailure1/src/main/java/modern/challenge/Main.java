package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import jdk.incubator.concurrent.StructuredTaskScope;
import jdk.incubator.concurrent.StructuredTaskScope.ShutdownOnFailure;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        buildTestingTeam();
    }
    
    public static TestingTeam buildTestingTeam() throws InterruptedException, ExecutionException {
        
        try (ShutdownOnFailure scope = new StructuredTaskScope.ShutdownOnFailure()) {

            Future<String> future1 = scope.fork(() -> fetchTester(1));
            Future<String> future2 = scope.fork(() -> fetchTester(2));
            Future<String> future3 = scope.fork(() -> fetchTester(Integer.MAX_VALUE));

            scope.join();

            logger.info(() -> "Future-1 state: " + future1.state());
            logger.info(() -> "Future-2 state: " + future2.state());
            logger.info(() -> "Future-3 state: " + future3.state());

            Optional<Throwable> exception = scope.exception();

            if (exception.isEmpty()) {
                logger.info(() -> "Future-1 result: " + future1.resultNow());
                logger.info(() -> "Future-2 result: " + future2.resultNow());
                logger.info(() -> "Future-3 result: " + future3.resultNow());
                
                return new TestingTeam(future1.resultNow(), future2.resultNow(), future3.resultNow());
            } else {
                logger.info(() -> exception.get().getMessage());
                scope.throwIfFailed();
            }
        }
        
        return new TestingTeam();
    }

    public static String fetchTester(int id) throws IOException, InterruptedException {

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
}
