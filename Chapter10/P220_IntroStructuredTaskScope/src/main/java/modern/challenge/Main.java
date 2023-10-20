package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        buildTestingTeam();
    }

    public static TestingTeam buildTestingTeam() throws InterruptedException {

        try (StructuredTaskScope scope = new StructuredTaskScope<String>()) {

            Subtask<String> subtask = scope.fork(() -> fetchTester(1)); // non-blocking operation

            logger.info(() -> "Waiting for " + subtask.toString() + " to finish ...\n");

            scope.join(); // blocking operation

            /*
            String result = "";
            if (subtask.state().equals(Subtask.State.SUCCESS)) {
                result = subtask.get();
            }
            */
            
            String result = subtask.get(); // non-blocking operation

            logger.info(result);

            return new TestingTeam(result);
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
