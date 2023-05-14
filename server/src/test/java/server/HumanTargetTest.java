package server.model.target;

import static org.junit.jupiter.api.Assertions.*;
import server.model.target.HumanTarget;
import server.model.Coordinate;
import server.model.Sensor;
import server.Simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

public class HumanTargetTest {
    
    Coordinate cd = new Coordinate(12.0,18.0);
    HumanTarget ht = new HumanTarget("1", cd);
    HumanTarget ht1 = new HumanTarget("1", cd);
    HumanTarget ht2 = new HumanTarget("2", cd);

    //Tests for Class: Target
    @Test
    @DisplayName("Test getType method")
    void testGetType() {
        assertEquals(0, ht.getType());
    }

    @Test
    @DisplayName("Test isVisible method")
    void testIsVisible() {
        assertTrue(ht.isVisible());
    }

    @Test
    @DisplayName("Test setVisible method")
    void testSetVisible() {
        ht.setVisible(false);
        assertFalse(ht.isVisible());
    }

    //Tests for Class: MObject
    @Test
    @DisplayName("Return Coordinate of the MObject")
    void getCoordinateTest()
    {
        Coordinate newCoordinate = new Coordinate(1, 1);
        ht.setCoordinate(newCoordinate);
        assertEquals(newCoordinate, ht.getCoordinate());
    }

    @Test
    @DisplayName("Test setTargetType() and getTargetType() methods")
    void testSetAndGetTargetType() {
        int targetType = 2;
        ht.setTargetType(targetType);
        assertEquals(targetType, ht.getTargetType());
    }

    @Test
    @DisplayName("Test setTargetType() and getTargetType() methods")
    void testEquals() {
        assertFalse(ht.equals(cd));
        assertTrue(ht.equals(ht));
    }

    @Test
    @DisplayName("Test hashCode() method")
    void hashCodeTest()
    {
        HumanTarget ht1 = new HumanTarget("1", cd);
        assertTrue(Integer.class.isInstance(ht1.hashCode()));
    }
    
    @Test
    @DisplayName("Test compareTo() method")
    void compareToTest()
    {
        assertTrue(Integer.class.isInstance(ht1.compareTo(ht2)));
    }

    //Tests for Class: IdObject
    @Test
    @DisplayName("Get Id of IdObject")
    void getIdTest()
    {
        assertEquals("1",ht.getId());
    }

    @Test
    @DisplayName("Get Id of toString")
    void toStringTest()
    {
        assertEquals("HumanTarget_1",ht1.toString());
    }
}
