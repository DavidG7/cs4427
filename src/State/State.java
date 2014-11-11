package State;

import Observer.Enemy;

public interface State {

	/*
	@param enemy	an enemy object
	 */
	public void move(Enemy enemy);
}
