package utils;

import model.Coordinates;
import model.area.PlayArea;
import model.area.Square;

import java.util.HashMap;
import java.util.Map;

public class PlayAreaHelper {

    /**
     * Assembles a 5 by 5 square PlayArea
     * @return  5 by 5 play area
     */
    public static PlayArea getDefaultSquarePlayArea() {
        Map<Coordinates, Square> squareMap = new HashMap<>();
        for(int y=0; y<5; y++) {
            for(int x=0; x<5; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                squareMap.put(coordinates, new Square(coordinates));
            }
        }
        return new PlayArea(squareMap);
    }
}
