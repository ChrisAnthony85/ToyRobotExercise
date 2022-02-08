package model.robot;

import constant.MessageConstants;
import exception.IllegalPlacementException;
import model.Coordinates;
import model.area.PlayArea;

public class ToyRobot {
    private Coordinates coordinates; //current x,y location of robot
    private Direction direction;
    private PlayArea playArea;

    private boolean isPlaced;

    public void place(Coordinates coordinates, Direction direction, PlayArea playArea) throws IllegalPlacementException {
        if (!playArea.getSquareMap().containsKey(coordinates)) {
            throw new IllegalPlacementException(MessageConstants.ILLEGAL_PLACEMENT_MESSAGE);
        }
        setPlaced(true);
        this.setCoordinates(coordinates);
        this.setPlayArea(playArea);
        this.setDirection(direction);
    }



    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public PlayArea getPlayArea() {
        return playArea;
    }

    public void setPlayArea(PlayArea playArea) {
        this.playArea = playArea;
    }
}
