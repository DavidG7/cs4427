package Enemies;

import java.awt.Color;

import Observer.Enemy;
import Singleton.Player;
import State.EasyMoveState;
import State.HardMoveState;
import State.MediumMoveState;
import State.State;
import Subject.Difficulty;
import Subject.Subject;

public class Zombie extends Enemy {

	private int rowPosition;
	private int colPosition;
	private int[] playerCoordinates = { rowPosition, colPosition };
	private boolean isSpotted = false;
	private Color zombieColor;

	public Zombie(Difficulty difficulty, Player player, int[] enemyCoordinates) {
		difficulty.attach(this);
		player.attach(this);
		System.out.println("Zombie attached to difficulty and player");
		super.enemyMoveState = new EasyMoveState();
		super.player = player;
		zombieColor = Color.RED;
		colPosition = enemyCoordinates[0];
		rowPosition = enemyCoordinates[1];
		System.out.println("Zombie at " + rowPosition + " " + colPosition);
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		if (subject instanceof Difficulty) {
			int difficulty = ((Difficulty) subject).getDifficulty();
			if (difficulty == 0) {
				super.enemyMoveState = new EasyMoveState();
			} else if (difficulty == 1) {
				super.enemyMoveState = new MediumMoveState();
			} else {
				super.enemyMoveState = new HardMoveState();
			}
			System.out.println("Zombie movement updated to " + difficulty);
		} else if (subject instanceof Player) {
			move();
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.enemyMoveState.move(this);
	}

	

	@Override
	public void setIsSpotted(boolean spotted) {
		// TODO Auto-generated method stub
		this.isSpotted = spotted;
	}

	@Override
	public boolean getIsSpotted() {
		// TODO Auto-generated method stub
		return isSpotted;
	}

	@Override
	public int getEnemyRowPosition() {
		// TODO Auto-generated method stub
		return rowPosition;
	}

	@Override
	public int getEnemyColPosition() {
		// TODO Auto-generated method stub
		return colPosition;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return zombieColor;
	}

	@Override
	public void setEnemyCoordinates(int[] positions) {
		// TODO Auto-generated method stub
		this.rowPosition = positions[0];
		this.colPosition = positions[1];
	}

}