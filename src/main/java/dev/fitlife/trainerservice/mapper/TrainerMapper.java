package dev.fitlife.trainerservice.mapper;

import dev.fitlife.trainerservice.dto.TrainerDto;
import dev.fitlife.trainerservice.model.Trainer;
import dev.fitlife.trainerservice.request.NewTrainer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    TrainerDto toTrainerDto(Trainer trainer);

    Trainer toTrainer(TrainerDto trainerDto);

    Trainer newTrainerToTrainer(NewTrainer newTrainer);

}
