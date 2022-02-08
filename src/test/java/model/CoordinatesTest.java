package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 We need to make sure that our custom Map<Coordinates, Square> keys are working as intended
 */
class CoordinatesTest {

    @Test
    void testCoordinatesEquality(){
        Coordinates coordinatesA = new Coordinates(0,0);
        Coordinates coordinatesB = new Coordinates(0,0);
        assertEquals(coordinatesA, coordinatesB);
    }

    @Test
    void testCoordinatesInequality(){
        Coordinates coordinatesA = new Coordinates(0,0);
        Coordinates coordinatesB = new Coordinates(4,4);
        assertNotEquals(coordinatesA, coordinatesB);
    }
}