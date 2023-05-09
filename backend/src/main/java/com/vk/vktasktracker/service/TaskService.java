package com.vk.vktasktracker.service;

import com.vk.vktasktracker.exception.NotFoundException;
import com.vk.vktasktracker.model.CompletedTasks;
import com.vk.vktasktracker.model.Person;
import com.vk.vktasktracker.model.Task;
import com.vk.vktasktracker.model.TaskCategory;
import com.vk.vktasktracker.repository.CompletedTasksRepository;
import com.vk.vktasktracker.repository.PersonRepository;
import com.vk.vktasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final CompletedTasksRepository completedTasksRepository;
    private final PersonRepository personRepository;

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

    public Map<TaskCategory, Integer> getTaskRatingByCategory(Long personId) {
        List<Task> completedTasks = taskRepository.findCompletedTasksByPerson(personId);
        Map<TaskCategory, Integer> taskRatingByCategory = new HashMap<>();

        for (Task task : completedTasks) {
            TaskCategory category = task.getTaskCategory();
            taskRatingByCategory.put(category, taskRatingByCategory.getOrDefault(category, 0) + 1);
        }

        return taskRatingByCategory;
    }

    public Map<Long, Map<TaskCategory, Integer>> getUserRankByCategory(Long personId) {
        List<Task> completedTasks = taskRepository.findCompletedTasksByPerson(personId);
        List<Person> allUsers = personRepository.findAll();
        Map<Long, Map<TaskCategory, Integer>> userRankByCategory = new HashMap<>();

        for (Person user : allUsers) {
            if (!user.getId().equals(personId)) {
                List<Task> userCompletedTasks = taskRepository.findCompletedTasksByPerson(user.getId());
                Map<TaskCategory, Integer> categoryDifference = getCategoryDifference(completedTasks, userCompletedTasks);
                if(categoryDifference.size() > 0) {
                    userRankByCategory.put(user.getId(), categoryDifference);
                }
            }
        }

        return userRankByCategory;
    }

    private Map<TaskCategory, Integer> getCategoryDifference(List<Task> currentUserCompletedTasks,
                                                             List<Task> otherUserCompletedTasks) {
        Map<TaskCategory, Integer> taskCountByCategoryCurrentUser = getTaskCountByCategory(currentUserCompletedTasks);
        Map<TaskCategory, Integer> taskCountByCategoryOtherUser = getTaskCountByCategory(otherUserCompletedTasks);
        Map<TaskCategory, Integer> categoryDifference = new HashMap<>();

        for (TaskCategory category : taskCountByCategoryCurrentUser.keySet()) {
            int curUserCount = taskCountByCategoryCurrentUser.getOrDefault(category, 0);
            int otherUserCount = taskCountByCategoryOtherUser.getOrDefault(category, 0);
            int difference = curUserCount - otherUserCount;
            categoryDifference.put(category, difference);
        }

        return categoryDifference;
    }

    private Map<TaskCategory, Integer> getTaskCountByCategory(List<Task> tasks) {
        Map<TaskCategory, Integer> taskCountByCategory = new HashMap<>();

        for (Task task : tasks) {
            TaskCategory category = task.getTaskCategory();
            taskCountByCategory.put(category, taskCountByCategory.getOrDefault(category, 0) + 1);
        }

        return taskCountByCategory;
    }
}
