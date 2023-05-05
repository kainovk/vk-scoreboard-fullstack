package com.example.vktasktracker.service;

import com.example.vktasktracker.model.TaskCategory;
import com.example.vktasktracker.repository.TaskCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskCategoryService {

    private final TaskCategoryRepository taskCategoryRepository;

    public TaskCategory createTaskCategory(TaskCategory taskCategory) {
        return taskCategoryRepository.save(taskCategory);
    }

    public TaskCategory getTaskCategory(Long id) {
        return taskCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Task category not found"));
    }
}
