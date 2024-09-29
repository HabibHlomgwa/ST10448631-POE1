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
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }
    }
    
}
