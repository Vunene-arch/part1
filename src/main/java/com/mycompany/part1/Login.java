/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1;

/**
 *
 * @author MASONDO VUNENE
 */
class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor
    public Login(String username, String password, String cellPhoneNumber,
                 String firstName, String lastName) {

        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Check username
    public boolean checkUserName() {

        return username.contains("_") && username.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplexity() {

        if (password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                hasCapital = true;
            }

            if (Character.isDigit(character)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(character)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    // Check cellphone number
    public boolean checkCellPhoneNumber() {

        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    // Register user
    public String registerUser() {

        if (!checkUserName()) {

            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";

        } else if (!checkPasswordComplexity()) {

            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

        } else if (!checkCellPhoneNumber()) {

            return "Cell number is incorrectly formatted or does not contain international code; please correct the number and try again.";

        } else {

            return "Registration successful.";
        }
    }

    // Check login details
    public boolean loginUser(String enteredUsername, String enteredPassword) {

        return enteredUsername.equals(username)
                && enteredPassword.equals(password);
    }

    // Return login status
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {

        if (loginUser(enteredUsername, enteredPassword)) {

            return "Welcome " + firstName + " " + lastName
                    + ", it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
        }
    }
}
