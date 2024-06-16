package dev.fitlife.trainerservice.controller;

import dev.fitlife.trainerservice.BaseTest;
import dev.fitlife.trainerservice.dto.NewSchedule;
import dev.fitlife.trainerservice.dto.NewTrainer;
import dev.fitlife.trainerservice.dto.NewTrainerReview;
import dev.fitlife.trainerservice.model.Trainer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TrainerControllerTest extends BaseTest {

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @Test
    public void createNewTrainer() {
        var trainer = new NewTrainer("trainer", "gym", 1F);

        given()
                .contentType(ContentType.JSON)
                .body(trainer)
                .when()
                .post("/api/trainers")
                .then()
                .statusCode(HttpStatus.CREATED.value());
        // TODO assert trainer is in the DB
    }

    @Test
    public void createSchedule() {
        // TODO create trainer in DB
        var trainerId = UUID.randomUUID();
        var schedule = new NewSchedule(trainerId, LocalDateTime.now());

        given()
                .contentType(ContentType.JSON)
                .body(schedule)
                .when()
                .post("/api/trainers/schedule")
                .then()
                .statusCode(HttpStatus.CREATED.value());
        // TODO assert schedule is in the DB
    }

    @Test
    public void createReview() {
        // TODO create trainer in DB
        var trainerId = UUID.randomUUID();
        var trainerReview = new NewTrainerReview(trainerId, UUID.randomUUID(), 1F, "newComment");

        given()
                .contentType(ContentType.JSON)
                .body(trainerReview)
                .when()
                .post("/api/review")
                .then()
                .statusCode(HttpStatus.CREATED.value());
        // TODO assert review is in the DB
    }

    @Test
    public void getTrainer() {
        // TODO create trainer in DB
        var trainer = new Trainer();
        var trainerId = UUID.randomUUID();

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/trainers/{trainerId}", trainerId)
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("trainerId", equalTo(trainer.getId()),
                        "userId", equalTo(trainer.getUserId()),
                        "rating", equalTo(trainer.getRating()),
                        "comment", equalTo(trainer.getReviews().getLast().getComment()));
        // TODO assert review is in the DB
    }

}
