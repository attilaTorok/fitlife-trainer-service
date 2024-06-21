package dev.fitlife.trainerservice.mapper;

import dev.fitlife.trainerservice.dto.ScheduleDto;
import dev.fitlife.trainerservice.model.Schedule;
import dev.fitlife.trainerservice.request.NewSchedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    Schedule toSchedule(ScheduleDto scheduleDto);
    ScheduleDto toScheduleDto(Schedule schedule);

    Schedule newScheduleToSchedule(NewSchedule newSchedule);

}
