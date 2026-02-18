/*
Copyright Ann Barcomb, Khawla Shnaikat, and DeepSeek, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InquirerTest {
    
    private String expectedFirstName = "Joseph";
    private String expectedLastName = "Bouillon";
    private String expectedPhoneNumber = "+1-123-456-7890";
    private String expectedMessage = "looking for my family members";
    private Inquirer inquirer = new Inquirer(expectedFirstName, expectedLastName, expectedPhoneNumber, expectedMessage);

    /*
    testConstructorWithValidData -> means testing Inquirer constructor with valid data:
       - What we need: To verify that an "Inquirer" object is successfully created with valid data.
       - Actual result: First name "Joseph", last name "Bouillon", phone "1234564567", message "Looking".
       - Expected Result: The test checks that the Inquirer object has correct values.
    */
    @Test
    public void testConstructorWithValidData() {
        Inquirer testInquirer = new Inquirer("Joseph", "Bouillon", "1234564567", "Looking");
        assertNotNull("Constructor should create an Inquirer object", testInquirer);
        assertEquals("Constructor should set first name correctly", "Joseph", testInquirer.getFirstName());
        assertEquals("Constructor should set last name correctly", "Bouillon", testInquirer.getLastName());
        assertEquals("Constructor should set phone number correctly", "1234564567", testInquirer.getServicesPhoneNum());
        assertEquals("Constructor should set info correctly", "Looking", testInquirer.getInfo());
    }

    @Test
    public void testObjectCreation() {
        assertNotNull(inquirer);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("getFirstName() should return inquirer's first name", expectedFirstName, inquirer.getFirstName());
    }
    
    @Test
    public void testGetLastName() {
        assertEquals("getLastName() should return inquirer's last name", expectedLastName, inquirer.getLastName());
    }
    
    @Test
    public void testGetServicesPhoneNum() {
        assertEquals("getServicesPhoneNum() should return the correct Services Number", expectedPhoneNumber, inquirer.getServicesPhoneNum());
    }
    
    @Test
    public void testGetInfo() {
        assertEquals("getInfo() should return the inquirer message", expectedMessage, inquirer.getInfo());
    }

}
