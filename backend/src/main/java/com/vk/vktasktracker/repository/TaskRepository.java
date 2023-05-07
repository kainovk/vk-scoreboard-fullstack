package com.vk.vktasktracker.repository;

import com.vk.vktasktracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t " +
            "JOIN CompletedTasks ct ON t.id = ct.task.id AND :personId = ct.person.id")
    List<Task> findAllByPersonId(@Param("personId") Long personId);

    @Query("SELECT t FROM Task t " +
            "JOIN CompletedTasks ct ON t.id = ct.task.id AND :personId = ct.person.id " +
            "JOIN TaskCategory tc ON t.taskCategory.id = tc.id")
    List<Task> findCompletedTasksByPerson(@Param("personId") Long personId);
}
