/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part1;

import java.util.Scanner;

/**
 *
 * @author MASONDO VUNENE
 */
public class Part1 {

    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Registration =====");

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        
        // USERNAME
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        Login user = new Login(
                username,
                "",
                "",
                firstName,
                lastName
        );

        while (!user.checkUserName()) {

            System.out.println(
                    "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length."
            );

            System.out.print("Please enter your username again: ");
            username = scanner.nextLine();

            user = new Login(
                    username,
                    "",
                    "",
                    firstName,
                    lastName
            );
        }

        System.out.println("Username successfully captured.");
        
        // PASSWORD
        System.out.print("Enter password. Password contains at least eight characters, a capital letter, a number, and a special character. ");
        String password = scanner.nextLine();

        user = new Login(
                username,
                password,
                "",
                firstName,
                lastName
        );

        while (!user.checkPasswordComplexity()) {

            System.out.println(
                    "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."
            );

            System.out.print("Please enter your password again: ");
            password = scanner.nextLine();

            user = new Login(
                    username,
                    password,
                    "",
                    firstName,
                    lastName
            );
        }

        System.out.println("Password successfully captured.");
        
        // CELLPHONE NUMBER
        System.out.print("Enter cellphone number: ");
        String cellPhoneNumber = scanner.nextLine();

        user = new Login(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
        );

        while (!user.checkCellPhoneNumber()) {

            System.out.println(
                    "Cell number is incorrectly formatted or does not contain international code; please correct the number and try again."
            );

            System.out.print("Please enter your cellphone number again: ");
            cellPhoneNumber = scanner.nextLine();

            user = new Login(
                    username,
                    password,
                    cellPhoneNumber,
                    firstName,
                    lastName
            );
        }

        System.out.println("Cell phone number successfully added.");

        System.out.println("\nRegistration successful.");

        // LOGIN
        System.out.println("\n===== Login =====");

        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        if (user.loginUser(loginUsername, loginPassword)) {

            System.out.println(
                    user.returnLoginStatus(loginUsername, loginPassword));
        }else{
            System.out.println("Username or password incorrect, please try again.");
        
            System.out.print("Enter username: ");
            loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            loginPassword = scanner.nextLine();
        }

        
        scanner.close();
    }
}

