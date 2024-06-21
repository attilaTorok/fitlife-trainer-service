package dev.fitlife.trainerservice.request;

import jakarta.annotation.Nonnull;

import java.time.LocalDateTime;
import java.util.UUID;

public record NewSchedule(
        @Nonnull UUID trainerId,
        @Nonnull UUID userId,
        @Nonnull LocalDateTime sessionDate
) {
}
