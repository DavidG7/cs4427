package Factory;

import java.util.ArrayList;
import java.util.Random;

import Constants.Constants;
import Enemies.Monster;
import Enemies.Zombie;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;


public class EnemyFactory {

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