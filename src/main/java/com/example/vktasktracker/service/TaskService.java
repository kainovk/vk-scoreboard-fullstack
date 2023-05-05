package com.example.vktasktracker.service;

import com.example.vktasktracker.model.Person;
import com.example.vktasktracker.model.PersonTasks;
import com.example.vktasktracker.model.Task;
import com.example.vktasktracker.repository.PersonTasksRepository;
import com.example.vktasktracker.repository.TaskRepository;
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
