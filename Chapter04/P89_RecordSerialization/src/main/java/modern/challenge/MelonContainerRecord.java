package modern.challenge;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public record MelonContainerRecord(LocalDate expiration, String batch, Melon melon) implements Serializable {

    public MelonContainerRecord   {

        Objects.requireNonNull(expiration, "The expiration date cannot be null");
        Objects.requireNonNull(batch, "The batch cannot be null");
        Objects.requireNonNull(melon, "The melon cannot be null");

        if (!batch.startsWith("ML")) {
            throw new IllegalArgumentException("The batch format should be: MLxxxxxxxx");
        }

        if (expiration.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The expiration date cannot be before the current date");
        }
    }
}
