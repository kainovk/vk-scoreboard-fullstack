package com.vk.vktasktracker.controller;

import com.vk.vktasktracker.model.Person;
import com.vk.vktasktracker.model.PersonTasks;
import com.vk.vktasktracker.model.Task;
import com.vk.vktasktracker.model.TaskCategory;
import com.vk.vktasktracker.service.PersonService;
import com.vk.vktasktracker.service.TaskCategoryService;
import com.vk.vktasktracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final PersonService personService;
    private final TaskCategoryService taskCategoryService;

    @PostMapping("/categories")
    public TaskCategory createTaskCategory(@RequestBody TaskCategory taskCategory) {
        return taskCategoryService.createTaskCategory(taskCategory);
    }

    @PostMapping("/users")
    public Person createUser(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PostMapping("/{categoryId}/tasks")
    public Task createTask(@PathVariable Long categoryId, @RequestBody Task task) {
        TaskCategory taskCategory = taskCategoryService.getTaskCategory(categoryId);
        task.setTaskCategory(taskCategory);
        return taskService.createTask(task);
    }

    @PostMapping("/{taskId}/complete/{personId}")
    public PersonTasks completeTask(@PathVariable Long taskId, @PathVariable Long personId) {
        Task task = taskService.getTask(taskId);
        Person person = personService.getPerson(personId);
        return taskService.completeTask(task, person);
    }
}
