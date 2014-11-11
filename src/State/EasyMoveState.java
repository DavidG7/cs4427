package State;

import Observer.Enemy;

public class EasyMoveState implements State{

	/*
	@param enemy	an enemy object
	 */
	@Override
	public void move(Enemy enemy) {
		// TODO Auto-generated method stub
		System.out.println("Dont Move");
	}

}
