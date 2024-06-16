package dev.fitlife.trainerservice.repository;

import dev.fitlife.trainerservice.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepository extends CrudRepository<Review, UUID> {
}
