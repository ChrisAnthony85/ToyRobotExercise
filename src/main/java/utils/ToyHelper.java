package utils;

import constant.MessageConstants;
import exception.IllegalMoveException;
import exception.NotYetPlacedException;
import model.Coordinates;
import model.robot.Direction;
import model.robot.ToyRobot;

public class ToyHelper {

    //Move Forward in current direction one square
    public static void move(ToyRobot toyRobot) throws IllegalMoveException, NotYetPlacedException {
        if(!toyRobot.isPlaced()) {
            throw new NotYetPlacedException(MessageConstants.NOT_YET_PLACED_MESSAGE);
        }
        switch(toyRobot.getDirection()) {
            case NORTH: moveUp(toyRobot); break;
            case SOUTH: moveDown(toyRobot); break;
            case EAST: moveRight(toyRobot); break;
            case WEST: moveLeft(toyRobot); break;
        }
    }

    public static void moveUp(ToyRobot toyRobot) throws IllegalMoveException {
        int x = toyRobot.getCoordinates().getX();
        int y = toyRobot.getCoordinates().getY();
        Coordinates newCoordinates = new Coordinates(x,y+1);
        setNewCoordinates(toyRobot, newCoordinates);
    }

    public static void moveDown(ToyRobot toyRobot) throws IllegalMoveException {
        int x = toyRobot.getCoordinates().getX();
        int y = toyRobot.getCoordinates().getY();
        Coordinates newCoordinates = new Coordinates(x, y-1);
        setNewCoordinates(toyRobot, newCoordinates);
    }

    public static void moveLeft(ToyRobot toyRobot) throws IllegalMoveException {
        int x = toyRobot.getCoordinates().getX();
        int y = toyRobot.getCoordinates().getY();
        Coordinates newCoordinates = new Coordinates(x-1, y);
        setNewCoordinates(toyRobot, newCoordinates);
    }

    public static void moveRight(ToyRobot toyRobot) throws IllegalMoveException {
        int x = toyRobot.getCoordinates().getX();
        int y = toyRobot.getCoordinates().getY();
        Coordinates newCoordinates = new Coordinates(x+1, y);
        setNewCoordinates(toyRobot, newCoordinates);
    }

    private static void setNewCoordinates(ToyRobot toyRobot, Coordinates newCoordinates) throws IllegalMoveException {
        if (!toyRobot.getPlayArea().getSquareMap().containsKey(newCoordinates)) {
            throw new IllegalMoveException( MessageConstants.ILLEGAL_MOVE_MESSAGE);
        }
        toyRobot.setCoordinates(newCoordinates);
    }



    public static void turnLeft(ToyRobot toyRobot) throws NotYetPlacedException{
        if(!toyRobot.isPlaced()) {
            throw new NotYetPlacedException(MessageConstants.NOT_YET_PLACED_MESSAGE);
        }
        switch(toyRobot.getDirection()) {
            case NORTH: toyRobot.setDirection(Direction.WEST); break;
            case SOUTH: toyRobot.setDirection(Direction.EAST); break;
            case EAST: toyRobot.setDirection(Direction.NORTH); break;
            case WEST: toyRobot.setDirection(Direction.SOUTH); break;
        }
    }

    public static void turnRight(ToyRobot toyRobot) throws NotYetPlacedException{
        if(!toyRobot.isPlaced()) {
            throw new NotYetPlacedException(MessageConstants.NOT_YET_PLACED_MESSAGE);
        }
        switch(toyRobot.getDirection()) {
            case NORTH: toyRobot.setDirection(Direction.EAST); break;
            case SOUTH: toyRobot.setDirection(Direction.WEST); break;
            case EAST: toyRobot.setDirection(Direction.SOUTH); break;
            case WEST: toyRobot.setDirection(Direction.NORTH); break;
        }
    }
}
