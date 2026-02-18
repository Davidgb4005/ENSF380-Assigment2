/*
Copyright Ann Barcomb, Khawla Shnaikat, and DeepSeek, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MedicalRecordTest {

    Location expectedLocation = new Location("ShelterA", "140 8 Ave NW ");
    private String expectedTreatmentDetails = "Broken arm treated";
    private LocalDate expectedDateOfTreatment = LocalDate.parse("2025-01-19");
    private LocalDate validDateOfTreatment = LocalDate.parse("2025-02-04");
    MedicalRecord medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails, expectedDateOfTreatment);

    @Test
    public void testObjectCreation() {
        assertNotNull(medicalRecord);
    }    
    
    /*
    testConstructorWithValidData -> means testing MedicalRecord constructor with valid data:
       - What we need: To verify that a "MedicalRecord" object is successfully created with valid data.
       - Actual result: Location, treatment details "Broken arm", and date "2025-12-15".
       - Expected Result: The test checks that the MedicalRecord object is not null and has correct values.
    */
    @Test
    public void testConstructorWithValidData() {
        Location location = new Location("Some Shelter", "123 Address");
        LocalDate date = LocalDate.parse("2025-12-15");
        MedicalRecord record = new MedicalRecord(location, "Broken arm", date);
        assertNotNull("Constructor should create a MedicalRecord", record);
        assertEquals("Constructor should set location correctly", location, record.getLocation());
        assertEquals("Constructor should set treatment details correctly", "Broken arm", record.getTreatmentDetails());
        assertEquals("Constructor should set date correctly", date, record.getDateOfTreatment());
    }

    @Test
    public void testGetLocation() {
        assertEquals("getLocation should return the correct Location", expectedLocation, medicalRecord.getLocation());
    }

    @Test
    public void testSetLocation() {
        Location newExpectedLocation = new Location("Shelter B", "150 8 Ave NW ");
        medicalRecord.setLocation(newExpectedLocation);
        assertEquals("setLocation should update the Location", newExpectedLocation.getName(), medicalRecord.getLocation().getName());
    }

    @Test
    public void testGetTreatmentDetails() {
        assertEquals("getTreatmentDetails should return the correct treatment details", expectedTreatmentDetails, medicalRecord.getTreatmentDetails());
    }
    
    @Test
    public void testSetTreatmentDetails() {
        String newExpectedTreatment = "No surgery required";
        medicalRecord.setTreatmentDetails(newExpectedTreatment);
        assertEquals("setTreatmentDetails should update the treatment details", newExpectedTreatment, medicalRecord.getTreatmentDetails());
    }

    @Test
    public void testGetDateOfTreatment() {
        assertEquals("getDateOfTreatment should return the correct date of treatment", expectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }
    
    @Test
    public void testSetDateOfTreatment() {
        LocalDate newExpectedDateOfTreatment = LocalDate.parse("2025-02-05");
        medicalRecord.setDateOfTreatment(newExpectedDateOfTreatment);
        assertEquals("setDateOfTreatment should update date of treatment", newExpectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }

    /*
    testSetDateOfTreatmentWithFutureDate -> means testing setDateOfTreatment with a future date:
       - What we need: To verify that setting a treatment date in the future throws an exception.
       - Actual result: Treatment date "2041-01-01" is in the future.
       - Expected Result: The method should throw IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfTreatmentWithFutureDate() {
        LocalDate futureDate = LocalDate.parse("2041-01-01");
        medicalRecord.setDateOfTreatment(futureDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfTreatmentWithNullDate() {
        medicalRecord.setDateOfTreatment(null);
    }
}
