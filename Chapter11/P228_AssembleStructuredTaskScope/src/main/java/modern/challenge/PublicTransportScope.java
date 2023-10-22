package modern.challenge;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.StructuredTaskScope;

public class PublicTransportScope extends StructuredTaskScope<List<PublicTransportOffer>> {

    private final List<List<PublicTransportOffer>> results = new CopyOnWriteArrayList<>();
    private final List<Throwable> exceptions = new CopyOnWriteArrayList<>();

    @Override
    protected void handleComplete(Subtask<? extends List<PublicTransportOffer>> subtask) {

        switch (subtask.state()) {
            case SUCCESS ->
                results.add(subtask.get());
            case FAILED ->
                exceptions.add(subtask.exception());
            case UNAVAILABLE ->
                throw new IllegalStateException("Subtask may still running ...");
        }
    }

    public PublicTransportOffer recommendedPublicTransport() {
        
        super.ensureOwnerAndJoined();

        return results.stream()
                .flatMap(t -> t.stream())
                .min(Comparator.comparing(PublicTransportOffer::goTime))
                .orElseThrow(this::wrappingExceptions);
    }

    private PublicTransportException wrappingExceptions() {
        
        super.ensureOwnerAndJoined();

        PublicTransportException exceptionWrapper 
                = new PublicTransportException("Public transport exception");
        exceptions.forEach(exceptionWrapper::addSuppressed);

        return exceptionWrapper;
    }
}