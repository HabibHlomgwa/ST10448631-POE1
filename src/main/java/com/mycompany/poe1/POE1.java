/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe1;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class POE1 {
    

    public static void main(String[] args) {
        
        //create object for scanner and call class
        Scanner sc = new Scanner(System.in);
        register registerobj = new register();
        
        //declarations
        String firstname;
        String lastname;
        String user;
        String pass;
        
        //prompt user for their details
        System.out.println("Enter your Firstname: ");
        firstname = sc.next();
        
        System.out.println("Enter your lastname: ");
        lastname = sc.next();
        
        // Check if the username is valid
        boolean isUsernameValid = registerobj.checkUserName(sc);
        String username = "";
        String password = "";

        if (isUsernameValid) {
            // Check the password
            boolean isPasswordValid = registerobj.checkPasswordComplexity(sc);
            if (isPasswordValid) {
                
                // Capture username and password after validation
                // Retrieve captured username
                username = registerobj.getUsername();  
                // Retrieve captured password
                password = registerobj.getPassword();  

                // Collect first and last names for greeting purposes
                System.out.println("Enter First Name: ");
                String firstName = sc.next();

                System.out.println("Enter Last Name: ");
                String lastName = sc.next();

                // Attempt to log in with the registered credentials
                boolean isLoginSuccessful = register.loginUser(sc, username, password, firstName, lastName);

                // Output login result
                if (isLoginSuccessful) {
                    System.out.println("Login was successful.");
                } else {
                    System.out.println("Login failed. Please check your username and password.");
                }
            }
            else {
                System.out.println("Password validation failed.");
            }
        }
        else {
            System.out.println("Username validation failed.");
        }
        
        // Close the scanner
        sc.close();  
    }
    
}
     
    

