package State;

import java.util.Vector;

import Observer.Enemy;
import Singleton.Player;

public class HardMoveState implements State {

	private Player player;

	@Override
	public void move(Enemy enemy) {
		// TODO Auto-generated method stub
		player = enemy.player;
		System.out.println("Move");
		System.out.println(player.getPlayerRowCoordinate());
		enemy.setEnemyCoordinates(bfssearch(player.getPreviousPosition()[0],player.getPreviousPosition()[1],enemy.getEnemyRowPosition(),
				enemy.getEnemyColPosition()));

	}

	public int[] bfssearch(int playerRow, int playerCol, int enemyRow, int enemyCol) {

		if (enemyRow < playerRow) {
			enemyRow++;
		} else if (enemyRow > playerRow) {
			enemyRow--;
		} else if (enemyRow == playerRow && enemyCol < playerCol) {
			enemyCol++;
		} else if (enemyRow == playerRow && enemyCol > playerCol) {
			enemyCol--;
		} else {
			System.out.println("Game over");
		}
		int[] result = new int[2];
		result[0] = enemyRow;
		result[1] = enemyCol;
		return result;
	}
}
