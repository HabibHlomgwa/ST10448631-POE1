/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1;
import javax.swing.JOptionPane;


/**
 *
 * @author RC_Student_lab
 */
public class tasks {
    
      static int taskCounter = 0; // Counter for task number
    private static double totalHours = 0; // Accumulator for total task hours
    private static int totalTasks; // Total number of tasks to enter

    // Task management logic with JOptionPane interactions
    public static void manageTasks(String developerName) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Set number of tasks to enter using JOptionPane
        String totalTasksInput = JOptionPane.showInputDialog("How many tasks would you like to enter?");
        totalTasks = Integer.parseInt(totalTasksInput); // Assumes valid input for simplicity
        int tasksAdded = 0;

        while (tasksAdded < totalTasks) {
            String choice = JOptionPane.showInputDialog("Choose an option:\n1) Add tasks\n2) Show report\n3) Quit");

            switch (choice) {
                case "1":
                    addTask(developerName);
                    tasksAdded++;
                    break;
                case "2":
                    showReport();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting application.");
                    return; // Exit the loop
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }

        // Show total hours after all tasks have been added
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    private static void addTask(String developerName) {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskDescription;

        // Loop for task description validation
        while (true) {
            taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 chars):");
            // Check task description length
            if (taskDescription.length() <= 50) {
                break; // Exit the loop if valid
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            }
        }
        
        double duration = -1; // Initialize to an invalid value
        // Loop for task duration validation
        while (duration < 0) {
            String durationInput = JOptionPane.showInputDialog("Enter Task Duration in hours:");
            
            // Check if input is a valid number
            if (durationInput != null && !durationInput.isEmpty()) {
                // Attempt to parse the input to double
                duration = Double.parseDouble(durationInput); // Directly parse, will fail if not valid
                if (duration < 0) {
                    JOptionPane.showMessageDialog(null, "Duration cannot be negative. Please enter a valid duration.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input for duration. Please enter a number.");
            }
        }

        String taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do/Doing/Done):");

        // Create Task and update total hours
        tasks newTask = new tasks(taskName, taskDescription, developerName, duration, taskStatus);
        totalHours += duration;
        JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
    }

    private static void showReport() {
        JOptionPane.showMessageDialog(null, "Report feature coming soon.");
    }

    // Task constructor and Task ID logic
    private String taskName;
    private String taskDescription;
    private String developerName;
    private double duration;
    private String taskID;
    private String taskStatus;

    public tasks(String taskName, String taskDescription, String developerName, double duration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerName = developerName;
        this.duration = duration;
        this.taskID = createTaskID();
        this.taskStatus = taskStatus;
    }

    public String createTaskID() {
        String initials = taskName.substring(0, 2).toUpperCase();
        String lastThree = developerName.length() > 3 ? developerName.substring(developerName.length() - 3).toUpperCase() : developerName.toUpperCase();
        return initials + ":" + taskCounter++ + ":" + lastThree;
    }

    public String printTaskDetails() {
        return String.format("Task Status: %s\nDeveloper Details: %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nDuration: %.2f hours",
                taskStatus, developerName, taskCounter, taskName, taskDescription, taskID, duration);
    }
}
            
    