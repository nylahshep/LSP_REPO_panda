package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a Task with ID, description, and status.
 * @author Nylah Shepherd
 */
public class Task {

    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with default status OPEN.
     * @param taskId the task ID
     * @param description the task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Gets the task ID.
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Gets the task description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the task status.
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status if valid, otherwise UNKNOWN.
     * @param status the new status
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") ||
            status.equals("IN_PROGRESS") ||
            status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns formatted task string.
     * @return formatted string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}


