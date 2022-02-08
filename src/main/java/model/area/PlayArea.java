package model.area;

import model.Coordinates;

import java.util.Map;

/**
 * Contains an assembly of all squares that can be traversed or placed on.
 */
public class PlayArea {
    private Map<Coordinates, Square> squareMap;

    public PlayArea(Map<Coordinates,Square> map) {
        this.squareMap = map;
    }

    public Map<Coordinates, Square> getSquareMap() {
        return squareMap;
    }

    public void setSquareMap(Map<Coordinates, Square> squareMap) {
        this.squareMap = squareMap;
    }
}
