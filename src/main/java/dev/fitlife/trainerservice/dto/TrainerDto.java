package dev.fitlife.trainerservice.dto;

import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.UUID;

public record TrainerDto(
        @Nonnull UUID id,
        @Nonnull UUID userId,
        @Nonnull String name,
        @Nonnull Integer rating,
        @Nonnull String specialization,
        List<ScheduleDto> schedules,
        List<ReviewDto> reviews) {
}
