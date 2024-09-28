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
        //call methods
        checkusername();
       //declaration
        String firstname;
        String lastname;
        String user;
        String pass;
        
        //create object for scanner
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("Enter your name: ");
        firstname = sc.next();
        
        System.out.println("Enter your lastname: ");
        lastname = sc.next();
       
        
    }
    
    public static boolean checkusername(){
        String username;
                    Scanner sc = new Scanner(System.in);
                    
        System.out.println("Create a username: ");
        username = sc.next();
      
    if(username.contains("_") && username.length() <=5){
         System.out.println("username");
         //return username.contains("_") && username.length() <=5;
    }
        
    
    else {
    System.out.println("Username is not correctly formatted, please ensure that your usename contains an underscore and is no more than 5 characters in length");
    }
    
    
        return false;
    
    }

    
}
