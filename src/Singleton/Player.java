package Singleton;

import java.awt.Color;
import java.util.ArrayList;

import Constants.Constants;
import Memento.Memento;
import Observer.Observer;
import Subject.Subject;
/*
The Player
 */
public class Player implements Subject {

	private static Player playerInstance = new Player();
	private ArrayList playerObservers;
	private int rowPosition;
	private int colPosition;
	private Color playerColor;
	private int[] previousPosition = Constants.START_POSITION;
	private String movedBackOrForward = "FORWARD";

	/*
	Creates a Player object
	 */
	private Player() {
		playerObservers = new ArrayList();
		rowPosition = 0;// players initial position is (0,0)
		colPosition = 0;// of the maze/grid
		playerColor = Color.BLUE;// player is blue
		System.out.println(Constants.PLAYER_AT + Constants.SPACE + rowPosition
				+ Constants.SPACE + colPosition);
	}

	/*
	@return an instance of the Player
	 */
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

	/*
	@param direction	the direction the Player wants to move
	 */
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
			System.out.println("Player moves right, new position is "
					+ rowPosition + "," + colPosition);
		} else {
			System.out.println("Not possible to move right");
		}

	}

	public void moveLeft() {
		// validate if possible to move in this direction
		if (colPosition != 0) {
			colPosition--;
			System.out.println("Player moves left, new position is "
					+ rowPosition + "," + colPosition);
		} else {
			System.out.println("Not possible to move left");
		}

	}

	public void moveDown() {
		// validate if possible to move in this direction
		if (rowPosition != 9) {
			rowPosition++;
			System.out.println("Player moves down, new position is "
					+ rowPosition + "," + colPosition);
		} else {
			System.out.println("Not possible to move down");
		}

	}

	public void moveUp() {
		// validate if possible to move in this direction
		if (rowPosition != 0) {
			rowPosition--;
			System.out.println("Player moves up, new position is "
					+ rowPosition + "," + colPosition);
		} else {
			System.out.println("Not possible to move up");
		}

	}

	/*
	@return the Player's Y coordinate on the grid
	 */
	public int getPlayerRowCoordinate() {
		return rowPosition;
	}

	/*
	@return the Player's X coordinate on the grid
	 */
	public int getPlayerColCoordinate() {
		return colPosition;
	}

	/*
	@return the Player's color
	 */
	public Color getColor() {
		return playerColor;
	}

	public void resetPlayerCoordinates() {
		// TODO Auto-generated method stub
		rowPosition = 0;
		colPosition = 0;
		
	}

	/*
	@return the Player's previous position on the grid
	 */
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
		movedBackOrForward = "BACK";
		notifyObservers();
		movedBackOrForward = "FORWARD";
	}

	public String isMovedBackOrForward() {
		return movedBackOrForward;
	}

}
