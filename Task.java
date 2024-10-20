public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskId;
    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskId, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskId = taskId;
        this.taskStatus = taskStatus;
    }

    // Method to check if task description is <= 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to generate Task ID
    public String createTaskID() {
        taskId = taskName.substring(0, 2).toUpperCase() + ":" +
                 taskNumber + ":" +
                 developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskId;
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskId + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }

    // Static method to return the total combined hours of all tasks
    public static int returnTotalHours(Task[] tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }
}