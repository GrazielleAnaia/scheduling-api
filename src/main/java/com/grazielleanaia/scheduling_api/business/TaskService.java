package com.grazielleanaia.scheduling_api.business;

import com.grazielleanaia.scheduling_api.business.dto.TaskDTO;
import com.grazielleanaia.scheduling_api.business.mapper.TaskConverter;
import com.grazielleanaia.scheduling_api.infrastructure.entity.TaskEntity;
import com.grazielleanaia.scheduling_api.infrastructure.enums.NotificationStatusEnum;
import com.grazielleanaia.scheduling_api.infrastructure.exception.ResourceNotFoundException;
import com.grazielleanaia.scheduling_api.infrastructure.repository.TaskRepository;
import com.grazielleanaia.scheduling_api.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;
    private final JwtUtil jwtUtil;

    public TaskDTO createTask(TaskDTO taskDTO, String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        taskDTO.setCustomerEmail(email);
        taskDTO.setCreationDate(LocalDateTime.now());
        taskDTO.setNotificationStatusEnum(NotificationStatusEnum.PENDENT);
        TaskEntity task = taskConverter.toTask(taskDTO);
        return taskConverter.toTaskDTO(taskRepository.save(task));
    }

    public void deleteTaskById(String id) {
        try {
            taskRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id not found" + id, e.getCause());
        }
    }

    public List<TaskDTO> findTaskByEmail(String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        List<TaskEntity> entityList = taskRepository.findByCustomerEmail(email);
        return taskConverter.toListTaskDTO(entityList);
    }

    public List<TaskDTO> findTaskByPeriod(LocalDateTime initialDate, LocalDateTime finalDate) {
        List<TaskEntity> entityList = taskRepository.findByEventDateBetween(initialDate, finalDate);
        return taskConverter.toListTaskDTO(entityList);
    }


}
