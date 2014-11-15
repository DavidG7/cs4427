package Test;

import Constants.Constants;
import Factory.EnemyFactory;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class EnemyFactoryTest {

    Player player ;
    Difficulty difficulty ;
    @Before
    public void setUp() throws Exception {
        difficulty = new Difficulty();
        player = Player.getInstance();
    }

    @Test
    public void testCreateEnemyMonsters() throws Exception {
        EnemyFactory monsterFactory = new EnemyFactory();
        ArrayList<Enemy> monsters = monsterFactory.createEnemy(Constants.MONSTER, difficulty,player,4);
        assertEquals(4, monsters.size());
    }

    @Test
    public void testCreateEnemyZombies() throws Exception {
        EnemyFactory monsterFactory = new EnemyFactory();
        ArrayList<Enemy> zombies = monsterFactory.createEnemy(Constants.MONSTER, difficulty,player,4);
        assertEquals(4, zombies.size());
    }
}