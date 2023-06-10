package modern.challenge;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import static java.util.concurrent.Future.State.CANCELLED;
import static java.util.concurrent.Future.State.FAILED;
import static java.util.concurrent.Future.State.RUNNING;
import static java.util.concurrent.Future.State.SUCCESS;
import jdk.incubator.concurrent.StructuredTaskScope;

public class TesterStructuredTaskScope extends StructuredTaskScope<String> {

    private final List<String> testers = new CopyOnWriteArrayList<>();
    private final List<Throwable> exceptions = new CopyOnWriteArrayList<>();
    
    @Override
    protected void handleComplete(Future<String> future) {
        
        switch (future.state()) {
                    case RUNNING ->
                        throw new IllegalStateException("Future is still in the running state ...");
                    case SUCCESS -> {                        
                        testers.add(future.resultNow());
                    }
                    case FAILED ->
                        exceptions.add(future.exceptionNow());
                    case CANCELLED -> {}
                }
    }
            
    public String bestTester() {

        Random rnd = new Random();
        
        return testers.stream()
                .skip(testers.isEmpty() ? 0 : rnd.nextInt(testers.size()))
                .findFirst()
                .orElseThrow(this::wrappingExceptions);
    }
    
    private UserNotFoundException wrappingExceptions() {
     
        UserNotFoundException exceptionWrapper = new UserNotFoundException("User not found exception");
        exceptions.forEach(exceptionWrapper::addSuppressed);
        
        return exceptionWrapper;
    }
}