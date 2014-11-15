package Factory;

import Constants.Constants;
import Enemies.Monster;
import Enemies.Zombie;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;

import java.util.ArrayList;

/*
Factory Method
 */
public class EnemyFactory {

    /*
	Creates enemies
	@param type				the type of enemy that is to be created
	@param difficulty		the difficulty the enemy will be set to
	@param player			an instance of the player
	@param numberOfEnemies	the number of enemies to create
	@return an array of enemies
	 */
	public ArrayList<Enemy> createEnemy(String type, Difficulty difficulty,Player player, int numberOfEnemies) {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		int[] playerCoordinates;
		for (int i = 0; i < numberOfEnemies; i++) {
			playerCoordinates = Enemy.randomEnemyPosition();
			if (type.equals(Constants.MONSTER)) {
				enemies.add(new Monster(difficulty, player, playerCoordinates));
				// return new Monster(difficulty,player,playerCoordinates);
			} else if (type.equals(Constants.ZOMBIE)) {
				enemies.add(new Zombie(difficulty, player, playerCoordinates));
				// return new Zombie(difficulty,player,playerCoordinates);
			}

		}
		return enemies;
	}

}