package dev.fitlife.trainerservice.dto;

import jakarta.annotation.Nonnull;

public record NewTrainer(
        @Nonnull String name,
        @Nonnull String specialization,
        Float rating) {
}
