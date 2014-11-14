package Singleton;

import java.awt.Color;
import java.util.ArrayList;

import Constants.Constants;
import Memento.Memento;
import Observer.Observer;
import Subject.Subject;

public class Player implements Subject {

	private static Player playerInstance = new Player();
	private ArrayList playerObservers;
	private int rowPosition;
	private int colPosition;
	private Color playerColor;
	private int[] previousPosition = Constants.START_POSITION;
	private String movedBackOrForward = "FORWARD";

	private Player() {
		playerObservers = new ArrayList();
		rowPosition = 0;// players initial position is (0,0)
		colPosition = 0;// of the maze/grid
		playerColor = Color.BLUE;// player is blue
		System.out.println(Constants.PLAYER_AT + Constants.SPACE + rowPosition
				+ Constants.SPACE + colPosition);
	}

	public static Player getInstance() {
		return playerInstance;
	}

	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub
		playerObservers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		// TODO Auto-generated method stub
		int i = playerObservers.indexOf(observer);
		if (i >= 0) {
			playerObservers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < playerObservers.size(); i++) {
			Observer observer = (Observer) playerObservers.get(i);
			observer.update(this);// passes itself as enemy and screen(our two
									// observers)
			// both observe the player and the difficulty level (another
			// subject)
		}
	}

	public void move(String direction) {
		previousPosition[0] = rowPosition;
		previousPosition[1] = colPosition;

		if (direction.equals(Constants.UP)) {
			moveUp();
		} else if (direction.equals(Constants.DOWN)) {
			moveDown();
		} else if (direction.equals(Constants.RIGHT)) {
			moveRight();
		} else if (direction.equals(Constants.LEFT)) {
			moveLeft();
		}
		notifyObservers();
	}

	public void moveRight() {
		// validate if possible to move in this direction
		if (colPosition != 9) {
			colPosition++;
			System.out.println(Constants.MOVES_RIGHT_OUTPUT + Constants.SPACE
					+ rowPosition + "," + colPosition);
		} else {
			System.out.println(Constants.NEG_MOVES_RIGHT_OUTPUT);
		}

	}

	public void moveLeft() {
		// validate if possible to move in this direction
		if (colPosition != 0) {
			colPosition--;
			System.out.println(Constants.MOVES_LEFT_OUTPUT + Constants.SPACE
					+ rowPosition + "," + colPosition);
		} else {
			System.out.println(Constants.NEG_MOVES_LEFT_OUTPUT);
		}

	}

	public void moveDown() {
		// validate if possible to move in this direction
		if (rowPosition != 9) {
			rowPosition++;
			System.out.println(Constants.MOVES_DOWN_OUTPUT + Constants.SPACE
					+ rowPosition + "," + colPosition);
		} else {
			System.out.println(Constants.NEG_MOVES_DOWN_OUTPUT);
		}

	}

	public void moveUp() {
		// validate if possible to move in this direction
		if (rowPosition != 0) {
			rowPosition--;
			System.out.println(Constants.MOVES_UP_OUTPUT + Constants.SPACE
					+ rowPosition + "," + colPosition);
		} else {
			System.out.println(Constants.NEG_MOVES_UP_OUTPUT);
		}

	}

	public int getPlayerRowCoordinate() {
		return rowPosition;
	}

	public int getPlayerColCoordinate() {
		return colPosition;
	}

	public Color getColor() {
		return playerColor;
	}

	public void resetPlayerCoordinates() {
		// TODO Auto-generated method stub
		rowPosition = 0;
		colPosition = 0;
		
	}

	public int[] getPreviousPosition() {
		// TODO Auto-generated method stub
		return previousPosition;
	}

	public Memento saveStateToMemento() {
		return new Memento(rowPosition, colPosition);
	}

	public void getStateFromMemento(Memento Memento) {
		previousPosition[0] = this.rowPosition;
		previousPosition[1] = this.colPosition;
		this.rowPosition = Memento.getRowState();
		this.colPosition = Memento.getColState();
		movedBackOrForward = Constants.BACK;
		notifyObservers();
		movedBackOrForward = Constants.FORWARD;
	}

	public String isMovedBackOrForward() {
		return movedBackOrForward;
	}

}
