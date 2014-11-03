package Observer;

import State.State;

public abstract class Enemy implements SystemObserver {
	protected State enemyMoveState;

	public abstract void move();

	public abstract boolean getIsSpotted();

	public abstract void setIsSpotted(boolean spotted);

	public abstract State getState();
}
