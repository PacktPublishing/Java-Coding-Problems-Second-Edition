package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
        
        buildTestingTeam();
    }
    
    public static TestingTeam buildTestingTeam() throws InterruptedException {
        
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            List<Future<String>> futures = executor.invokeAll(
                    List.of(() -> fetchTester(1), () -> fetchTester(2), () -> fetchTester(3))
            );
            
            futures.forEach(f -> logger.info(() -> "State: " + f.state()));   
            
            return new TestingTeam(futures.get(0).resultNow(), 
                    futures.get(1).resultNow(), futures.get(2).resultNow());
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
