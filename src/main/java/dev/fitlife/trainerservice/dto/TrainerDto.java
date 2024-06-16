package dev.fitlife.trainerservice.dto;

import jakarta.annotation.Nonnull;

import java.util.UUID;

public record TrainerDto(
        @Nonnull UUID trainerId,
        @Nonnull UUID userId,
        @Nonnull Integer rating,
        String comment
) {
}
