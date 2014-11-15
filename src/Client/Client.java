package Client;

import Constants.Constants;
import Factory.EnemyFactory;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import UI.MenuUi;
import UI.Ui;
import java.util.ArrayList;

public class Client 
{
	static Enemy[] enemies;
	
    public static void main (String[] args) {

        //Create Subjects and set their Observers
        Difficulty difficulty = new Difficulty();
        Player player = Player.getInstance();

        EnemyFactory monsterFactory = new EnemyFactory();
        ArrayList<Enemy> enemies =
                monsterFactory.createEnemy(Constants.MONSTER, difficulty, player, 1);

        enemies.addAll(monsterFactory.createEnemy(Constants.ZOMBIE, difficulty, player, 1));

        Ui userInterface = new MenuUi(difficulty, player, enemies);
        userInterface.draw();
    }
}



