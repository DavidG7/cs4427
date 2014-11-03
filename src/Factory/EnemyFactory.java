package Factory;

import Enemies.Monster;
import Enemies.Zombie;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;

public class EnemyFactory {
	
	public Enemy createEnemy(String type, Difficulty difficulty, Player player,int[] playerCoordinates) {
		if (type.equals("Monster")) {
		return new Monster(difficulty,player,playerCoordinates);
		}else if(type.equals("Zombie")) {
		return new Zombie(difficulty,player,playerCoordinates);
		}
		return null;
	}
}
