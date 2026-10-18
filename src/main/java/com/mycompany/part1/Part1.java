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

        //SCANNER FOT USER INPUTS
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Registration =====");
        
        //PROMPT THE USER TO ENTER THEIR FIRST AND LAST NAME
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        
        // USERNAME
        System.out.print("Enter username. Username must contain an underscore and not more than five characters. ");
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
        System.out.print("Enter cellphone number. The cellphone number contains international counrty code followed by a number, which is no more than ten charecters long. ");
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
                    user.returnLoginStatus(loginUsername, loginPassword)
            );
             runQuickChat(scanner);       
        }else{
            System.out.println("Username or password incorrect, please try again.");
        
            System.out.print("Enter username: ");
            loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            loginPassword = scanner.nextLine();
        }

        
        scanner.close();
    }
    public static void runQuickChat(Scanner scanner) {

    System.out.println("\nWelcome to QuickChat.");

    System.out.print("How many messages do you want to enter? ");
    int numberOfMessages = Integer.parseInt(scanner.nextLine());

    while (numberOfMessages < 1) {

        System.out.print("Please enter at least 1 message: ");
        numberOfMessages = Integer.parseInt(scanner.nextLine());
    }

    int messagesProcessed = 0;
    boolean running = true;

    while (running) {

        System.out.println("\n===== QuickChat Menu =====");
        System.out.println("1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Quit");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {

            if (messagesProcessed < numberOfMessages) {

                processMessage(scanner, messagesProcessed);
                messagesProcessed++;

            } else {

                System.out.println(
                        "You have entered the number of messages selected."
                );
            }

        } else if (choice.equals("2")) {

            System.out.println("Coming Soon.");

        } else if (choice.equals("3")) {

            running = false;
            System.out.println("Thank you for using QuickChat.");

        } else {

            System.out.println(
                    "Invalid option. Please select 1, 2 or 3."
            );
        }
    }
}
    public static void processMessage(Scanner scanner, int messageNumber) {

    String messageID = Message.createMessageID();

    System.out.print("Enter recipient cellphone number (+27XXXXXXXXX): ");
    String recipient = scanner.nextLine();

    System.out.print("Enter your message: ");
    String messageText = scanner.nextLine();

    Message message = new Message(
            messageID,
            messageNumber + 1,
            recipient,
            messageText
    );

    while (!message.checkRecipientCell().equals(
            "Cell phone number successfully captured.")) {

        System.out.println(message.checkRecipientCell());

        System.out.print("Enter recipient cellphone number again: ");
        recipient = scanner.nextLine();

        message = new Message(
                messageID,
                messageNumber + 1,
                recipient,
                messageText
        );
    }

    System.out.println(message.checkRecipientCell());

    while (!message.checkMessageLength().equals(
            "Message ready to send.")) {

        System.out.println(message.checkMessageLength());

        System.out.print("Enter a shorter message: ");
        messageText = scanner.nextLine();

        message = new Message(
                messageID,
                messageNumber + 1,
                recipient,
                messageText
        );
    }

    System.out.println("\nMessage ID: " + message.getMessageID());
    System.out.println("Message Hash: " + message.getMessageHash());
    System.out.println("Recipient: " + message.getRecipient());
    System.out.println("Message: " + message.getMessage());

    System.out.println("\n1) Send Message");
    System.out.println("0) Disregard Message");
    System.out.println("2) Store Message to send later");
    System.out.print("Choose an option: ");

    String action = scanner.nextLine();

    if (action.equals("1")) {

        System.out.println(message.sentMessage());

    } else if (action.equals("0")) {

        System.out.println("Message disregarded.");

    } else if (action.equals("2")) {

    if (action.equals("1")) {
    System.out.println(message.sentMessage(1));
    System.out.println("Message ID: " + message.getMessageID());
    System.out.println("Message Hash: " + message.getMessageHash());
    System.out.println("Recipient: " + message.getRecipient());
    System.out.println("Message: " + message.getMessage());
} else if (action.equals("0")) {
    System.out.println(message.sentMessage(2));
    System.out.println("Message disregarded.");
} else if (action.equals("2")) {
    if (message.storeMessage()) {
        System.out.println(message.sentMessage(3));
    } else {
        System.out.println("Message could not be stored.");
    }
} else {
    System.out.println("Invalid option. Message not sent.");

    }
    }
    }
}
