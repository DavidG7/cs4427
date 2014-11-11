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


public class Monster extends Enemy {

	public Monster(Difficulty difficulty, Player player, int[] enemyCoordinates) {
		// TODO Auto-generated constructor stub
		//super(difficulty, player, enemyCoordinates);
		difficulty.attach(this);
		player.attach(this);
		System.out.println("Monster attached to difficulty and player");
		this.enemyMoveState = new EasyMoveState();
		this.player = player;
		this.colPosition = enemyCoordinates[0];
		this.rowPosition = enemyCoordinates[1];
		enemyColor = Color.RED;
        System.out.println("Monster at position: " + enemyCoordinates[0] + ","+ enemyCoordinates[1]);
	}

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
			System.out.println("Monster movement updated to " + difficulty);
		} else if (subject instanceof Player) {
			move(true);
		}
	}
	
}