package dev.fitlife.trainerservice.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "reviews")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Nonnull
    private UUID trainer;

    @Nonnull
    private UUID userId;

    @Nonnull
    private Integer rating;

    private String comment;

}
