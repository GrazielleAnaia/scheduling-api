package com.grazielleanaia.scheduling_api.business.dto;

import com.grazielleanaia.scheduling_api.infrastructure.enums.NotificationStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskDTO {

    private String customerEmail;

    private String taskName;

    private String description;

    private LocalDateTime creationDate;

    private LocalDateTime eventDate;

    private LocalDateTime changeDate;

    private NotificationStatusEnum notificationStatusEnum;
}
