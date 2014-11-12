package Factory;

import java.util.Random;

import Constants.Constants;
import Enemies.Monster;
import Enemies.Zombie;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;

public class EnemyFactory {

	public Enemy[] createEnemy(String type, Difficulty difficulty,Player player, int numberOfEnemies) {
		Enemy[] enemies = new Enemy[numberOfEnemies];
		int[] playerCoordinates;
		for (int i = 0; i < numberOfEnemies; i++) {
			playerCoordinates = Enemy.randomEnemyPosition();
			if (type.equals(Constants.MONSTER)) {
				enemies[i] = new Monster(difficulty, player, playerCoordinates);
				// return new Monster(difficulty,player,playerCoordinates);
			} else if (type.equals(Constants.ZOMBIE)) {
				enemies[i] = new Zombie(difficulty, player, playerCoordinates);
				// return new Zombie(difficulty,player,playerCoordinates);
			}

		}
		return enemies;
	}

}