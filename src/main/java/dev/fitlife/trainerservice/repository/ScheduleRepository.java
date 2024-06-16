package dev.fitlife.trainerservice.repository;

import dev.fitlife.trainerservice.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, UUID> {
}
