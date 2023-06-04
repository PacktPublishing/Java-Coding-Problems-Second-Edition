package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import jdk.incubator.concurrent.StructuredTaskScope;
import jdk.incubator.concurrent.StructuredTaskScope.ShutdownOnSuccess;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        try(ShutdownOnSuccess scope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {
            
            Future<String> future1 = scope.fork(() -> fetchTester(1));
            Future<String> future2 = scope.fork(() -> fetchTester(2));
            Future<String> future3 = scope.fork(() -> fetchTester(3));
                                                
            scope.join();
            
            logger.info(() -> "Future-1 state: " + future1.state());
            logger.info(() -> "Future-2 state: " + future2.state());
            logger.info(() -> "Future-3 state: " + future3.state());
            
            String result = (String) scope.result();
            
            logger.info(result);
        }
    }

    public static String fetchTester(int id) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        
        // intentionally added a delay of 1-5 seconds
        Thread.sleep(Duration.ofMillis(ThreadLocalRandom.current().nextLong(5000)));
        
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
