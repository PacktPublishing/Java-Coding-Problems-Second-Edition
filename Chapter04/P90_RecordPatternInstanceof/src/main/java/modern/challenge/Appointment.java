package modern.challenge;

import java.time.LocalDateTime;

public record Appointment(LocalDateTime date, Doctor doctor) {}
