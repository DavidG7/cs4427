package Observer;

import java.awt.Color;
import java.util.Random;

import Memento.Memento;
import Singleton.Player;
import State.EasyMoveState;
import State.HardMoveState;
import State.MediumMoveState;
import State.State;
import Subject.Difficulty;
import Subject.Subject;

public abstract class Enemy implements Observer {
	public Player player;
	protected State enemyMoveState;
	protected Color enemyColor;
	protected int rowPosition;
	protected int colPosition;



	//public abstract void update(Subject subject);

	public void move(boolean forwardOrBack) {
		enemyMoveState.move(this);
	}

	public int getEnemyRowPosition() {
		// TODO Auto-generated method stub
		return rowPosition;
	}

	public int getEnemyColPosition() {
		// TODO Auto-generated method stub
		return colPosition;
	}

	public void setEnemyCoordinates(int[] positions) {
		// TODO Auto-generated method stub
		this.rowPosition = positions[0];
		this.colPosition = positions[1];
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return enemyColor;
	}

	public static int[] randomEnemyPosition() {
		int[] enemyPosition = new int[2];
		Random rand = new Random();
		enemyPosition[0] = rand.nextInt(10);
		enemyPosition[1] = rand.nextInt(10);
		return enemyPosition;
	}
	
	public Memento saveStateToMemento() {
		return new Memento(rowPosition,colPosition);
	}

	public void getStateFromMemento(Memento Memento) {
		this.rowPosition = Memento.getRowState();
		this.colPosition = Memento.getColState();

	}

    public abstract void doSomethingCool();




	
}