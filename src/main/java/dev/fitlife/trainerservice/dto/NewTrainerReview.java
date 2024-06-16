package dev.fitlife.trainerservice.dto;

import jakarta.annotation.Nonnull;

import java.util.UUID;

public record NewTrainerReview(
        @Nonnull UUID trainerId,
        @Nonnull UUID userId,
        @Nonnull Float rating,
        String comment
) {
}
