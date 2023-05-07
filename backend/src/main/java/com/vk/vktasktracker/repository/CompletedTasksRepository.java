package com.vk.vktasktracker.repository;

import com.vk.vktasktracker.model.CompletedTasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedTasksRepository extends JpaRepository<CompletedTasks, Long> {
}
