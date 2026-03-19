package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages a collection of Task objects.
 * @author Nylah Shepherd
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Constructs a TaskManager.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a task if ID is unique.
     * @param task the task to add
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException();
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by ID.
     * @param taskId the task ID
     * @return the Task if found, otherwise null
     */
    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    /**
     * Returns list of tasks matching status.
     * @param status the status
     * @return list of tasks
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }

        return result;
    }
}