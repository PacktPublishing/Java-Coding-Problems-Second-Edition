package modern.challenge;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MelonContainer implements Serializable {

    private final LocalDate expiration;
    private final String batch;
    private final Melon melon;

    public MelonContainer(LocalDate expiration, String batch, Melon melon) {

        Objects.requireNonNull(expiration, "The expiration date cannot be null");
        Objects.requireNonNull(batch, "The batch cannot be null");
        Objects.requireNonNull(melon, "The melon cannot be null");

        if (!batch.startsWith("ML")) {
            throw new IllegalArgumentException("The batch format should be: MLxxxxxxxx");
        }

        if (expiration.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The expiration date cannot be before the current date");
        }

        this.expiration = expiration;
        this.batch = batch;
        this.melon = melon;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public String getBatch() {
        return batch;
    }

    public Melon getMelon() {
        return melon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.expiration);
        hash = 97 * hash + Objects.hashCode(this.batch);
        hash = 97 * hash + Objects.hashCode(this.melon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final MelonContainer other = (MelonContainer) obj;
        if (!Objects.equals(this.batch, other.batch)) {
            return false;
        }

        if (!Objects.equals(this.expiration, other.expiration)) {
            return false;
        }

        return Objects.equals(this.melon, other.melon);
    }

    @Override
    public String toString() {
        return "MelonContainer{" + "expiration=" + expiration
                + ", batch=" + batch + ", melon=" + melon + '}';
    }
}
