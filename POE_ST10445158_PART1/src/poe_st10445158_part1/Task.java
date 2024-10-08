
package poe_st10445158_part1;

public class Task {
    public String taskName;
    public String taskDescription;
    public String developerFirstName;
    public String developerLastName;
    public int taskDuration;
    public String taskID;
    public String taskStatus;

    public Task(String taskName, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, String taskID, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    // Getter method for task name
    public String getTaskName() {
        return taskName;
    }

    // Getter method for task description
    public String getTaskDescription() {
        return taskDescription;
    }

    // Getter method for developer first name
    public String getDeveloperFirstName() {
        return developerFirstName;
    }

    // Getter method for developer last name
    public String getDeveloperLastName() {
        return developerLastName;
    }

    // Getter method for task duration
    public int getTaskDuration() {
        return taskDuration;
    }

    // Getter method for task ID
    public String getTaskID() {
        return taskID;
    }

    // Getter method for task status
    public String getTaskStatus() {
        return taskStatus;
    }

}