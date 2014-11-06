package Observer;

import java.awt.Color;
import java.util.Random;

import Singleton.Player;
import State.State;

public abstract class Enemy implements Observer {
	protected State enemyMoveState;
	public Player player;

	public abstract void move();

	public abstract boolean getIsSpotted();

	public abstract void setIsSpotted(boolean spotted);

	
	public abstract int getEnemyRowPosition();
	
	public abstract int getEnemyColPosition();
	
	public abstract Color getColor();
	
	public abstract void setEnemyCoordinates(int[] positions);
	
	
	
	public static int[] randomEnemyPosition(){
	    	int[] enemyPosition = new int[2];
	    	Random rand = new Random();
	        enemyPosition[0] = rand.nextInt(10);
	        enemyPosition[1] = rand.nextInt(10);
			return enemyPosition;
	}
		
		
}