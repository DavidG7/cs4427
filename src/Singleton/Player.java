package Singleton;

import java.awt.Color;
import java.util.ArrayList;

import Observer.SystemObserver;
import Subject.Subject;

public class Player implements Subject {

	private static Player playerInstance = new Player();
	private ArrayList playerObservers;
	private int xPosition;
	private int yPosition;
	private int[] playerCoordinates = { xPosition, yPosition };
	private Color playerColor;

	private Player() {
		playerObservers = new ArrayList();
		xPosition = 0;// players initial position is set to (0,0)
		yPosition = 0;// of the maze/grid
		playerColor = Color.BLUE;// player is blue
		System.out.println("Player at " + xPosition + " " + yPosition);
	}

	public static Player getInstance() {
		return playerInstance;
	}

	@Override
	public void attach(SystemObserver observer) {
		// TODO Auto-generated method stub
		playerObservers.add(observer);
	}

	@Override
	public void detach(SystemObserver observer) {
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
			SystemObserver observer = (SystemObserver) playerObservers.get(i);
			observer.update(this);//passes itself as enemy and screen(our two observers)
			//both observe the player and the difficulty level (another subject)
		}
	}

	public void move(String direction) {
		if (direction.equals("UP")) {
			moveUp();
		} else if (direction.equals("DOWN")) {
			moveDown();
		} else if (direction.equals("RIGHT")) {
			moveRight();
		} else if (direction.equals("LEFT")) {
			moveLeft();
		}
		notifyObservers();
	}

	public void moveUp() {
		// validate if possible to move in this direction
		if (yPosition != 9) {
			yPosition++;
			System.out.println("Player moves up, new position is " + xPosition
					+ "," + yPosition);
		} else {
			System.out.println("Not possible to move up");
		}
		
	}

	public void moveDown() {
		// validate if possible to move in this direction
		if (yPosition != 0) {
			yPosition--;
			System.out.println("Player moves down, new position is "
					+ xPosition + "," + yPosition);
		} else {
			System.out.println("Not possible to move down");
		}
		
	}

	public void moveRight() {
		// validate if possible to move in this direction
		if (xPosition != 9) {
			xPosition++;
			System.out.println("Player moves right, new position is "
					+ xPosition + "," + yPosition);
		} else {
			System.out.println("Not possible to move right");
		}
		
	}

	public void moveLeft() {
		// validate if possible to move in this direction
		if (xPosition != 0) {
			xPosition--;
			System.out.println("Player moves left, new position is "
					+ xPosition + "," + yPosition);
		} else {
			System.out.println("Not possible to move left");
		}
	
	}

	public void shineTorch() {
		// make grid two grid positions in all directions visible
		System.out.println("Player shines torch");
		notifyObservers();
	}

	public int[] getPlayerCoordinates() {
		return playerCoordinates;
	}

    public int getPlayerXCoordinate() { return xPosition ; }

    public int getPlayerYCoordinate() { return yPosition ; }

    public Color getColor() {
		return playerColor;
	}

}



