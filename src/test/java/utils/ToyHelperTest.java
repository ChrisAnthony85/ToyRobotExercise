package utils;

import exception.IllegalMoveException;
import exception.IllegalPlacementException;
import exception.NotYetPlacedException;
import model.Coordinates;
import model.area.PlayArea;
import model.robot.Direction;
import model.robot.ToyRobot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyHelperTest {

    private PlayArea playArea;
    private static final String EXPECTED_ILLEGAL_MOVE_MESSAGE = "No Square exists with the given MOVE coordinates.";
    private static final String EXPECTED_ILLEGAL_PLACEMENT_MESSAGE = "No Square exists with the given PLACE coordinates.";
    private static final String EXPECTED_NOT_YET_PLACED_MESSAGE = "The toy has not been placed yet.";

    @BeforeEach
    public void init() {
        playArea = PlayAreaHelper.getDefaultSquarePlayArea();
    }

    @Test
    void testMoveUp() throws NotYetPlacedException, IllegalMoveException, IllegalPlacementException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(0, 0);
        toyRobot.place(coordinates, Direction.NORTH, playArea);
        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(0, 1), toyRobot.getCoordinates());
    }

    @Test
    void moveDown() throws IllegalMoveException, NotYetPlacedException, IllegalPlacementException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(0, 4);
        toyRobot.place(coordinates, Direction.SOUTH, playArea);

        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(0, 3), toyRobot.getCoordinates());
    }

    @Test
    void moveLeft() throws IllegalMoveException, NotYetPlacedException, IllegalPlacementException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(4, 0);
        toyRobot.place(coordinates, Direction.WEST, playArea);

        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(3, 0), toyRobot.getCoordinates());
    }

    @Test
    void moveRight() throws IllegalMoveException, NotYetPlacedException, IllegalPlacementException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(0, 0);
        toyRobot.place(coordinates, Direction.EAST, playArea);
        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(1, 0), toyRobot.getCoordinates());
    }

    @Test
    void turnLeft() {
    }

    @Test
    void turnRight() {
    }

    @Test
    void testConsecutiveMovements() throws NotYetPlacedException, IllegalMoveException, IllegalPlacementException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(0, 0);
        toyRobot.place(coordinates, Direction.NORTH, playArea);
        ToyHelper.move(toyRobot);

        assertEquals(new Coordinates(0, 1), toyRobot.getCoordinates());

        ToyHelper.turnRight(toyRobot);
        ToyHelper.move(toyRobot);

        assertEquals(new Coordinates(1, 1), toyRobot.getCoordinates());

        toyRobot.place(new Coordinates(4, 4), Direction.WEST, playArea);
        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(3, 4), toyRobot.getCoordinates());

        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(2, 4), toyRobot.getCoordinates());

        ToyHelper.turnLeft(toyRobot);
        ToyHelper.turnLeft(toyRobot); //about-face
        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(3, 4), toyRobot.getCoordinates());
    }

    // ========================================= test exceptions =========================================

    @Test
    void testMoveUpIllegalException() throws IllegalPlacementException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(4, 4);
        toyRobot.place(coordinates, Direction.NORTH, playArea);
        IllegalMoveException expectedException = assertThrows(IllegalMoveException.class, () -> ToyHelper.move(toyRobot));
        assertEquals(EXPECTED_ILLEGAL_MOVE_MESSAGE, expectedException.getMessage());
    }

    @Test
    void testMoveDownIllegalException() throws IllegalPlacementException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(0, 0);
        toyRobot.place(coordinates, Direction.SOUTH, playArea);
        IllegalMoveException expectedException = assertThrows(IllegalMoveException.class, () -> ToyHelper.move(toyRobot));
        assertEquals(EXPECTED_ILLEGAL_MOVE_MESSAGE, expectedException.getMessage());
    }

    @Test
    void testMoveLeftIllegalException() throws IllegalPlacementException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(0, 0);
        toyRobot.place(coordinates, Direction.WEST, playArea);
        IllegalMoveException expectedException = assertThrows(IllegalMoveException.class, () -> ToyHelper.move(toyRobot));
        assertEquals(EXPECTED_ILLEGAL_MOVE_MESSAGE, expectedException.getMessage());
    }

    @Test
    void testMoveRightIllegalException() throws IllegalPlacementException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(4, 0);
        toyRobot.place(coordinates, Direction.EAST, playArea);
        IllegalMoveException expectedException = assertThrows(IllegalMoveException.class, () -> ToyHelper.move(toyRobot));
        assertEquals(EXPECTED_ILLEGAL_MOVE_MESSAGE, expectedException.getMessage());
    }

    @Test
    void testPlaceIllegalPlacement() {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(5, 5); //out of perimeter
        IllegalPlacementException expectedException = assertThrows(IllegalPlacementException.class, () -> toyRobot.place(coordinates, Direction.EAST, playArea));
        assertEquals(EXPECTED_ILLEGAL_PLACEMENT_MESSAGE, expectedException.getMessage());
    }

    @Test
    void testMoveNotYetPlacedException() {
        ToyRobot toyRobot = new ToyRobot();

        NotYetPlacedException expectedException = assertThrows(NotYetPlacedException.class, () -> ToyHelper.move(toyRobot));
        assertEquals(EXPECTED_NOT_YET_PLACED_MESSAGE, expectedException.getMessage());
    }

    @Test
    void testConsecutiveMovementsUntilPlacementException() throws IllegalPlacementException, NotYetPlacedException, IllegalMoveException {
        ToyRobot toyRobot = new ToyRobot();
        Coordinates coordinates = new Coordinates(4, 0);
        toyRobot.place(coordinates, Direction.WEST, playArea);

        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(3, 0), toyRobot.getCoordinates());
        ToyHelper.turnRight(toyRobot);
        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(3, 1), toyRobot.getCoordinates());
        ToyHelper.turnRight(toyRobot);
        ToyHelper.move(toyRobot);
        assertEquals(new Coordinates(4, 1), toyRobot.getCoordinates());
        ToyHelper.turnRight(toyRobot);
        ToyHelper.move(toyRobot);  // a complete turn going to the starting placement
        assertEquals(new Coordinates(4, 0), toyRobot.getCoordinates());

        //move last time
        IllegalMoveException expectedException = assertThrows(IllegalMoveException.class, () -> ToyHelper.move(toyRobot));
        assertEquals(EXPECTED_ILLEGAL_MOVE_MESSAGE, expectedException.getMessage());
    }


}