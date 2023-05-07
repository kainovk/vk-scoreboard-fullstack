package com.vk.vktasktracker.controller;

import com.vk.vktasktracker.model.CompletedTasks;
import com.vk.vktasktracker.model.Person;
import com.vk.vktasktracker.model.Task;
import com.vk.vktasktracker.service.PersonService;
import com.vk.vktasktracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final TaskService taskService;

    @PostMapping
    public Person createUser(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public List<Person> getAllUsers() {
        return personService.getAllUsers();
    }

    @PostMapping("/{personId}/complete/{taskId}")
    public CompletedTasks completeTask(@PathVariable Long personId, @PathVariable Long taskId) {
        Task task = taskService.getTask(taskId);
        Person person = personService.getPerson(personId);
        return taskService.completeTask(task, person);
    }

    @GetMapping("/{personId}/tasks")
    public List<Task> getAllCompletedTasksByUser(@PathVariable Long personId) {
        return taskService.getAllCompletedTasksByUser(personId);
    }
}
