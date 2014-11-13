package Enemies;



import java.awt.Color;

import Observer.Enemy;
import Singleton.Player;

import State.EasyMoveState;
import State.HardMoveState;
import State.MediumMoveState;
import Subject.Difficulty;
import Subject.Subject;
import Constants.Constants;

/*
A Monster enemy
 */
public class Monster extends Enemy {

	/*
	Creates a Monster enemy object

	@param difficulty		the difficulty the monster wil be set to
	@param player			the instance of the player
	@param enemyCoordinates	the location on the grid where the enemy will be created
	 */
	public Monster(Difficulty difficulty, Player player, int[] enemyCoordinates) {
		// TODO Auto-generated constructor stub
		difficulty.attach(this);
		player.attach(this);
		System.out.println(Constants.ATTACH_MONSTER);
		this.enemyMoveState = new EasyMoveState();
		this.player = player;
		this.colPosition = enemyCoordinates[0];
		this.rowPosition = enemyCoordinates[1];
		enemyColor = Color.RED;
        System.out.println("Monster at position: " + enemyCoordinates[0] + ","+ enemyCoordinates[1]);
	}

	/*
	Implementation of the Observer Interface's update() method

	@param subject	the subject to be updated
	 */
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		if (subject instanceof Difficulty) {
			int difficulty = ((Difficulty) subject).getDifficulty();
			if (difficulty == Constants.EASY_DIFFICULTY) {
				enemyMoveState = new EasyMoveState();
			} else if (difficulty == Constants.MEDIUM_DIFFICULTY) {
				enemyMoveState = new MediumMoveState();
			} else {
				enemyMoveState = new HardMoveState();
			}
			System.out.println(Constants.MONSTER_MOVEMENT + Constants.SPACE + difficulty);
		} else if (subject instanceof Player) {
			move(true);
		}
	}
	
}