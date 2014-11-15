package Test;

/**
 * Created by Wesley on 15/11/2014.
 */

import Constants.Constants;
import Subject.Difficulty;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DifficultyTest {

    Difficulty difficulty ;
    @Before
    public void setUp() throws Exception {
        difficulty = new Difficulty() ;
    }

    @Test
    public void testGetDifficulty() throws Exception {
        difficulty = new Difficulty() ;
        assertEquals(0, difficulty.getDifficulty()) ;
    }

    @Test
    public void testSetDifficulty() throws Exception {
        difficulty = new Difficulty() ;
        difficulty.setDifficulty(1);
        assertEquals(1, difficulty.getDifficulty()) ;
    }

    @Test
    public void testGetDifficultyText() throws Exception {
        difficulty = new Difficulty() ;
        assertEquals(Constants.EASY_TEXT, difficulty.getDifficultyText()) ;
    }
}
