/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe1;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class POE1 {
    public static void main(String[] args) {
        register registerObj = new register();
        Scanner scanner = new Scanner(System.in);

        // Collect user details
        System.out.print("Enter your Firstname: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your Lastname: ");
        String lastName = scanner.nextLine();

        System.out.print("Create a username: ");
        String username = scanner.nextLine();

        // Validate username
        if (registerObj.checkUserName(username)) {
            System.out.print("Create a password: ");
            String password = scanner.nextLine();

            // Validate password
            if (registerObj.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                registerObj.setUsername(username);
                registerObj.setPassword(password);

                // Attempt login
                boolean isLoginSuccessful = register.loginUser(username, password, registerObj.getUsername(), registerObj.getPassword());
                System.out.println(register.returnLoginStatus(isLoginSuccessful, firstName, lastName));

                if (isLoginSuccessful) {
                    // Switch to task management
                    tasks.manageTasks(firstName + " " + lastName);
                }
            } else {
                System.out.println("Password is not correctly formatted.");
            }
        } else {
            System.out.println("Username is not correctly formatted.");
        }

        scanner.close();
    }
}


     
    

