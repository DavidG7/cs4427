



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
       
        EnemyFactory monsterFactory = new EnemyFactory();
        Enemy[] monsters = monsterFactory.createEnemy("Monster", difficulty,player,2);
        Enemy[] zombies = monsterFactory.createEnemy("Zombie", difficulty,player,2);
        
        Enemy[] enemies = concat(zombies,monsters);
     
        Ui userInterface = new MenuUi(difficulty, player, enemies);
        userInterface.draw();
        
    	
    }
    
    
    public static Enemy[] concat(Enemy[] A, Enemy[] B) {
    	   int aLen = A.length;
    	   int bLen = B.length;
    	   Enemy[] enemies= new Enemy[aLen+bLen];
    	   System.arraycopy(A, 0, enemies, 0, aLen);
    	   System.arraycopy(B, 0, enemies, aLen, bLen);
    	   return enemies;
    	}
    
   
}



