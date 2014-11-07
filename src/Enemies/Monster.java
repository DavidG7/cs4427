package Enemies;



import java.awt.Color;

import Observer.Enemy;
import Singleton.Player;

import State.EasyMoveState;
import State.HardMoveState;
import State.MediumMoveState;
import Subject.Difficulty;
import Subject.Subject;


public class Monster extends Enemy {

	public Monster(Difficulty difficulty, Player player, int[] enemyCoordinates) {
		// TODO Auto-generated constructor stub
		super(difficulty, player, enemyCoordinates);
		enemyColor = Color.RED;
        System.out.println("Monster at position: " + enemyCoordinates[0] + ","+ enemyCoordinates[1]);
	}

	@Override
	public void update(Subject subject) {
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
	}
	
}