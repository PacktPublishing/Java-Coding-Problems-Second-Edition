package modern.challenge;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import static java.util.concurrent.Future.State.CANCELLED;
import static java.util.concurrent.Future.State.FAILED;
import static java.util.concurrent.Future.State.RUNNING;
import static java.util.concurrent.Future.State.SUCCESS;
import jdk.incubator.concurrent.StructuredTaskScope;

public class PublicTransportScope extends StructuredTaskScope<List<PublicTransportOffer>> {

    private final List<List<PublicTransportOffer>> results = new CopyOnWriteArrayList<>();
    private final List<Throwable> exceptions = new CopyOnWriteArrayList<>();

    @Override
    protected void handleComplete(Future<List<PublicTransportOffer>> future) {

        switch (future.state()) {
            case RUNNING ->
                throw new IllegalStateException("Future is still in the running state ...");
            case SUCCESS -> {
                results.add(future.resultNow());
            }
            case FAILED ->
                exceptions.add(future.exceptionNow());
            case CANCELLED -> {
            }
        }
    }

    public PublicTransportOffer recommendedPublicTransport() {

        return results.stream()
                .flatMap(t -> t.stream())
                .min(Comparator.comparing(PublicTransportOffer::goTime))
                .orElseThrow(this::wrappingExceptions);
    }

    private PublicTransportException wrappingExceptions() {

        PublicTransportException exceptionWrapper = new PublicTransportException("Public transport exception");
        exceptions.forEach(exceptionWrapper::addSuppressed);

        return exceptionWrapper;
    }
}