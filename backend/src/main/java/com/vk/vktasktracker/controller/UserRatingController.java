package com.vk.vktasktracker.controller;

import com.vk.vktasktracker.model.Person;
import com.vk.vktasktracker.model.TaskCategory;
import com.vk.vktasktracker.service.PersonService;
import com.vk.vktasktracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRatingController {

    private final TaskService taskService;
    private final PersonService personService;

    @GetMapping("/{personId}/rating/personal")
    public Map<TaskCategory, Integer> getTaskRatingByCategory(@PathVariable Long personId) {
        Person person = personService.getPerson(personId);
        return taskService.getTaskRatingByCategory(personId);
    }

    @GetMapping("/{personId}/rating/compare")
    public Map<Long, Map<TaskCategory, Integer>> getUserRankByCategory(@PathVariable Long personId) {
        Person person = personService.getPerson(personId);
        return taskService.getUserRankByCategory(personId);
    }
}
