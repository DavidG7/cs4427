package Decorator;

import Constants.Constants;
import Observer.Enemy;
import Singleton.Player;
import Subject.Subject;

public class DoubleMoveDecorator extends Enemy {

	Enemy enemy;

	public DoubleMoveDecorator(Enemy enemy) {
		// TODO Auto-generated constructor stub
		this.enemy = enemy;
	}

	@Override
	public void update(Subject subject) {
	enemy.update(subject);
	}

}
