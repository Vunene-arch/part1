/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.part1;

import StoredMessages.StoredMessages;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessagePart3Test {

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        StoredMessages.populateTestData();
        assertEquals("Did you get the cake?", StoredMessages.sentMessages.get(0));
        assertEquals("It is dinner time !", StoredMessages.sentMessages.get(1));
    }

    @Test
    public void testDisplayLongestMessage() {
        StoredMessages.populateTestData();
        assertEquals("Where are you? You are late! I have asked you to be on time.",
                StoredMessages.displayLongestMessage());
    }

    @Test
    public void testSearchByMessageID() {
        StoredMessages.populateTestData();
        String result = StoredMessages.searchByMessageID("0838884567");
        assertTrue(result.contains("It is dinner time !"));
        assertTrue(result.contains("+27838884567"));
    }

    @Test
    public void testSearchMessagesByRecipient() {
        StoredMessages.populateTestData();
        String result = StoredMessages.searchByRecipient("+27838884567");
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(result.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteMessageByHash() {
        StoredMessages.populateTestData();
        String result = StoredMessages.deleteByHash("00:1:TIME");
        assertTrue(result.contains("successfully deleted"));
        assertEquals(1, StoredMessages.storedMessages.size());
    }

    @Test
    public void testDisplayReport() {
        StoredMessages.populateTestData();
        String report = StoredMessages.displayReport();
        assertTrue(report.contains("Message Hash"));
        assertTrue(report.contains("Recipient"));
        assertTrue(report.contains("Where are you? You are late!"));
        assertFalse(report.contains("Did you get the cake?")); // only stored in report
    }
}