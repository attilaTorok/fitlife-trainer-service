package dev.fitlife.trainerservice.mapper;

import dev.fitlife.trainerservice.dto.ReviewDto;
import dev.fitlife.trainerservice.model.Review;
import dev.fitlife.trainerservice.request.NewTrainerReview;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDto toReviewDto(Review review);

    Review newTrainerReviewToTrainer(NewTrainerReview newTrainerReview);

}
