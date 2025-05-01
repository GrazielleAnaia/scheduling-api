package com.grazielleanaia.scheduling_api.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grazielleanaia.scheduling_api.infrastructure.enums.NotificationStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskDTO {

    private String id;

    private String customerEmail;

    private String taskName;

    private String description;

    private LocalDateTime creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime eventDate;

    private LocalDateTime changeDate;

    private NotificationStatusEnum notificationStatusEnum;
}
