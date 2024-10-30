/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe1;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class POE1 {
    
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        // Create a Register object 
        register registerObj = new register();

        // Take user details 
        String firstName = JOptionPane.showInputDialog("Enter your Firstname:");
        String lastName = JOptionPane.showInputDialog("Enter your Lastname:");
        
        // Validate username with a while loop
        String username;
        while (true) {
            username = JOptionPane.showInputDialog("Create a username (must include '_' and no more than 5 characters):");
            if (registerObj.checkUserName(username)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username format. Please try again.");
            }
        }
        
        // Validate password with a while loop
        String password;
        while (true) {
            password = JOptionPane.showInputDialog("Create a password (min. 8 chars, include digit, uppercase & special char):");
            if (registerObj.checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "Password successfully captured.");
                registerObj.setUsername(username);
                registerObj.setPassword(password);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please try again.");
            }
        }

        // Attempt login using a while loop to allow retry on failure
        boolean isLoginSuccessful = false;
        while (!isLoginSuccessful) {
            String enteredUsername = JOptionPane.showInputDialog("Enter your username to login:");
            String enteredPassword = JOptionPane.showInputDialog("Enter your password to login:");

            isLoginSuccessful = register.loginUser(enteredUsername, enteredPassword, registerObj.getUsername(), registerObj.getPassword());
            if (!isLoginSuccessful) {
                JOptionPane.showMessageDialog(null, "Username or password validation failed. Please try again.");
            }
        }

        // Login success message and switch to task management
        JOptionPane.showMessageDialog(null, register.returnLoginStatus(isLoginSuccessful, firstName, lastName));
        
        // Call manageTasks in the Tasks class
        tasks.manageTasks(firstName + " " + lastName);
    }
}
     
    

