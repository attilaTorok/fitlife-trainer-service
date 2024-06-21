package dev.fitlife.trainerservice.request;

import jakarta.annotation.Nonnull;

import java.util.UUID;

public record NewTrainerReview(
        @Nonnull UUID trainerId,
        @Nonnull UUID userId,
        @Nonnull Float rating,
        String comment
) {
}
