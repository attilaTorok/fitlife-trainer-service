package dev.fitlife.trainerservice.repository;

import dev.fitlife.trainerservice.model.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, UUID> {
}
