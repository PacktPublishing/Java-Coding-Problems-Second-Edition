package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    private static final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
               
        logger.info(buildTestingTeam().toString());
    }
    
    public static TestingTeam buildTestingTeam() throws InterruptedException, ExecutionException {
        
        CompletableFuture<String> cfTester1 = fetchTester1();
        CompletableFuture<String> cfTester2 = fetchTester2();
        CompletableFuture<String> cfTester3 = fetchTester3();
        
        CompletableFuture<Void> fetchTesters = CompletableFuture.allOf(
                cfTester1, cfTester2, cfTester3);

        fetchTesters.get();
        
        TestingTeam team = new TestingTeam(
                cfTester1.resultNow(), cfTester2.resultNow(), cfTester3.resultNow());
        
        return team;
    }

    public static CompletableFuture<String> fetchTester1() {

        return CompletableFuture.supplyAsync(() -> {
            
            String tester1 = null;
            try {
                logger.info(Thread.currentThread().toString());
                tester1 = fetchTester(1);
            } catch (IOException | InterruptedException ex) { /* handle exceptions */ }

            return tester1;

        }, executor);
    }
    
    public static CompletableFuture<String> fetchTester2() {
    

        return CompletableFuture.supplyAsync(() -> {
            
            String tester2 = null;
            try {
                logger.info(Thread.currentThread().toString());
                tester2 = fetchTester(2);
            } catch (IOException | InterruptedException ex) { /* handle exceptions */ }

            return tester2;

        }, executor);
    }
    
    public static CompletableFuture<String> fetchTester3() {

        return CompletableFuture.supplyAsync(() -> {
            
            String tester3 = null;
            try {
                logger.info(Thread.currentThread().toString());
                tester3 = fetchTester(3);
            } catch (IOException | InterruptedException ex) { /* handle exceptions */ }

            return tester3;

        }, executor);
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
