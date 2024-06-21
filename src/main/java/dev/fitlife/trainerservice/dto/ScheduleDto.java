package dev.fitlife.trainerservice.dto;

import jakarta.annotation.Nonnull;

import java.time.LocalDateTime;
import java.util.UUID;

public record ScheduleDto(
        @Nonnull UUID id,
        @Nonnull UUID trainerId,
        @Nonnull UUID userId,
        @Nonnull LocalDateTime sessionDate
) {
}
