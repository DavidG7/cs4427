package State;

import Constants.Constants;
import Observer.Enemy;

public class EasyMoveState implements State{

	@Override
	public void move(Enemy enemy) {
		// TODO Auto-generated method stub
		System.out.println(Constants.ENEMY_DOESNT_MOVE);
	}

}
