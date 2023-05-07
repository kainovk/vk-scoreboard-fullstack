package com.vk.vktasktracker.controller;

import com.vk.vktasktracker.model.Task;
import com.vk.vktasktracker.model.TaskCategory;
import com.vk.vktasktracker.service.TaskCategoryService;
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
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskCategoryService taskCategoryService;

    @PostMapping("/{categoryId}")
    public Task createTask(@PathVariable Long categoryId, @RequestBody Task task) {
        TaskCategory taskCategory = taskCategoryService.getTaskCategory(categoryId);
        task.setTaskCategory(taskCategory);
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
