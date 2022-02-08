package model.robot;

import model.Coordinates;
import model.robot.Direction;

public class Position {
    private Coordinates coordinates;
    private Direction direction;

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
}
