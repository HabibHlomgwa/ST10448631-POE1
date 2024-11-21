/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author RC_Student_lab
 */


public class tasksTest {
    private tasks task;

    @BeforeAll
    public static void initAll() {
        System.out.println("Starting Tasks tests...");
    }

    @BeforeEach
    public void setUp() {
        tasks.taskCounter = 1; // Reset taskCounter
        task = new tasks("Task1", "This is a test task", "John Doe", 5.0, "To Do");
    }

    @AfterEach
    public void tearDown() {
        task = null;
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Finished Tasks tests.");
    }

    @Test
    public void testAddTask() {
        assertEquals(5.0, tasks.getTotalHours(), 0.01); // Check initial total hours
        tasks newTask = new tasks("Task2", "Another test task", "Jane Doe", 3.0, "Doing");
        assertEquals(8.0, tasks.getTotalHours(), 0.01); // Verify updated total hours
    }

    @Test
    public void testCreateTaskID() {
        String taskID = task.createTaskID();
        assertTrue(taskID.startsWith("TA")); // Ensure Task ID starts correctly
        assertTrue(taskID.contains("DOE")); // Check last three characters of developer name
    }

    @Test
    public void testTaskDetails() {
        String details = task.printTaskDetails();
        assertTrue(details.contains("Task1"));
        assertTrue(details.contains("This is a test task"));
        assertTrue(details.contains("5.00"));
    }

    @Test
    public void testMultipleTasks() {
        tasks task1 = new tasks("Task1", "Test Task 1", "Jane Doe", 2.0, "Doing");
        tasks task2 = new tasks("Task2", "Test Task 2", "Jane Doe", 4.0, "Done");
        assertEquals(6.0, tasks.getTotalHours(), 0.01);
    }
}


