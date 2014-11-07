package Observer;

import java.awt.Color;
import java.util.Random;

import Singleton.Player;
import State.EasyMoveState;
import State.HardMoveState;
import State.MediumMoveState;
import State.State;
import Subject.Difficulty;
import Subject.Subject;

public abstract class Enemy implements Observer {
	public Player player;
	protected State enemyMoveState;
	protected Color enemyColor;
	private int rowPosition;
	private int colPosition;

	public Enemy(Difficulty difficulty, Player player, int[] enemyCoordinates) {
		difficulty.attach(this);
		player.attach(this);
		System.out.println("Enemy attached to difficulty and player");
		this.enemyMoveState = new EasyMoveState();
		this.player = player;
		colPosition = enemyCoordinates[0];
		rowPosition = enemyCoordinates[1];
	}

	@Override
	public abstract void update(Subject subject); /*{
		// TODO Auto-generated method stub

		if (subject instanceof Difficulty) {
			int difficulty = ((Difficulty) subject).getDifficulty();
			if (difficulty == 0) {
				enemyMoveState = new EasyMoveState();
			} else if (difficulty == 1) {
				enemyMoveState = new MediumMoveState();
			} else {
				enemyMoveState = new HardMoveState();
			}
			System.out.println("Monster movement updated to " + difficulty);
		} else if (subject instanceof Player) {
			move();
		}

	}*/

	public void move() {
		enemyMoveState.move(this);
	}

	public int getEnemyRowPosition() {
		// TODO Auto-generated method stub
		return rowPosition;
	}

	public int getEnemyColPosition() {
		// TODO Auto-generated method stub
		return colPosition;
	}

	public void setEnemyCoordinates(int[] positions) {
		// TODO Auto-generated method stub
		this.rowPosition = positions[0];
		this.colPosition = positions[1];
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return enemyColor;
	}

	public static int[] randomEnemyPosition() {
		int[] enemyPosition = new int[2];
		Random rand = new Random();
		enemyPosition[0] = rand.nextInt(10);
		enemyPosition[1] = rand.nextInt(10);
		return enemyPosition;
	}

}