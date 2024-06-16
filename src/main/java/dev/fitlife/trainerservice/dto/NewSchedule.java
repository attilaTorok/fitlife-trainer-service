package dev.fitlife.trainerservice.dto;

import jakarta.annotation.Nonnull;

import java.time.LocalDateTime;
import java.util.UUID;

public record NewSchedule(
        @Nonnull UUID trainerId,
        @Nonnull LocalDateTime sessionDate
) {
}
