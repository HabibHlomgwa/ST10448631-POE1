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
    static int taskCounter = 1; // Start task numbers from 1
    private static double totalHours = 0; // Accumulator for total task hours
    private String taskName;
    private String taskDescription;
    private String developerName;
    private double duration;
    private String taskID;
    private String taskStatus;

    // Constructor
    public tasks(String taskName, String taskDescription, String developerName, double duration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerName = developerName;
        this.duration = duration;
        this.taskID = createTaskID();
        this.taskStatus = taskStatus;
        totalHours += duration; // Update total hours upon task creation
    }

    public static double getTotalHours() {
        return totalHours;
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

    public static void manageTasks(String developerName) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        int totalTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter?"));
        for (int i = 1; i <= totalTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 chars):");

            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Task description exceeds 50 characters. Try again.");
                i--; // Retry the current task
                continue;
            }

            double duration = Double.parseDouble(JOptionPane.showInputDialog("Enter Task Duration in hours:"));
            String taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do/Doing/Done):");

            tasks newTask = new tasks(taskName, taskDescription, developerName, duration, taskStatus);
            JOptionPane.showMessageDialog(null, "Task Added Successfully:\n" + newTask.printTaskDetails());
        }

        JOptionPane.showMessageDialog(null, "All tasks have been entered. Total hours: " + totalHours);
    }
}
    