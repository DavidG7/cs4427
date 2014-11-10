package Memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker{
	protected List<Memento> mementoList = new ArrayList<Memento>();
	private int numberOfMoves = 0;

	public void add(Memento state) {
		mementoList.add(state);
		numberOfMoves++;
	}

	public void remove(Memento state) {
		mementoList.remove(state);
		numberOfMoves--;
	}

	public Memento get(int index) throws ArrayIndexOutOfBoundsException {
		return mementoList.get(index);
	}

	public int getNumberOfMoves() {
		return numberOfMoves;
	}

}