/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author RC_Student_lab
 */
public class tasks {
    private int totalHours = 0; // To track the total hours of all tasks
    private int taskCount = -1;  // For TaskID generation and task number
    private int maxTasks;       // Maximum number of tasks user wishes to enter

    private ArrayList<tasks> tasksList = new ArrayList<>();

    public tasks() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        boolean continueProgram = true;

        // Menu loop
        while (continueProgram) {
            String choice = JOptionPane.showInputDialog(null, "Select an option:\n1) Add Tasks\n2) Show Report \n3) Quit");

            try {
                int option = Integer.parseInt(choice);

                switch (option) {
                    case 1:
                        // Ask for the number of tasks when the user selects "Add Tasks"
                        maxTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
                        addtasks();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case 3:
                        quit();
                        continueProgram = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid number.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }
        
        // Method to add tasks based on the user-defined task limit
    public void addtasks() {
        for (int i = 0; i < maxTasks; i++) {
            // Increment task count at the start of each new task entry
            taskCount++;

            String taskName = JOptionPane.showInputDialog("Enter the task name:");
            String taskDescription;

            // Task Description
            do  {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
            } while (!checktaskdescription(taskDescription));

            String developerDetails = JOptionPane.showInputDialog("Enter developer's first and last name:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
            String taskStatus = JOptionPane.showInputDialog("Select task status:\n1) To Do\n2) Doing\n3) Done");

            // Increment task count for ID generation
            taskCount++;
            String taskID = createtaskiD(taskName, taskCount, developerDetails);

            // Add task to the list
            addtask(taskName, taskDescription, developerDetails, taskDuration, taskStatus);

            // Display the details of the added task
            JOptionPane.showMessageDialog(null, gettaskdetailsByIndex(taskCount - 1));
        }

        // Show total hours once all tasks are entered
        JOptionPane.showMessageDialog(null, "Total hours of all tasks: " + returntotalHours() + " hours");
    }
    public void addTasks(){
        
    }
    
     public boolean checkTaskDescription(String description){
         
     }
     
     public String createTaskID(String taskName, int taskNumber, String developer){
         
     }
     
    public String getTaskDetailsByIndex(int taskIndex){
        
    }
            
    