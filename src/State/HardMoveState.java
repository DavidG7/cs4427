package State;

import java.util.Vector;
import javax.security.sasl.SaslException;
import Constants.Constants;
import Memento.CareTaker;
import Memento.EnemyCareTaker;
import Observer.Enemy;
import Singleton.Player;

public class HardMoveState implements State {

	private Player player;
	private CareTaker careTaker = new CareTaker();
	@Override
	public void move(Enemy enemy) {
		// TODO Auto-generated method stub
		player = enemy.player;
	  
		System.out.println(Constants.ENEMEY_MOVES);
		
		if(player.isMovedBackOrForward().equals("FORWARD")){
		careTaker.add(enemy.saveStateToMemento());
		enemy.setEnemyCoordinates(bfssearch(player.getPreviousPosition()[0],player.getPreviousPosition()[1],enemy.getEnemyRowPosition(),
				enemy.getEnemyColPosition()));
		}else if(player.isMovedBackOrForward().equals("BACK")) {
	    enemy.getStateFromMemento(careTaker.get(careTaker.getNumberOfMoves()-1));
	    careTaker.remove(careTaker.get(careTaker.getNumberOfMoves()-1));
		}

		
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
