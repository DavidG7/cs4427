package State;

import Enemies.Monster;
import Observer.Enemy;

public class MediumMoveState implements State{

	@Override
	public void move(Enemy enemy) {
		// TODO Auto-generated method stub
		if(enemy.getIsSpotted()){
		    System.out.println("Move");
		}else{
		    System.out.println("Don't Move");
		}
	}

}
