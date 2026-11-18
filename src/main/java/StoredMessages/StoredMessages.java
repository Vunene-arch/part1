/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoredMessages;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MASONDO VUNENE
 */
public class StoredMessages {
    // ARRAYS
    public static ArrayList<String> sentMessages = new ArrayList<>();
    public static ArrayList<String> disregardedMessages = new ArrayList<>();
    public static ArrayList<String> storedMessages = new ArrayList<>();
    public static ArrayList<String> messageHashes = new ArrayList<>();
    public static ArrayList<String> messageIDs = new ArrayList<>();
    public static ArrayList<String> recipients = new ArrayList<>();
    public static ArrayList<String> senders = new ArrayList<>();
    public static ArrayList<String> allMessages = new ArrayList<>();
    public static ArrayList<Integer> flags = new ArrayList<>(); // 1=Sent, 2=Disregarded, 3=Stored

    public static void clearAll() {
        sentMessages.clear(); disregardedMessages.clear(); storedMessages.clear();
        messageHashes.clear(); messageIDs.clear(); recipients.clear();
        senders.clear(); allMessages.clear(); flags.clear();
    }

    // flag: 1 = Sent, 2 = Disregarded, 3 = Stored
    public static void addMessage(String sender, String recipient, String message, String hash, String id, int flag) {
        allMessages.add(message);
        senders.add(sender);
        recipients.add(recipient);
        messageHashes.add(hash);
        messageIDs.add(id);
        flags.add(flag);
        if (flag == 1) sentMessages.add(message);
        else if (flag == 2) disregardedMessages.add(message);
        else if (flag == 3) storedMessages.add(message);
    }

    // Display sender and recipient of all STORED messages
    public static String displaySenderAndRecipient() {
        StringBuilder sb = new StringBuilder("--- STORED MESSAGES: SENDER & RECIPIENT ---\n");
        for (int i = 0; i < allMessages.size(); i++) {
            if (flags.get(i) == 3) {
                sb.append("Sender: ").append(senders.get(i))
                  .append(" | Recipient: ").append(recipients.get(i))
                  .append(" | Message: ").append(allMessages.get(i)).append("\n");
            }
        }
        return sb.toString();
    }

    // Display longest STORED message
    public static String displayLongestMessage() {
        if (storedMessages.isEmpty()) return "No stored messages.";
        String longest = storedMessages.get(0);
        for (String m : storedMessages) {
            if (m.length() > longest.length()) longest = m;
        }
        return longest;
    }

    // Search by Message ID
    public static String searchByMessageID(String searchID) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(searchID)) {
                return "Recipient: " + recipients.get(i) + "\nMessage: " + allMessages.get(i);
            }
        }
        return "Message ID not found.";
    }

    // Search STORED messages by recipient
    public static String searchByRecipient(String searchRecipient) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < allMessages.size(); i++) {
            if (recipients.get(i).equals(searchRecipient) && flags.get(i) == 3) {
                sb.append(allMessages.get(i)).append("\n");
            }
        }
        if (sb.length() == 0) return "No stored messages found for this recipient.";
        return sb.toString().trim();
    }

    // Delete by Message Hash
    public static String deleteByHash(String hashToDelete) {
        for (int i = 0; i < messageHashes.size(); i++) {
            if (messageHashes.get(i).equals(hashToDelete)) {
                String deletedMsg = allMessages.get(i);
                if (flags.get(i) == 1) sentMessages.remove(deletedMsg);
                else if (flags.get(i) == 2) disregardedMessages.remove(deletedMsg);
                else if (flags.get(i) == 3) storedMessages.remove(deletedMsg);

                allMessages.remove(i); senders.remove(i); recipients.remove(i);
                messageHashes.remove(i); messageIDs.remove(i); flags.remove(i);
                return "Message: \"" + deletedMsg + "\" successfully deleted.";
            }
        }
        return "Hash not found.";
    }

    // f. Display Report - full details of all STORED messages
    public static String displayReport() {
        StringBuilder sb = new StringBuilder("--- MESSAGE REPORT ---\n");
        for (int i = 0; i < allMessages.size(); i++) {
            if (flags.get(i) == 3) {
                sb.append("Message Hash: ").append(messageHashes.get(i)).append("\n")
                  .append("Recipient: ").append(recipients.get(i)).append("\n")
                  .append("Message: ").append(allMessages.get(i)).append("\n\n");
            }
        }
        return sb.toString();
    }

    // Test data 
    public static void populateTestData() {
        clearAll();
        addMessage("Developer", "+27834557896", "Did you get the cake?", "00:0:CAKE", "001", 1);
        addMessage("Developer", "+27838884567", "Where are you? You are late! I have asked you to be on time.", "00:1:TIME", "002", 3);
        addMessage("Developer", "+27834484567", "Yohoooo, I am at your gate.", "00:2:GATE", "003", 2);
        addMessage("Developer", "+27838884567", "It is dinner time !", "00:3:TIME", "0838884567", 1);
        addMessage("Developer", "+27838884567", "Ok, I am leaving without you.", "00:4:YOU", "005", 3);
    }

    //  Menu
    public static void showStoredMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Stored Messages Menu ---");
            System.out.println("a. Display Sender & Recipient of Stored Messages");
            System.out.println("b. Display Longest Stored Message");
            System.out.println("c. Search by Message ID");
            System.out.println("d. Search Stored Messages by Recipient");
            System.out.println("e. Delete Message by Hash");
            System.out.println("f. Display Report");
            System.out.println("g. Back");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "a": System.out.println(displaySenderAndRecipient()); break;
                case "b": System.out.println("Longest Stored Message:\n" + displayLongestMessage()); break;
                case "c":
                    System.out.print("Enter Message ID: ");
                    System.out.println(searchByMessageID(scanner.nextLine()));
                    break;
                case "d":
                    System.out.print("Enter Recipient (e.g. +27838884567): ");
                    System.out.println(searchByRecipient(scanner.nextLine()));
                    break;
                case "e":
                    System.out.print("Enter Message Hash to delete: ");
                    System.out.println(deleteByHash(scanner.nextLine()));
                    break;
                case "f": System.out.println(displayReport()); break;
                case "g": back = true; break;
                default: System.out.println("Invalid option."); break;
            }
        }
    }
}
