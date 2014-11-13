package State;

import Observer.Enemy;

/*
State Design Pattern
 */
public interface State {

	/*
	@param enemy	the enemy to be moved
	 */
	public void move(Enemy enemy);
}
