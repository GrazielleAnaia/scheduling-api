package com.grazielleanaia.scheduling_api.business.mapper;

import com.grazielleanaia.scheduling_api.business.dto.TaskDTO;
import com.grazielleanaia.scheduling_api.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface TaskConverter {

    TaskEntity toTask(TaskDTO taskDTO);

    TaskDTO toTaskDTO(TaskEntity taskEntity);

    List<TaskDTO> toListTaskDTO(List<TaskEntity> taskEntityList);

    List<TaskEntity> toListTaskEntity(List<TaskDTO> taskDTOList);

}
