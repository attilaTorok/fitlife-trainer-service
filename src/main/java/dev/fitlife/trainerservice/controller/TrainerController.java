package dev.fitlife.trainerservice.controller;

import dev.fitlife.trainerservice.dto.ReviewDto;
import dev.fitlife.trainerservice.dto.ScheduleDto;
import dev.fitlife.trainerservice.request.NewSchedule;
import dev.fitlife.trainerservice.request.NewTrainer;
import dev.fitlife.trainerservice.request.NewTrainerReview;
import dev.fitlife.trainerservice.dto.TrainerDto;
import dev.fitlife.trainerservice.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/trainers")
@RestController
public class TrainerController {

    private final TrainerService trainerService;

    @PostMapping
    public ResponseEntity<TrainerDto> createNewTrainer(@RequestBody NewTrainer newTrainer) {
        return new ResponseEntity<>(trainerService.saveNewTrainer(newTrainer), HttpStatus.CREATED);
    }

    @GetMapping("/{trainerId}")
    public ResponseEntity<TrainerDto> getTrainer(@PathVariable UUID trainerId) {
        return ResponseEntity.ok(trainerService.findTrainerById(trainerId));
    }

    @PostMapping("/schedule")
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody NewSchedule newSchedule) {
        return new ResponseEntity<>(trainerService.saveNewSchedule(newSchedule), HttpStatus.CREATED);
    }

    @PostMapping("/review")
    public ResponseEntity<ReviewDto> createReview(@RequestBody NewTrainerReview newTrainerReview) {
        return new ResponseEntity<>(trainerService.saveNewReview(newTrainerReview), HttpStatus.CREATED);
    }


}
