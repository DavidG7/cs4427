package Test;

import Constants.Constants;
import Enemies.Monster;
import Factory.EnemyFactory;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnemyFactoryTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateEnemy() throws Exception {

        Difficulty difficulty = new Difficulty();
        Player player = Player.getInstance();

        int[] monLoc = new int[] {1,1} ;

        //Monster mon = new Monster(difficulty, player, monLoc) ;

        EnemyFactory monsterFactory = new EnemyFactory();
        Enemy[] monsters = monsterFactory.createEnemy(Constants.MONSTER, difficulty,player,1);




        int [] array1 = new int[] {1, 2, 3};    //an example
        int [] array2 = new int[] {1, 2, 3};
        assertArrayEquals(array1, array2);
    }
}