package com.grazielleanaia.scheduling_api.controller;

import com.grazielleanaia.scheduling_api.business.TaskService;
import com.grazielleanaia.scheduling_api.business.dto.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
