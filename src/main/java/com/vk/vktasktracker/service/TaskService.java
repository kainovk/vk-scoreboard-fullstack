package com.vk.vktasktracker.service;

import com.vk.vktasktracker.exception.NotFoundException;
import com.vk.vktasktracker.model.Person;
import com.vk.vktasktracker.model.CompletedTasks;
import com.vk.vktasktracker.model.Task;
import com.vk.vktasktracker.repository.CompletedTasksRepository;
import com.vk.vktasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final CompletedTasksRepository completedTasksRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
    }

    public CompletedTasks completeTask(Task task, Person person) {
        CompletedTasks completedTasks = new CompletedTasks();
        completedTasks.setTask(task);
        completedTasks.setPerson(person);
        return completedTasksRepository.save(completedTasks);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getAllCompletedTasksByUser(Long personId) {
        return taskRepository.findAllByPersonId(personId);
    }
}
