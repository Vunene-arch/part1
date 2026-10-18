package com.mycompany.part1;
import java.util.Random;

public class Message {
    //declarations
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private static int totalMessages = 0;
    
    //message method that returs
    public Message(String messageID, int messageNumber, String recipient, String messageText) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return messageText; }
     
    public static String createMessageID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) sb.append(rand.nextInt(10));
        return sb.toString();
    }

    public String checkMessageLength() {
        if (messageText.length() <= 250) return "Message ready to send.";
        else return "Message exceeds 250 characters by " + (messageText.length() - 250) + ", please reduce size.";
    }

    public String checkRecipientCell() {
        if (recipient != null && recipient.startsWith("+") && recipient.length() <= 13)
            return "Cell phone number successfully captured.";
        else
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
    }

    public String createMessageHash() {
        try {
            String firstTwo = messageID.substring(0, 2);
            String[] words = messageText.trim().split("\\s+");
            String first = words[0].toUpperCase().replaceAll("[^A-Z0-9]", "");
            String last = words[words.length - 1].toUpperCase().replaceAll("[^A-Z0-9]", "");
            return firstTwo + ":" + messageNumber + ":" + first + last;
        } catch (Exception e) {
            return messageID.substring(0,2) + ":" + messageNumber + ":HASH";
        }
    }

    // message sentMessage
    public String sentMessage() {
        totalMessages++;
        return "Message successfully sent.";
    }

    // message sentMessage(1) and sentMessage(2) and sentMessage(3)
    public String sentMessage(int option) {
        if (option == 1) { totalMessages++; return "Message successfully sent."; }
        if (option == 2) return "Press 0 to delete the message.";
        if (option == 3) { totalMessages++; return "Message successfully stored."; }
        return "Invalid option.";
    }

    public boolean storeMessage() {
        try {
            //  JSON object for this message
            String jsonEntry = String.format(
                "{\"messageID\":\"%s\",\"messageNumber\":%d,\"recipient\":\"%s\",\"messageText\":\"%s\",\"messageHash\":\"%s\"}",
                messageID, messageNumber, recipient, messageText.replace("\"","'"), messageHash
            );
            
            java.io.File file = new java.io.File("storedMessages.json");
            java.io.FileWriter writer;
            
            if (!file.exists() || file.length() == 0) {
                writer = new java.io.FileWriter(file);
                writer.write("[" + jsonEntry + "]");
            } else {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                content = content.trim();
                if (content.endsWith("]")) content = content.substring(0, content.length()-1);
                if (content.length() > 1) content += ",";
                content += jsonEntry + "]";
                writer = new java.io.FileWriter(file);
                writer.write(content);
            }
            writer.close();
            totalMessages++;
            return true;
        } catch (Exception e) {
            System.out.println("Error storing: " + e.getMessage());
            return false;
        }
    }

    public static int returnTotalMessages() { return totalMessages; }
}

