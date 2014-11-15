package Test;

import Constants.Constants;
import Factory.EnemyFactory;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import UI.GameUi;
import UI.Ui;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class PlayerTest {

    Player player ;

    @Before
    public void setUp() throws Exception {
        player = Player.getInstance();
        player.resetPlayerCoordinates();
    }

    @Test
    public void testMoveRight() throws Exception {
        int[] expectedResult = new int[] {player.getPlayerRowCoordinate(), player.getPlayerColCoordinate() + 1} ;
        player.move(Constants.RIGHT) ;
        int[] actualResult = new int[] {player.getPlayerRowCoordinate(), player.getPlayerColCoordinate()} ;
        assertArrayEquals("Fails if actually result is 9", expectedResult, actualResult) ;
    }

    @Test
    public void testMoveLeft() throws Exception {
        int expectedColumn = player.getPlayerColCoordinate() ;

        int[] expectedResult = new int[] {player.getPlayerRowCoordinate(), player.getPlayerColCoordinate() - 1} ;
        player.move(Constants.LEFT) ;
        int[] actualResult = new int[] {player.getPlayerRowCoordinate(), player.getPlayerColCoordinate()} ;
        assertArrayEquals("Fails if actually result is 0", expectedResult, actualResult) ;
    }

    @Test
    public void testMoveDown() throws Exception {
        int[] expectedResult = new int[] {player.getPlayerRowCoordinate() + 1, player.getPlayerColCoordinate()} ;
        player.move(Constants.DOWN) ;
        int[] actualResult = new int[] {player.getPlayerRowCoordinate(), player.getPlayerColCoordinate()} ;
        assertArrayEquals("Fails if actually result is 9", expectedResult, actualResult) ;
    }

    @Test
    public void testMoveUp() throws Exception {
        int[] expectedResult = new int[] {player.getPlayerRowCoordinate() - 1 , player.getPlayerColCoordinate()} ;
        player.move(Constants.UP) ;
        int[] actualResult = new int[] {player.getPlayerRowCoordinate(), player.getPlayerColCoordinate()} ;
        assertArrayEquals("Fails if actually result is 0", expectedResult, actualResult) ;
    }
}