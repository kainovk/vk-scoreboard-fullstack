package com.vk.vktasktracker.controller;

import com.vk.vktasktracker.model.TaskCategory;
import com.vk.vktasktracker.service.TaskCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class TaskCategoryController {

    private final TaskCategoryService taskCategoryService;

    @PostMapping
    public TaskCategory createTaskCategory(@RequestBody TaskCategory taskCategory) {
        return taskCategoryService.createTaskCategory(taskCategory);
    }

    @GetMapping
    public List<TaskCategory> getAllCategories() {
        return taskCategoryService.getAllCategories();
    }
}
