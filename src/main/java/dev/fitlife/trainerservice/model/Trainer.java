package dev.fitlife.trainerservice.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "trainers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Nonnull
    private UUID userId;

    @Nonnull
    private String name;

    @Nonnull
    private String specialization;

    private Float rating;

    @OneToMany
    private List<Schedule> schedules;

    @OneToMany
    private List<Review> reviews;


}
