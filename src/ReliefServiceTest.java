/*
Copyright Ann Barcomb, Khawla Shnaikat, and DeepSeek, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReliefServiceTest {
    private ReliefService reliefService;
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private LocalDate validDate = LocalDate.parse("2025-02-10");
    private String expectedInfoProvided = "Looking for family member";
    private String expectedLogDetails = "Inquirer: John, Missing Person: Jane Alex, Date of Inquiry: 2025-02-10, Info Provided: Looking for family member, Last Known Location: University of Calgary"; 

    @Before
    public void setUp() {
        inquirer = new Inquirer("John", "Alex", "1234567890", "Looking for family member");
        missingPerson = new DisasterVictim("Jane Alex", LocalDate.parse("2025-01-25"));
        lastKnownLocation = new Location("University of Calgary", "2500 University Dr NW");
        reliefService = new ReliefService(inquirer, missingPerson, validDate, expectedInfoProvided, lastKnownLocation);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("ReliefService object should not be null", reliefService);
    }

    /*
    testConstructorWithValidData -> means testing ReliefService constructor with valid data:
       - What we need: To verify that a "ReliefService" object is successfully created with valid data.
       - Actual result: Inquirer, DisasterVictim, date "2025-02-10", info, and Location.
       - Expected Result: The test checks that the ReliefService object is not null and has correct values.
    */
    @Test
    public void testConstructorWithValidData() {
        Inquirer inq = new Inquirer("Test", "Inquirer", "1234567890", "Looking");
        DisasterVictim victim = new DisasterVictim("Test Victim", LocalDate.parse("2025-01-01"));
        Location loc = new Location("Test Location", "123 Test St");
        LocalDate date = LocalDate.parse("2025-02-10");
        
        ReliefService service = new ReliefService(inq, victim, date, "Info", loc);
        assertNotNull("Constructor should create ReliefService", service);
        assertEquals("Constructor should set inquirer correctly", inq, service.getInquirer());
        assertEquals("Constructor should set missing person correctly", victim, service.getMissingPerson());
        assertEquals("Constructor should set date correctly", date, service.getDateOfInquiry());
    }

    @Test
    public void testGetInquirer() {
        assertEquals("Inquirer should match the one set in setup", inquirer, reliefService.getInquirer());
    }

    @Test
    public void testGetMissingPerson() {
        assertEquals("Missing person should match the one set in setup", missingPerson, reliefService.getMissingPerson());
    }

    @Test
    public void testGetDateOfInquiry() {
        assertEquals("Date of inquiry should match the one set in setup", validDate, reliefService.getDateOfInquiry());
    }

    @Test
    public void testGetInfoProvided() {
        assertEquals("Info provided should match the one set in setup", expectedInfoProvided, reliefService.getInfoProvided());
    }

    @Test
    public void testGetLastKnownLocation() {
        assertEquals("Last known location should match the one set in setup", lastKnownLocation, reliefService.getLastKnownLocation());
    }

    @Test
    public void testSetDateOfInquiryWithValidDate() {
        LocalDate newDate = LocalDate.parse("2025-03-01");
        reliefService.setDateOfInquiry(newDate);
        assertEquals("Setting a valid date should update the date of inquiry", newDate, reliefService.getDateOfInquiry());
    }

    /*
    testSetDateOfInquiryWithFutureDate -> means testing setDateOfInquiry with a future date:
       - What we need: To verify that setting an inquiry date in the future throws an exception.
       - Actual result: Inquiry date "2100-12-12" is in the future.
       - Expected Result: The method should throw IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfInquiryWithFutureDate() {
        LocalDate futureDate = LocalDate.parse("2100-12-12");
        reliefService.setDateOfInquiry(futureDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfInquiryWithNullDate() {
        reliefService.setDateOfInquiry(null);
    }

    @Test
    public void testGetLogDetails() {
        assertEquals("Log details should match the expected format", expectedLogDetails, reliefService.getLogDetails());
    }
}
