package modern.challenge;

import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import java.util.concurrent.StructuredTaskScope;

public class TravelScope extends StructuredTaskScope<Travel> {

    private static final Logger logger = Logger.getLogger(TravelScope.class.getName());

    private volatile RidesharingOffer ridesharingOffer;
    private volatile PublicTransportOffer publicTransportOffer;
    private volatile RidesharingException ridesharingException;
    private volatile PublicTransportException publicTransportException;
    private volatile TimeoutException timeoutException;

    @Override
    protected void handleComplete(
            Subtask<? extends Travel> subtask) {

        switch (subtask.state()) {
            case SUCCESS -> {
                switch (subtask.get()) {
                    case RidesharingOffer ro ->
                        this.ridesharingOffer = ro;
                    case PublicTransportOffer pto ->
                        this.publicTransportOffer = pto;
                }
            }
            case FAILED -> {
                switch (subtask.exception()) {
                    case RidesharingException re ->
                        this.ridesharingException = re;
                    case PublicTransportException pte ->
                        this.publicTransportException = pte;
                    case TimeoutException te -> 
                        this.timeoutException = te;
                    case Throwable t ->
                        throw new RuntimeException(t);
                }
            }
            case UNAVAILABLE ->
                throw new IllegalStateException("Subtask may still running ...");
        }
    }

    public TravelOffer recommendedTravelOffer() {
        
        super.ensureOwnerAndJoined();

        if (timeoutException != null) {
            logger.warning("Some of the called services did not respond in time");
        }

        return new TravelOffer(ridesharingOffer, publicTransportOffer);
    }
}
