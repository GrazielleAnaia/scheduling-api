package com.grazielleanaia.scheduling_api.controller;

import com.grazielleanaia.scheduling_api.business.TaskService;
import com.grazielleanaia.scheduling_api.business.dto.TaskDTO;
import com.grazielleanaia.scheduling_api.infrastructure.enums.NotificationStatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor

public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO,
                                              @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(taskService.createTask(taskDTO, token));
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findTaskList(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(taskService.findTaskByEmail(token));
    }


    @GetMapping("/events")
    public ResponseEntity<List<TaskDTO>> findTaskByPeriod(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                          LocalDateTime initialDate,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                          LocalDateTime finalDate) {
        return ResponseEntity.ok(taskService.findTaskByPeriod(initialDate, finalDate));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTaskById(@RequestParam("id") String id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TaskDTO> updateTasks(@RequestParam("id") String id,
                                               @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.updateTask(taskDTO, id));
    }

    @PatchMapping
    public ResponseEntity<TaskDTO> changeNotificationStatus(@RequestParam("id") String id,
                                                            @RequestParam("status") NotificationStatusEnum status) {
        return ResponseEntity.ok(taskService.changeNotificationStatus(id, status));
    }
}
