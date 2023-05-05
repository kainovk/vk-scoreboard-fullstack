package com.example.vktasktracker.repository;

import com.example.vktasktracker.model.PersonTasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonTasksRepository extends JpaRepository<PersonTasks, Long> {
}
