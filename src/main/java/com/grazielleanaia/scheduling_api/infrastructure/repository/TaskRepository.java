package com.grazielleanaia.scheduling_api.infrastructure.repository;

import com.grazielleanaia.scheduling_api.infrastructure.entity.TaskEntity;
import com.grazielleanaia.scheduling_api.infrastructure.enums.NotificationStatusEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity, String> {

    List<TaskEntity> findByCustomerEmail(String email);

    List<TaskEntity> findByEventDateBetweenAndNotificationStatusEnum(LocalDateTime initialDate, LocalDateTime finaDate,
                                                                     NotificationStatusEnum status);

}
