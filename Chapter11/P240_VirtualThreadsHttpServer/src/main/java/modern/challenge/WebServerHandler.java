package modern.challenge;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebServerHandler implements HttpHandler {

    private final static Logger logger = Logger.getLogger(WebServerHandler.class.getName());

    private final static int PERMITS = 20;
    private final static Semaphore semaphore = new Semaphore(PERMITS);

    private final static AtomicLong requestId = new AtomicLong();

    private static final Callable<String> task = () -> {

        String response = null;

        try {
            Thread.sleep(200);
            response = "Request id_" + requestId.incrementAndGet();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response;
    };

    private final boolean withLock;

    public WebServerHandler(boolean withLock) {
        this.withLock = withLock;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response = null;

        if (withLock) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) { throw new RuntimeException(e); }            
            try {
                response = task.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        } else {
            try {
                response = task.call();
            } catch (Exception e) { throw new RuntimeException(e); }
        }

        logger.log(Level.INFO, "{0} | {1}", new Object[]{response,
             Thread.currentThread()
        });

        exchange.sendResponseHeaders(
                200, response == null ? 0 : response.length());

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response == null ? new byte[0] : response.getBytes());
        }
    }
}