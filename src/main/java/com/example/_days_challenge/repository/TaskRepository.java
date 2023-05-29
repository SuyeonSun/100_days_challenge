package com.example._days_challenge.repository;

import com.example._days_challenge.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
