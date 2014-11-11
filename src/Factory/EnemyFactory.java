package Factory;

import Enemies.Monster;
import Enemies.Zombie;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
/*
Creates Enemies
 */
public class EnemyFactory {

	/*
	Creates an Enemy object

	@param type			the type of enemy to be created
	@param difficulty	the difficulty the Enemy is to be set to
	@param player		an instance of the Player
	@param playerCoordinates	the current location of the Player
	@return a Monster or Zombie object
	 */

	public Enemy createEnemy(String type, Difficulty difficulty, Player player,int[] playerCoordinates) {
		if (type.equals("Monster")) {
		return new Monster(difficulty,player,playerCoordinates);
		}else if(type.equals("Zombie")) {
		return new Zombie(difficulty,player,playerCoordinates);
		}
		return null;
	}

}
