package utils;

import model.area.PlayArea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayAreaHelperTest {

    @Test
    void testGetDefaultSquarePlayAreaSize() {
        PlayArea playArea = PlayAreaHelper.getDefaultSquarePlayArea();
        assertEquals(25, playArea.getSquareMap().size());
    }
}