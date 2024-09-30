/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1;
import java.util.*;

/**
 *
 * @author RC_Student_lab
 */
public class register {
    
    private String username;
    private String password;
    
    //makes sure username contains underscore "_".
    public boolean checkUserName(Scanner sc) {
        
        //prompt user for username
        System.out.println("Create your username: ");
        username = sc.next();

        // Check if username contains "_" and is no more than 5 characters
        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured.");
            return true;
        } 
        
        else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }
        
    }
    
    public boolean checkPasswordComplexity( Scanner sc) {
        System.out.println("Create your password:");
        password = sc.next();

        boolean hasDigit = false;
        boolean hasCapital = false;
        boolean hasSpecial = false;
        boolean isLong = password.length() >= 8;

        String specialCharacters = "+=-_)(*&^%$#@!";

        // Check password for the required conditions
        for (int i = 0; i < password.length(); i++) {
            char result = password.charAt(i);
            
            if (Character.isDigit(result)) {
                hasDigit = true;
            }
            
            if (Character.isUpperCase(result)) {
                hasCapital = true;
            }
            
            if (specialCharacters.indexOf(result) >= 0) {
                hasSpecial = true;
            }
        }

        if (hasDigit && hasCapital && hasSpecial && isLong) {
            System.out.println("Password successfully captured.");
            return true;
        }
        
        else {
            System.out.println("Password is not formatted correctly. Please ensure that the password contains at least 8 characters, a capital letter, a special character, and a number.");
            return false;
        }
        
    }
    
     public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
     public static boolean loginUser(Scanner sc, String storedUsername, String storedPassword, String firstName, String lastName) {
        System.out.println("Please enter your username for login: ");
        String enteredUsername = sc.next();

        System.out.println("Please enter your password for login: ");
        String enteredPassword = sc.next();
        
        //display results
        if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
            // if login is successful
            System.out.println("Welcome " + firstName + " " + lastName + ", It is great to see you again!");
            return true;  
        }
        
        else {
            // if login failed
            System.out.println("Username or password validation failed.");
            return false;  
        }
    }
    
    
    
}
