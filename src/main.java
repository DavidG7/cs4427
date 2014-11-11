import java.awt.Menu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import Command.Invoker;
import Command.PlayerMoveCommand;
import Command.PlayerShineTorchCommand;
import Enemies.Monster;
import Factory.EnemyFactory;
import Observer.Enemy;
import Singleton.Player;
import State.EasyMoveState;
import State.HardMoveState;
import State.MediumMoveState;
import State.State;
import Subject.Difficulty;
import UI.DifficultyUi;
import UI.MenuUi;
import UI.Ui;



public class main 
{
	
    public static void main (String[] args) {
    	
    	//Create Subjects and set their Observers
    	Difficulty difficulty = new Difficulty();
        Player player = Player.getInstance();
        EnemyFactory monsterFactory = new EnemyFactory();
        Enemy monster = monsterFactory.createEnemy("Monster", difficulty,player,randomEnemyPosition());
        Enemy zombie = monsterFactory.createEnemy("Zombie", difficulty,player,randomEnemyPosition());
    	//MenuUi menu = new MenuUi();
        Ui userInterface = new MenuUi(difficulty, player);
        userInterface.draw();
        
    	
    }
    
    
    public static int[] randomEnemyPosition(){
    	int[] enemyPosition = new int[2];
    	Random rand = new Random();
        enemyPosition[0] = rand.nextInt((10 - 1) + 1) + 1;
        enemyPosition[1] = rand.nextInt((10 - 1) + 1) + 1;
		return enemyPosition;
    }
}


/*  EnemyFactory monsterFactory = new EnemyFactory();
Enemy monster = monsterFactory.createEnemy("Monster", difficultySystem);*/

/* State easyState = new EasyDifficultyState();
State mediumState = new MediumDifficultyState();
State hardState = new HardDifficultyState();
monster.setState(easyState);
monster.move();
monster.setState(mediumState);
monster.move();
monster.setState(hardState);
monster.move();*/

//Enemy monster = new Monster(difficultySystem);
//difficultySystem.setDifficulty(1);
//difficultySystem.setDifficulty(0);
//difficultySystem.setDifficulty(2);
