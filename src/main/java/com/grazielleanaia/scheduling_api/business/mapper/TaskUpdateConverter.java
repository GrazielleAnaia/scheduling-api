package com.grazielleanaia.scheduling_api.business.mapper;

import com.grazielleanaia.scheduling_api.business.dto.TaskDTO;
import com.grazielleanaia.scheduling_api.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskUpdateConverter {
    public TaskEntity toTaskEntity(TaskDTO taskDTO, @MappingTarget TaskEntity taskEntity);
}
