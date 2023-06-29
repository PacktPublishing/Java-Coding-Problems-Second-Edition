package modern.challenge;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    private static final int MAX_NR_OF_THREADS = 200;
    private static final int WEBSERVER_PORT = 8001;

    public static void main(String[] args) throws IOException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");       
        
        startWebServer(false, false);
    }
    
    private static void startWebServer(boolean virtual, boolean withLock) throws IOException {
        
        HttpServer httpServer = HttpServer
                .create(new InetSocketAddress(WEBSERVER_PORT), 0);
        
        httpServer.createContext("/webserver", new WebServerHandler(withLock));
        
        if (virtual) {
            httpServer.setExecutor(
                    Executors.newVirtualThreadPerTaskExecutor());
        } else {
            httpServer.setExecutor(
                    Executors.newFixedThreadPool(MAX_NR_OF_THREADS));
        }
        
        httpServer.start();
        
        logger.info(() -> " Server started on port " + WEBSERVER_PORT);
    }
}
