/*
Copyright Ann Barcomb, Khawla Shnaikat, and DeepSeek, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SupplyTest {
    String expectedType = "Blanket";
    int expectedQuantity = 5;
    private Supply supply = new Supply(expectedType, expectedQuantity);

    /*
    testObjectCreation -> means testing Supply constructor: 
       - What we need: To verify that a "Supply" object is successfully created.
       - Actual result: Supply type is "Blanket", The quantity is 5.
       - Expected Result: The test checks that the Supply object is not null, confirming successful object creation.
    */
    @Test
    public void testObjectCreation() {
        assertNotNull(supply);
    }
    
    /*
    testConstructorWithValidData -> means testing Supply constructor with valid data:
       - What we need: To verify that a "Supply" object is successfully created with valid data.
       - Actual result: Supply type "Blanket", quantity 5.
       - Expected Result: The test checks that the Supply object has correct type and quantity.
    */
    @Test
    public void testConstructorWithValidData() {
        Supply testSupply = new Supply("Blanket", 5);
        assertNotNull("Constructor should create a Supply object", testSupply);
        assertEquals("Constructor should set type correctly", "Blanket", testSupply.getType());
        assertEquals("Constructor should set quantity correctly", 5, testSupply.getQuantity());
    }
    
    @Test
    public void testGetType() {
        assertEquals("getType should return the correct type", expectedType, supply.getType());
    }
    
    @Test
    public void testSetType() {
        supply.setType("Food");
        assertEquals("setType should update the type", "Food", supply.getType());
    }

    @Test
    public void testGetQuantity() {
        assertEquals("getQuantity should return the correct quantity", expectedQuantity, supply.getQuantity());
    }

    /*
    testSetQuantityWithValidData -> means testing setQuantity with valid quantity:
       - What we need: To verify that quantity can be set to a positive value.
       - Actual result: Quantity 8.
       - Expected Result: getQuantity should return 8.
    */
    @Test
    public void testSetQuantityWithValidData() {
        supply.setQuantity(8);
        assertEquals("setQuantity should update the quantity", 8, supply.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        supply.setQuantity(20);
        assertEquals("setQuantity should update the quantity", 20, supply.getQuantity());
    }
    
    /*
    testSetQuantityWithNegativeQuantity -> means testing setQuantity with negative quantity:
       - What we need: To verify that setting a negative quantity throws an exception.
       - Actual result: Quantity -5.
       - Expected Result: The method should throw IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantityWithNegativeQuantity() {
        supply.setQuantity(-5);
    }
    
    @Test
    public void testSetZeroQuantity() {
        supply.setQuantity(0);
        assertEquals("setQuantity should accept zero quantity", 0, supply.getQuantity());
    }
}
