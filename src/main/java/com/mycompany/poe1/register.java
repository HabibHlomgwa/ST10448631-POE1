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

    public register() {
        // Default constructor
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkUserName(String username) {
        // Check if username contains "_" and is no more than 5 characters
        return username.contains("_") && username.length() <= 5;
    }

     public boolean checkPasswordComplexity(String password) {
        boolean hasDigit = false;
        boolean hasCapital = false;
        boolean hasSpecial = false;
        boolean isLong = password.length() >= 8;
        String specialCharacters = "+=-_)(*&^%$#@!";

        // Check password for the required conditions
        for (char result : password.toCharArray()) {
            if (Character.isDigit(result)) hasDigit = true;
            if (Character.isUpperCase(result)) hasCapital = true;
            if (specialCharacters.indexOf(result) >= 0) hasSpecial = true;
        }

        return hasDigit && hasCapital && hasSpecial && isLong;
    }