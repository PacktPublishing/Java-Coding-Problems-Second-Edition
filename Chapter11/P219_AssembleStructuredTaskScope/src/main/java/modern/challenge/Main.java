package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import jdk.incubator.concurrent.StructuredTaskScope;
import jdk.incubator.concurrent.StructuredTaskScope.ShutdownOnSuccess;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        deliverTestingTeam();        
    }
    
    public static Testing deliverTestingTeam() throws InterruptedException {
        
        try (TestingStructuredTaskScope scope = new TestingStructuredTaskScope()) {

            Future<TestingTeam> team = scope.fork(() -> buildTestingTeam());
            Future<TestingLeader> leader = scope.fork(() -> chooseTestingTeamLeader());
            
            scope.join();  
            
            Testing testing = new Testing(team.resultNow(), leader.resultNow());
            
            logger.info(testing.toString());
            
            return testing;
        }
    }

    public static TestingTeam buildTestingTeam() throws InterruptedException, ExecutionException {

        try (StructuredTaskScope scope = new StructuredTaskScope<String>()) {

            Future<String> future1 = scope.fork(() -> fetchTester(1));
            Future<String> future2 = scope.fork(() -> fetchTester(2));
            Future<String> future3 = scope.fork(() -> fetchTester(3));

            scope.join();
        
            return new TestingTeam(future1.resultNow(), future2.resultNow(), future3.resultNow());
        }
    }  
    
    public static TestingLeader chooseTestingTeamLeader() throws InterruptedException {

        try (TesterStructuredTaskScope scope = new TesterStructuredTaskScope()) {

            scope.fork(() -> fetchTester(10));
            scope.fork(() -> fetchTester(11));
            scope.fork(() -> fetchTester(12));
            scope.fork(() -> fetchTester(13));
            scope.fork(() -> fetchTester(14));

            scope.join();            
            
            return new TestingLeader(scope.bestTester());
        }
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
