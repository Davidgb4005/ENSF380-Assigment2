/*
Copyright Ann Barcomb, Khawla Shnaikat, and DeepSeek, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class LocationTest {
    private Location location;
    private DisasterVictim victim;
    private Supply supply;

    @Before
    public void setUp() {
        location = new Location("Shelter A", "1234 Shelter Ave");
        victim = new DisasterVictim("John Doe", LocalDate.parse("2025-01-01"));
        supply = new Supply("Water Bottle", 10);
    }

    @Test
    public void testConstructor() {
        assertNotNull("Constructor should create a non-null Location object", location);
        assertEquals("Constructor should set the name correctly", "Shelter A", location.getName());
        assertEquals("Constructor should set the address correctly", "1234 Shelter Ave", location.getAddress());
    }

    @Test
    public void testSetName() {
        String newName = "Shelter B";
        location.setName(newName);
        assertEquals("setName should update the name of the location", newName, location.getName());
    }

    @Test
    public void testSetAddress() {
        String newAddress = "4321 Shelter Blvd";
        location.setAddress(newAddress);
        assertEquals("setAddress should update the address of the location", newAddress, location.getAddress());
    }

    /*
    testAddOccupantWithValidData -> means testing addOccupant with a valid victim:
       - What we need: To verify that a disaster victim can be added to a location.
       - Actual result: DisasterVictim "John" with entry date "2025-01-01".
       - Expected Result: The victim should be in the occupants array.
    */
    @Test
    public void testAddOccupantWithValidData() {
        DisasterVictim testVictim = new DisasterVictim("John", LocalDate.parse("2025-01-01"));
        location.addOccupant(testVictim);
        
        boolean found = false;
        DisasterVictim[] occupants = location.getOccupants();
        if (occupants != null) {
            for (DisasterVictim occupant : occupants) {
                if (occupant.equals(testVictim)) {
                    found = true;
                    break;
                }
            }
        }
        assertTrue("addOccupant should add a disaster victim to the occupants array", found);
    }

    @Test
    public void testAddOccupant() {
        location.addOccupant(victim);
        
        boolean found = false;
        DisasterVictim[] occupants = location.getOccupants();
        if (occupants != null) {
            for (DisasterVictim occupant : occupants) {
                if (occupant.equals(victim)) {
                    found = true;
                    break;
                }
            }
        }
        assertTrue("addOccupant should add a disaster victim to the occupants array", found);
    }

    /*
    testRemoveOccupantNotAddedPreviously -> means testing removeOccupant with a victim that was never added:
       - What we need: To verify that removing a victim that was never added throws an exception.
       - Actual result: DisasterVictim "Nonexistent" with entry date "2025-01-01".
       - Expected Result: The method should throw IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveOccupantNotAddedPreviously() {
        DisasterVictim nonExistentVictim = new DisasterVictim("Nonexistent", LocalDate.parse("2025-01-01"));
        location.removeOccupant(nonExistentVictim);
    }

    @Test
    public void testRemoveOccupant() {
        location.addOccupant(victim);
        location.removeOccupant(victim);
        
        boolean found = false;
        DisasterVictim[] occupants = location.getOccupants();
        if (occupants != null) {
            for (DisasterVictim occupant : occupants) {
                if (occupant.equals(victim)) {
                    found = true;
                    break;
                }
            }
        }
        assertFalse("removeOccupant should remove the disaster victim from the occupants array", found);
    }

    @Test
    public void testSetAndGetOccupants() {
        DisasterVictim[] newOccupants = {victim};
        location.setOccupants(newOccupants);
        
        boolean found = false;
        DisasterVictim[] occupants = location.getOccupants();
        if (occupants != null) {
            for (DisasterVictim occupant : occupants) {
                if (occupant.equals(victim)) {
                    found = true;
                    break;
                }
            }
        }
        assertTrue("setOccupants should replace the occupants array with the new array", found);
    }

    @Test
    public void testAddSupply() {
        location.addSupply(supply);
        
        boolean found = false;
        Supply[] supplies = location.getSupplies();
        if (supplies != null) {
            for (Supply s : supplies) {
                if (s.equals(supply)) {
                    found = true;
                    break;
                }
            }
        }
        assertTrue("addSupply should add a supply to the supplies array", found);
    }

    @Test
    public void testRemoveSupply() {
        location.addSupply(supply);
        location.removeSupply(supply);
        
        boolean found = false;
        Supply[] supplies = location.getSupplies();
        if (supplies != null) {
            for (Supply s : supplies) {
                if (s.equals(supply)) {
                    found = true;
                    break;
                }
            }
        }
        assertFalse("removeSupply should remove the supply from the supplies array", found);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistentSupply() {
        location.removeSupply(supply);
    }

    @Test
    public void testSetAndGetSupplies() {
        Supply[] newSupplies = {supply};
        location.setSupplies(newSupplies);
        
        boolean found = false;
        Supply[] supplies = location.getSupplies();
        if (supplies != null) {
            for (Supply s : supplies) {
                if (s.equals(supply)) {
                    found = true;
                    break;
                }
            }
        }
        assertTrue("setSupplies should replace the supplies array with the new array", found);
    }
}
