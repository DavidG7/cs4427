



import Factory.EnemyFactory;
import Observer.Enemy;
import Singleton.Player;

import Subject.Difficulty;

import UI.MenuUi;
import UI.Ui;




public class main 
{

	
	static Enemy[] enemies;
	
    public static void main (String[] args) {
    	
    	//Create Subjects and set their Observers
    	Difficulty difficulty = new Difficulty();
        Player player = Player.getInstance();
       
        enemies = new Enemy[3];
        EnemyFactory monsterFactory = new EnemyFactory();
        Enemy monster = monsterFactory.createEnemy("Monster", difficulty,player,Enemy.randomEnemyPosition());
        Enemy zombie = monsterFactory.createEnemy("Zombie", difficulty,player,Enemy.randomEnemyPosition());
        Enemy scaryZombie = monsterFactory.createEnemy("Zombie", difficulty,player,Enemy.randomEnemyPosition());
        enemies[0] = monster;
        enemies[1] = zombie;
        enemies[2] = scaryZombie;

        Ui userInterface = new MenuUi(difficulty, player,enemies);
        userInterface.draw();
        
    	
    }
    
    
   
}



