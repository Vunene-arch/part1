/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MASONDO VUNENE
 */
public class MessageTest {
    
    @Test
    public void testMessageLength_Success() {
        Message msg = new Message("0012345678", 0, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        assertEquals("Message ready to send.", msg.checkMessageLength());
    }
    @Test
    public void testMessageLength_Failure() {
        String longMsg = "a".repeat(260);
        Message msg = new Message("0012345678", 0, "+27718693002", longMsg);
        assertEquals("Message exceeds 250 characters by 10, please reduce the size.", msg.checkMessageLength());
    }
    @Test
    public void testRecipient_Success() {
        Message msg = new Message("1234567890", 0, "+27718693002", "Hi Mike");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }
    @Test
    public void testRecipient_Failure() {
        Message msg = new Message("1234567890", 1, "08575075889", "Hi Keegan");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg.checkRecipientCell());
    }
    @Test
    public void testMessageHash_Correct() {
        Message msg = new Message("0012345678", 0, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        assertEquals("00:0:HITONIGHT", msg.createMessageHash());
    }
    @Test
    public void testMessageID_Generated() {
        String id = Message.createMessageID();
        assertEquals(10, id.length());
    }
    @Test
    public void testSentMessage_Options() {
        Message msg = new Message("0012345678", 0, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        assertEquals("Message successfully sent.", msg.sentMessage(1));
        assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
        assertEquals("Message successfully stored.", msg.sentMessage(3));
    }
    @Test
    public void testReturnTotal() {
        int before = Message.returnTotalMessages();
        Message m = new Message("0012345678", 2, "+27718693002", "Test");
        m.sentMessage(1);
        assertEquals(before + 1, Message.returnTotalMessages());
    }
    
    }
    
