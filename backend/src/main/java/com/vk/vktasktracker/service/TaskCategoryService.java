package com.vk.vktasktracker.service;

import com.vk.vktasktracker.exception.NotFoundException;
import com.vk.vktasktracker.model.TaskCategory;
import com.vk.vktasktracker.repository.TaskCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskCategoryService {

    private final TaskCategoryRepository taskCategoryRepository;

    public TaskCategory createTaskCategory(TaskCategory taskCategory) {
        return taskCategoryRepository.save(taskCategory);
    }

    public TaskCategory getTaskCategory(Long id) {
        return taskCategoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Task category not found")
        );
    }

    public List<TaskCategory> getAllCategories() {
        return taskCategoryRepository.findAll();
    }
}
