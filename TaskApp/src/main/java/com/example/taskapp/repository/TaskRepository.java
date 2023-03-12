package com.example.taskapp.repository;

import com.example.taskapp.model.dto.ShowTaskDTO;
import com.example.taskapp.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title);
}
