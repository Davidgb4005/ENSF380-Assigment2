/*
Copyright Ann Barcomb, Khawla Shnaikat, and DeepSeek, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FamilyRelationTest {

    private DisasterVictim personOne = new DisasterVictim("John Dalan", LocalDate.parse("2025-01-19"));
    private DisasterVictim personTwo = new DisasterVictim("Jane Dalan", LocalDate.parse("2025-02-20"));
    private String relationshipTo = "sibling";
    private FamilyRelation testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);
    
    @Test
    public void testObjectCreation() {
        assertNotNull(testFamilyRelationObject);
    }
    
    /*
    testConstructorWithOnePersonNull -> means testing FamilyRelation constructor with null person:
       - What we need: To verify that creating a FamilyRelation with a null person throws an exception.
       - Actual result: First person is null, relationship "parent", second person is a DisasterVictim.
       - Expected Result: The constructor should throw IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithOnePersonNull() {
        new FamilyRelation(null, "parent", personTwo);
    }
    
    /*
    testSetPersonOneWithNull -> means testing setPersonOne with null:
       - What we need: To verify that setting personOne to null throws an exception.
       - Actual result: personOne set to null.
       - Expected Result: The method should throw IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testSetPersonOneWithNull() {
        testFamilyRelationObject.setPersonOne(null);
    }
    
    /*
    testSetPersonTwoWithValidData -> means testing setPersonTwo with valid data:
       - What we need: To verify that personTwo can be set to a valid DisasterVictim.
       - Actual result: DisasterVictim "John" with entry date "2025-01-01".
       - Expected Result: getPersonTwo should return the same DisasterVictim.
    */
    @Test
    public void testSetPersonTwoWithValidData() {
        DisasterVictim newPersonTwo = new DisasterVictim("John", LocalDate.parse("2025-01-01"));
        testFamilyRelationObject.setPersonTwo(newPersonTwo);
        assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo());
    }

    @Test
    public void testSetAndGetPersonOne() {
        DisasterVictim newPersonOne = new DisasterVictim("New Person", LocalDate.parse("2025-03-21"));
        testFamilyRelationObject.setPersonOne(newPersonOne);
        assertEquals("setPersonOne should update personOne", newPersonOne, testFamilyRelationObject.getPersonOne());
    }

    @Test
    public void testSetAndGetPersonTwo() {
        DisasterVictim newPersonTwo = new DisasterVictim("Another Person", LocalDate.parse("2025-04-22"));
        testFamilyRelationObject.setPersonTwo(newPersonTwo);
        assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo());
    }

    @Test
    public void testSetAndGetRelationshipTo() {
        String newRelationship = "parent";
        testFamilyRelationObject.setRelationshipTo(newRelationship);
        assertEquals("setRelationshipTo should update the relationship", newRelationship, testFamilyRelationObject.getRelationshipTo());
    }
}
