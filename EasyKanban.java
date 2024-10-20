/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package easykanban;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class EasyKanban {
    static class Task {
        String taskName;
        int taskNumber;
        String taskDescription;
        String developerDetails;
        int taskDuration;
        String taskId;
        String taskStatus;

        public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskId, String taskStatus) {
            this.taskName = taskName;
            this.taskNumber = taskNumber;
            this.taskDescription = taskDescription;
            this.developerDetails = developerDetails;
            this.taskDuration = taskDuration;
            this.taskId = taskId;
            this.taskStatus = taskStatus;
        }

        @Override
        public String toString() {
            return "Task Status: " + taskStatus + "\n" +
                    "Developer Details: " + developerDetails + "\n" +
                    "Task Number: " + taskNumber + "\n" +
                    "Task Name: " + taskName + "\n" +
                    "Task Description: " + taskDescription + "\n" +
                    "Task ID: " + taskId + "\n" +
                    "Task Duration: " + taskDuration + " hours";
        }
    }

    static int taskCounter = 0;
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        boolean running = true;

        while (running) {
            String input = JOptionPane.showInputDialog("Please choose an option:\n" +
                    "1. Add tasks\n" +
                    "2. Show report\n" +
                    "3. Quit");

            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    addTasks();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    break;
            }
        }
    }

    public static void addTasks() {
        String taskCountInput = JOptionPane.showInputDialog("How many tasks would you like to add?");
        int taskCount = Integer.parseInt(taskCountInput);

        for (int i = 0; i < taskCount; i++) {
            String taskName = JOptionPane.showInputDialog("Enter the task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter a task description (max 50 characters):");
            
            while (taskDescription.length() > 50) {
                taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters:");
            }

            String developerDetails = JOptionPane.showInputDialog("Enter the developer's first and last name:");
            String taskDurationInput = JOptionPane.showInputDialog("Enter the estimated duration of the task (in hours):");
            int taskDuration = Integer.parseInt(taskDurationInput);

            String[] statusOptions = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status",
                    JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

            String taskId = generateTaskId(taskName, developerDetails, taskCounter);

            Task task = new Task(taskName, taskCounter++, taskDescription, developerDetails, taskDuration, taskId, taskStatus);
            tasks.add(task);

            JOptionPane.showMessageDialog(null, "Task successfully captured:\n" + task);
        }
    }

    public static String generateTaskId(String taskName, String developerName, int taskNumber) {
        String taskId = taskName.substring(0, 2).toUpperCase() + ":" +
                        taskNumber + ":" +
                        developerName.substring(developerName.length() - 3).toUpperCase();
        return taskId;
    }
} 

