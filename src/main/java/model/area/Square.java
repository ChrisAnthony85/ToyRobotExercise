package model.area;

import model.Coordinates;

/**
 * The basic component of the play area, each square is
 * an area that the toy can move to and from.
 */
public class Square {
    private Coordinates coordinates;
    private boolean isOccupied;

    public Square(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
