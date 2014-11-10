package Memento;

public class Memento {
	private int rowPosition;
	private int colPosition;
	

	public Memento(int rowPosition, int colPosition) {
		this.rowPosition = rowPosition;
		this.colPosition = colPosition;
	}

	public int getRowState() {
		return rowPosition;
	}
	
	public int getColState() {
		return colPosition;
	}
}
