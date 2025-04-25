package com.grazielleanaia.scheduling_api.infrastructure.repository;

import com.grazielleanaia.scheduling_api.infrastructure.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
