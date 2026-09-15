/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testCheckUserNameCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&d$ec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        assertTrue(user.checkUserName());
    }

    @Test
    public void testCheckUserNameIncorrect() {
        Login user = new Login(
                "kyle123",
                "Ch&d$ec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        assertFalse(user.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexityCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&d$ec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityIncorrect() {
        Login user = new Login(
                "kyl_1",
                "password",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumberCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&d$ec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&d$ec@ke99!",
                "08966553",
                "Kyle",
                "Smith"
        );

        assertFalse(user.checkCellPhoneNumber());
    }

    @Test
    public void testLoginCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&d$ec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        assertTrue(
                user.loginUser("kyl_1", "Ch&d$ec@ke99!")
        );
    }

    @Test
    public void testLoginIncorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&d$ec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        assertFalse(
                user.loginUser("wrong", "password")
        );
    }

    @Test
    public void testReturnLoginStatusCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&d$ec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        String expected =
                "Welcome Kyle Smith, it is great to see you again.";

        assertEquals(
                expected,
                user.returnLoginStatus("kyl_1", "Ch&d$ec@ke99!")
        );
    }

    @Test
    public void testReturnLoginStatusIncorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&d$ec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );

        String expected =
                "Username or password incorrect, please try again.";

        assertEquals(
                expected,
                user.returnLoginStatus("wrong", "wrong")
        );
    }
}