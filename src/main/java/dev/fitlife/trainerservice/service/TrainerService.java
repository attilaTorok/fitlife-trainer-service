package dev.fitlife.trainerservice.service;

import dev.fitlife.trainerservice.dto.ReviewDto;
import dev.fitlife.trainerservice.dto.ScheduleDto;
import dev.fitlife.trainerservice.dto.TrainerDto;
import dev.fitlife.trainerservice.exception.TrainerNotFoundException;
import dev.fitlife.trainerservice.mapper.ReviewMapper;
import dev.fitlife.trainerservice.mapper.ScheduleMapper;
import dev.fitlife.trainerservice.mapper.TrainerMapper;
import dev.fitlife.trainerservice.repository.ReviewRepository;
import dev.fitlife.trainerservice.repository.ScheduleRepository;
import dev.fitlife.trainerservice.repository.TrainerRepository;
import dev.fitlife.trainerservice.request.NewSchedule;
import dev.fitlife.trainerservice.request.NewTrainer;
import dev.fitlife.trainerservice.request.NewTrainerReview;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;
    private final ScheduleRepository scheduleRepository;
    private final ReviewRepository reviewRepository;
    private final TrainerMapper trainerMapper;
    private final ScheduleMapper scheduleMapper;
    private final ReviewMapper reviewMapper;

    @Transactional
    public TrainerDto saveNewTrainer(NewTrainer newTrainer) {
        var trainer = trainerRepository.save(trainerMapper.newTrainerToTrainer(newTrainer));
        return trainerMapper.toTrainerDto(trainer);
    }

    @Transactional
    public ScheduleDto saveNewSchedule(NewSchedule newSchedule) {
        var trainerOptional = trainerRepository.findById(newSchedule.trainerId());
        if (trainerOptional.isEmpty()) {
            throw new TrainerNotFoundException(HttpStatus.NOT_FOUND.value(), "Trainer not found with id: " + newSchedule.trainerId());
        }

        var trainer = trainerOptional.get();
        trainer.getSchedules().add(scheduleMapper.newScheduleToSchedule(newSchedule));
        trainerRepository.save(trainer);

        return scheduleMapper.toScheduleDto(trainer.getSchedules().getLast());
    }

    public TrainerDto findTrainerById(UUID trainerId) {
        var trainer = trainerRepository.findById(trainerId).orElseThrow(
                () -> new TrainerNotFoundException(HttpStatus.NOT_FOUND.value(), "Trainer not found with id: " + trainerId)
        );
        return trainerMapper.toTrainerDto(trainer);
    }

    public ReviewDto saveNewReview(NewTrainerReview newTrainerReview) {
        var trainerOptional = trainerRepository.findById(newTrainerReview.trainerId());
        if (trainerOptional.isEmpty()) {
            throw new TrainerNotFoundException(HttpStatus.NOT_FOUND.value(), "Trainer not found with id: " + newTrainerReview.trainerId());
        }

        var trainer = trainerOptional.get();
        trainer.getReviews().add(reviewMapper.newTrainerReviewToTrainer(newTrainerReview));
        trainerRepository.save(trainer);

        return reviewMapper.toReviewDto(trainer.getReviews().getLast());
    }
}
