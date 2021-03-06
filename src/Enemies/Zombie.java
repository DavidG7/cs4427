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

/*
A Zombie enemy
 */

public class Zombie extends Enemy {

	private int xPosition;
	private int yPosition;
	private int[] playerCoordinates = { xPosition, yPosition };
	private boolean isSpotted = false;
	private Color zombieColor;

	/*
	Creates a Zombie object

	@param difficulty	the difficulty the Enemy is to be set to
	@param player		an instance of the Player
	@param playerCoordinates	the current location of the Player
	 */
	public Zombie(Difficulty difficulty, Player player, int[] playerCoordinates) {
		difficulty.attach(this);
		player.attach(this);
		System.out.println("Zombie attached to difficulty and player");
		super.enemyMoveState = new EasyMoveState();
		zombieColor = Color.RED;
		xPosition = playerCoordinates[0];
		yPosition = playerCoordinates[1];
		System.out.println("Zombie at " + xPosition + " " + yPosition);
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
	public State getState() {
		// TODO Auto-generated method stub
		return super.enemyMoveState;
	}

	/*
	@param spotted	sets if the Zombie object has been spotted
	 */
	@Override
	public void setIsSpotted(boolean spotted) {
		// TODO Auto-generated method stub
		this.isSpotted = spotted;
	}

	/*
	@return true if the Zombie object has been spotted by the player or false if it has not
	 */
	@Override
	public boolean getIsSpotted() {
		// TODO Auto-generated method stub
		return isSpotted;
	}

}
