/*
Copyright Ann Barcomb, Khawla Shnaikat, and DeepSeek, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private Supply[] suppliesToSet; 
    private FamilyRelation[] familyRelations; 
    private String expectedFirstName = "Freda";
    private LocalDate EXPECTED_ENTRY_DATE = LocalDate.parse("2025-01-18");
    private LocalDate validDate = LocalDate.parse("2025-01-15");
    private String expectedComments = "Needs medical attention and speaks 2 languages";

    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new Supply[2];
        suppliesToSet[0] = new Supply("Water Bottle", 10);
        suppliesToSet[1] = new Supply("Blanket", 5);
    }

    /*
    testConstructorWithValidData -> means testing DisasterVictim constructor with valid entry date:
       - What we need: To verify that a "DisasterVictim" object is successfully created with a valid entry date.
       - Actual result: DisasterVictim with name "Alice" and entry date "2025-01-18".
       - Expected Result: The test checks that the DisasterVictim object is not null and has the correct entry date.
    */
    @Test
    public void testConstructorWithValidData() {
        LocalDate validEntryDate = LocalDate.parse("2025-01-18");
        DisasterVictim victim = new DisasterVictim("Alice", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    /*
    testSetDateOfBirthWithFutureDate -> means testing setDateOfBirth with a future date:
       - What we need: To verify that setting a birthdate in the future throws an exception.
       - Actual result: Birthdate "2200-02-05" is in the future.
       - Expected Result: The method should throw IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithFutureDate() {
        LocalDate futureDate = LocalDate.parse("2200-02-05");
        victim.setDateOfBirth(futureDate);
    }

    @Test
    public void testSetDateOfBirth() {
        LocalDate newDateOfBirth = LocalDate.parse("1987-05-21");
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    @Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, victim.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName, victim.getLastName());
    }

    /*
    testSetCommentsWithValidData -> means testing setComments with valid comment:
       - What we need: To verify that comments can be set and retrieved correctly.
       - Actual result: Comment "this is a comment".
       - Expected Result: getComments should return the same comment that was set.
    */
    @Test
    public void testSetCommentsWithValidData() {
        String comment = "this is a comment";
        victim.setComments(comment);
        assertEquals("setComments should update the comments correctly", comment, victim.getComments());
    }

    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }

    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }

    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }

    /*
     * Gender tests follow the 2026 Canada census design:
     * - Valid options: "Man", "Woman", "Boy", "Girl"
     * - Age validation: "Man"/"Woman" for adults (18+), "Boy"/"Girl" for children (<18)
     * - "Please specify" option allows any free-form text and bypasses age validation
     * - All options are case-insensitive and normalized to proper case
     */
    
    /*
    testSetGenderManForAdult -> means testing setGender with "Man" for an adult:
       - What we need: To verify that "Man" can be set for someone 18+ years old.
       - Actual result: Birthdate "2000-01-01" (adult), gender "Man".
       - Expected Result: getGender should return "Man".
    */
    @Test
    public void testSetGenderManForAdult() {
        LocalDate adultBirthdate = LocalDate.parse("2000-01-01");
        victim.setDateOfBirth(adultBirthdate);
        victim.setGender("Man");
        assertEquals("setGender should accept 'Man' for adults", "Man", victim.getGender());
    }

    /*
    testSetGenderManForChildInvalid -> means testing setGender with "Man" for a child:
       - What we need: To verify that "Man" cannot be set for someone under 18 years old.
       - Actual result: Birthdate "2015-01-01" (child), gender "Man".
       - Expected Result: The method should throw IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testSetGenderManForChildInvalid() {
        LocalDate childBirthdate = LocalDate.parse("2015-01-01");
        victim.setDateOfBirth(childBirthdate);
        victim.setGender("Man");
    }

    @Test
    public void testSetGenderWomanForAdult() {
        LocalDate adultBirthdate = LocalDate.parse("1990-01-01");
        victim.setDateOfBirth(adultBirthdate);
        victim.setGender("Woman");
        assertEquals("setGender should accept 'Woman' for adults", "Woman", victim.getGender());
    }

    @Test
    public void testSetGenderBoyForChild() {
        LocalDate childBirthdate = LocalDate.parse("2015-01-01");
        victim.setDateOfBirth(childBirthdate);
        victim.setGender("Boy");
        assertEquals("setGender should accept 'Boy' for children", "Boy", victim.getGender());
    }

    @Test
    public void testSetGenderGirlForChild() {
        LocalDate childBirthdate = LocalDate.parse("2018-01-01");
        victim.setDateOfBirth(childBirthdate);
        victim.setGender("Girl");
        assertEquals("setGender should accept 'Girl' for children", "Girl", victim.getGender());
    }

    /*
    testSetGenderCaseInsensitive -> means testing setGender with case variations:
       - What we need: To verify that gender values are case-insensitive and normalized.
       - Actual result: "woman" (lowercase) and "GIRL" (uppercase).
       - Expected Result: Should be normalized to "Woman" and "Girl" respectively.
    */
    @Test
    public void testSetGenderCaseInsensitive() {
        LocalDate adultBirthdate = LocalDate.parse("2000-01-01");
        victim.setDateOfBirth(adultBirthdate);
        victim.setGender("woman");
        assertEquals("setGender should normalize 'woman' to 'Woman'", "Woman", victim.getGender());
        
        LocalDate childBirthdate = LocalDate.parse("2015-01-01");
        victim.setDateOfBirth(childBirthdate);
        victim.setGender("GIRL");
        assertEquals("setGender should normalize 'GIRL' to 'Girl'", "Girl", victim.getGender());
    }

    /*
    testSetGenderPleaseSpecify -> means testing the "Please specify" gender option:
       - What we need: To verify that "Please specify" allows any free-form text.
       - Actual result: Gender set to "Non-binary".
       - Expected Result: getGender should return "Non-binary".
    */
    @Test
    public void testSetGenderPleaseSpecify() {
        victim.setGender("Please specify");
        victim.setGender("Non-binary");
        assertEquals("'Please specify' option allows free-form text", "Non-binary", victim.getGender());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetGenderInvalidOption() {
        victim.setGender("InvalidGender");
    }

    /*
    testAddPersonalBelonging -> means testing addPersonalBelonging with a supply:
       - What we need: To verify that a supply can be added to personal belongings.
       - Actual result: Supply "Water" with quantity 5.
       - Expected Result: The supply should be in the personal belongings array.
    */
    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new Supply("Water", 5);
        victim.addPersonalBelonging(newSupply);
        Supply[] testSupplies = victim.getPersonalBelongings();
        boolean correct = false;
 
        for (Supply supply : testSupplies) {
            if (supply == newSupply) {
                correct = true;
            }
        }
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }

    /*
    testRemovePersonalBelongingNotAddedPreviously -> means testing removePersonalBelonging with non-existent supply:
       - What we need: To verify that removing a supply that was never added throws an exception.
       - Actual result: Supply "Nonexistent" with quantity 1.
       - Expected Result: The method should throw IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testRemovePersonalBelongingNotAddedPreviously() {
        Supply supplyNotAdded = new Supply("Nonexistent", 1);
        victim.removePersonalBelonging(supplyNotAdded);
    }

    @Test
    public void testAddFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", LocalDate.parse("2025-01-20"));
        DisasterVictim victim2 = new DisasterVictim("John", LocalDate.parse("2025-01-22"));

        FamilyRelation relation = new FamilyRelation(victim2, "parent", victim1);
        FamilyRelation[] expectedRelations = {relation};
        victim2.setFamilyConnections(expectedRelations);

        FamilyRelation[] testFamily = victim2.getFamilyConnections();
        boolean correct = false;

        if ((testFamily != null) && (testFamily[0] == expectedRelations[0])) {
            correct = true;
        }
        assertTrue("addFamilyConnection should add a family relationship", correct);
    }

    @Test
    public void testRemoveFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", LocalDate.parse("2025-01-20"));
        DisasterVictim victim2 = new DisasterVictim("John", LocalDate.parse("2025-01-22"));
        FamilyRelation relation1 = new FamilyRelation(victim, "sibling", victim1);
        FamilyRelation relation2 = new FamilyRelation(victim, "sibling", victim2);
        FamilyRelation[] originalRelations = {relation1, relation2};
        victim.setFamilyConnections(originalRelations);
        victim.removeFamilyConnection(relation1);

        FamilyRelation[] testFamily = victim.getFamilyConnections();
        boolean correct = true;

        for (FamilyRelation relation : testFamily) {
            if (relation == relation1) {
                correct = false;
            }
        }
        assertTrue("removeFamilyConnection should remove the family member", correct);
    }  

    @Test
    public void testRemovePersonalBelonging() {
        Supply supplyToRemove = suppliesToSet[0]; 
        victim.addPersonalBelonging(supplyToRemove); 
        victim.removePersonalBelonging(supplyToRemove);

        Supply[] testSupplies = victim.getPersonalBelongings();
        boolean correct = true;
 
        for (Supply supply : testSupplies) {
            if (supply == supplyToRemove) {
                correct = false;
            }
        }
        assertTrue("removePersonalBelonging should remove the supply from personal belongings", correct);
    }

    @Test
    public void testSetFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", LocalDate.parse("2025-01-20"));
        DisasterVictim victim2 = new DisasterVictim("John", LocalDate.parse("2025-01-22"));

        FamilyRelation relation = new FamilyRelation(victim1, "sibling", victim2);
        FamilyRelation[] expectedRelations = {relation};
        victim1.setFamilyConnections(expectedRelations);
        boolean correct = true;

        FamilyRelation[] actualRecords = victim1.getFamilyConnections();
        if (expectedRelations.length != actualRecords.length) {
            correct = false;
        } else {    
            for (int i = 0; i < actualRecords.length; i++) {
                if (expectedRelations[i] != actualRecords[i]) {
                    correct = false;
                }
            }
        }
        assertTrue("Family relation should be set", correct);
    }

    @Test
    public void testSetMedicalRecords() {
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", LocalDate.parse("2025-02-09"));
        boolean correct = true;

        MedicalRecord[] newRecords = { testRecord };
        victim.setMedicalRecords(newRecords);
        MedicalRecord[] actualRecords = victim.getMedicalRecords();

        if (newRecords.length != actualRecords.length) {
            correct = false;
        } else {
            for (int i = 0; i < newRecords.length; i++) {
                if (actualRecords[i] != newRecords[i]) {
                    correct = false;
                }
            }
        }
        assertTrue("setMedicalRecords should correctly update medical records", correct);
    }

    @Test
    public void testSetPersonalBelongings() {
        Supply one = new Supply("Tent", 1);
        Supply two = new Supply("Jug", 3);
        Supply[] newSupplies = {one, two};
        boolean correct = true;

        victim.setPersonalBelongings(newSupplies);
        Supply[] actualSupplies = victim.getPersonalBelongings();

        if (newSupplies.length != actualSupplies.length) {
            correct = false;
        } else {
            for (int i = 0; i < newSupplies.length; i++) {
                if (actualSupplies[i] != newSupplies[i]) {
                    correct = false;
                }
            }
        }
        assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
    }

    /*
    testSetGenderPleaseSpecifyCaseVariations -> means testing different case versions:
       - What we need: To verify that "please specify" (lowercase), "PLEASE SPECIFY" (uppercase), 
         and "Please Specify" (mixed case) all work as the special flag.
       - Actual result: Different case variations followed by custom gender "Genderqueer".
       - Expected Result: All should result in "Genderqueer" being stored.
    */
    @Test
    public void testSetGenderPleaseSpecifyCaseVariations() {
        // Test lowercase
        victim.setGender("please specify");
        victim.setGender("Genderqueer");
        assertEquals("Lowercase 'please specify' should work", "Genderqueer", victim.getGender());
        
        // Reset victim
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        
        // Test uppercase
        victim.setGender("PLEASE SPECIFY");
        victim.setGender("Agender");
        assertEquals("Uppercase 'PLEASE SPECIFY' should work", "Agender", victim.getGender());
        
        // Reset victim
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        
        // Test mixed case
        victim.setGender("Please Specify");
        victim.setGender("Two-Spirit");
        assertEquals("Mixed case 'Please Specify' should work", "Two-Spirit", victim.getGender());
    }
}
