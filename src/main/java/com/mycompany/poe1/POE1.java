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
        username = sc.next();
        
        // Check if the username is valid
        if (registerObj.checkUserName(username)) {
            System.out.print("Create a password: ");
            password = sc.next();

            // Check the password
            if (registerObj.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                
                // Set the username and password
                registerObj.setUsername(username);
                registerObj.setPassword(password);

                // Attempt to log in with the registered credentials
                boolean isLoginSuccessful = register.loginUser(username, password, registerObj.getUsername(), registerObj.getPassword());
                System.out.println(register.returnLoginStatus(isLoginSuccessful, firstName, lastName));
            } else {
                System.out.println("Password is not correctly formatted. Please ensure that your password contains at least 8 characters, a capital letter, a number, and a special character.");
            }
        } else {
            System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.");
        }

        sc.close();  // Close the scanner
    }
}
     
    

