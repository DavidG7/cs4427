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

public class Zombie extends Enemy {

	public Zombie(Difficulty difficulty, Player player, int[] enemyCoordinates) {
		//super(difficulty, player, enemyCoordinates)
		difficulty.attach(this);
		player.attach(this);
		System.out.println(Constants.ATTACH_ZOMBIE);
		this.enemyMoveState = new EasyMoveState();
		this.player = player;
		this.colPosition = enemyCoordinates[0];
		this.rowPosition = enemyCoordinates[1];
		this.enemyColor = Color.ORANGE;
		System.out.println("Zombie at position: " + enemyCoordinates[0] + ","+ enemyCoordinates[1]);
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		if (subject instanceof Difficulty) {
			int difficulty = ((Difficulty) subject).getDifficulty();
			if (difficulty == Constants.EASY_DIFFICULTY) {
				enemyMoveState = new EasyMoveState();
			} else if (difficulty == Constants.MEDIUM_DIFFICULTY) {
				enemyMoveState = new HardMoveState();
			} else {
				enemyMoveState = new MediumMoveState();
			}
			System.out.println(Constants.ZOMBIE_MOVEMENT + Constants.SPACE + difficulty);
		} else if (subject instanceof Player) {
			move(true);
		}
	}

	
}