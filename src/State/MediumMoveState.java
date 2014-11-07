package State;

import Enemies.Monster;
import Observer.Enemy;
import Singleton.Player;

public class MediumMoveState implements State {

	private Player player;
	@Override
	public void move(Enemy enemy) {
		// TODO Auto-generated method stub
		this.player = enemy.player;
		System.out.println("Don't Move/Medium");
		System.out.println(player.getPlayerRowCoordinate());
		enemy.setEnemyCoordinates(dfssearch(player.getPreviousPosition()[0],player.getPreviousPosition()[1],enemy.getEnemyRowPosition(),
				enemy.getEnemyColPosition()));
	}

	public int[] dfssearch(int playerRow, int playerCol, int enemyRow,
			int enemyCol) {

		if (enemyCol < playerCol) {
			enemyCol++;
		} else if (enemyCol > playerCol) {
			enemyCol--;
		} else if (enemyCol == playerCol && enemyRow < playerRow) {
			enemyRow++;
		} else if (enemyCol == playerCol && enemyRow > playerRow) {
			enemyRow--;
		} else {
			System.out.println("Game over");
		}
		int[] result = new int[2];
		result[0] = enemyRow;
		result[1] = enemyCol;
		return result;
	}
}
