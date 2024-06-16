package dev.fitlife.trainerservice.controller;

import dev.fitlife.trainerservice.dto.NewSchedule;
import dev.fitlife.trainerservice.dto.NewTrainer;
import dev.fitlife.trainerservice.dto.NewTrainerReview;
import dev.fitlife.trainerservice.dto.TrainerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/trainers ")
@RestController
public class TrainerController {

    @PostMapping
    public ResponseEntity<NewTrainer> createNewTrainer(@RequestBody NewTrainer newTrainer) {
        return null;
    }

    @GetMapping("/{trainerId}")
    public ResponseEntity<TrainerDto> getTrainer(@PathVariable Long trainerId) {
        return null;
    }

    @PostMapping("/schedule")
    public ResponseEntity<NewSchedule> createSchedule(@RequestBody NewSchedule newSchedule) {
        return null;
    }

    @PostMapping("/review")
    public ResponseEntity<NewTrainerReview> createReview(@RequestBody NewTrainerReview newTrainerReview) {
        return null;
    }


}
