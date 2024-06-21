package dev.fitlife.trainerservice.controller;

import dev.fitlife.trainerservice.BaseTest;
import dev.fitlife.trainerservice.dto.ReviewDto;
import dev.fitlife.trainerservice.dto.ScheduleDto;
import dev.fitlife.trainerservice.dto.TrainerDto;
import dev.fitlife.trainerservice.model.Trainer;
import dev.fitlife.trainerservice.repository.ReviewRepository;
import dev.fitlife.trainerservice.repository.ScheduleRepository;
import dev.fitlife.trainerservice.repository.TrainerRepository;
import dev.fitlife.trainerservice.request.NewSchedule;
import dev.fitlife.trainerservice.request.NewTrainer;
import dev.fitlife.trainerservice.request.NewTrainerReview;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class TrainerControllerTest extends BaseTest {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        trainerRepository.deleteAll();
        scheduleRepository.deleteAll();
    }

    @Test
    public void createNewTrainer() {
        var newTrainer = new NewTrainer("trainer", "gym", UUID.randomUUID(), 1F);

        var trainer = given()
                .contentType(ContentType.JSON)
                .body(newTrainer)
                .when()
                .post("/api/trainers")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("name", equalTo("trainer"),
                        "specialization", equalTo("gym"),
                        "rating", equalTo(1))
                .extract()
                .response()
                .as(TrainerDto.class);

        var trainerOptional = trainerRepository.findById(trainer.id());
        assertTrue(trainerOptional.isPresent());
    }

    @Test
    public void createSchedule() {
        UUID userId = UUID.randomUUID();
        var trainer = Trainer.builder()
                .userId(userId)
                .name("trainer")
                .specialization("gym")
                .build();
        trainerRepository.save(trainer);

        var newSchedule = new NewSchedule(trainer.getId(), userId, LocalDateTime.now());

        var newScheduleResponse = given()
                .contentType(ContentType.JSON)
                .body(newSchedule)
                .when()
                .post("/api/trainers/schedule")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .response()
                .as(ScheduleDto.class);

        var scheduleOptional = trainerRepository.findById(newScheduleResponse.trainerId());
        assertTrue(scheduleOptional.isPresent());
        assertEquals(1, scheduleOptional.get().getSchedules().size());
    }

    @Test
    public void createReview() {
        UUID userId = UUID.randomUUID();
        var trainer = Trainer.builder()
                .userId(userId)
                .name("trainer")
                .specialization("gym")
                .build();
        trainerRepository.save(trainer);

        var trainerReview = new NewTrainerReview(trainer.getId(), userId, 1F, "newComment");

        var newReviewResponse = given()
                .contentType(ContentType.JSON)
                .body(trainerReview)
                .when()
                .post("/api/trainers/review")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .response()
                .as(ReviewDto.class);

        var trainerOptional = trainerRepository.findById(newReviewResponse.trainerId());
        assertTrue(trainerOptional.isPresent());
        assertEquals(1, trainerOptional.get().getReviews().size());
    }

    @Test
    public void getTrainer() {
        var trainer = Trainer.builder()
                .userId(UUID.randomUUID())
                .name("trainer")
                .specialization("gym")
                .build();
        trainerRepository.save(trainer);

        var trainerId = trainer.getId();

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/trainers/{trainerId}", trainerId)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("trainerId", equalTo(trainer.getId()),
                        "userId", equalTo(trainer.getUserId()),
                        "rating", equalTo(trainer.getRating()));

        assertEquals(1, trainerRepository.count());
        assertEquals(1, reviewRepository.count());
    }

}
