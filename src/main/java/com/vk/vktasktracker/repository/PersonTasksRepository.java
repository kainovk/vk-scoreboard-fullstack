package com.vk.vktasktracker.repository;

import com.vk.vktasktracker.model.PersonTasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonTasksRepository extends JpaRepository<PersonTasks, Long> {
}
