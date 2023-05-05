package com.vk.vktasktracker.service;

import com.vk.vktasktracker.model.Person;
import com.vk.vktasktracker.model.PersonTasks;
import com.vk.vktasktracker.model.Task;
import com.vk.vktasktracker.repository.PersonTasksRepository;
import com.vk.vktasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final PersonTasksRepository personTasksRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public PersonTasks completeTask(Task task, Person person) {
        PersonTasks personTasks = new PersonTasks();
        personTasks.setTask(task);
        personTasks.setPerson(person);
        personTasks.setCompleted(true);
        return personTasksRepository.save(personTasks);
    }
}
