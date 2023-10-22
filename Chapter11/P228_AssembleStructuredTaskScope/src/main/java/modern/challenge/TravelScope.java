package modern.challenge;

import java.util.concurrent.StructuredTaskScope;

public class TravelScope extends StructuredTaskScope<Travel> {

    private volatile RidesharingOffer ridesharingOffer;
    private volatile PublicTransportOffer publicTransportOffer;
    private volatile RidesharingException ridesharingException;
    private volatile PublicTransportException publicTransportException;

    @Override
    protected void handleComplete(Subtask<? extends Travel> subtask) {

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

        return new TravelOffer(ridesharingOffer, publicTransportOffer);
    }
}
