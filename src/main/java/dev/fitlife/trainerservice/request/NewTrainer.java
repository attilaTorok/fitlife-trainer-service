package dev.fitlife.trainerservice.request;

import jakarta.annotation.Nonnull;

import java.util.UUID;

public record NewTrainer(
        @Nonnull String name,
        @Nonnull String specialization,
        @Nonnull UUID userId,
        Float rating) {
}
