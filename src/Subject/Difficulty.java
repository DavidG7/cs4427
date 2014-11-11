package Subject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import Observer.SystemObserver;

/*
Manages the difficulty of the game
 */
public class Difficulty implements Subject{
	
	private ArrayList difficultyObservers;
	private HashMap<Integer,String> difficulties = new HashMap<Integer,String>();
	private int difficulty;

	/*
	Creates the difficulty
	 */
	public Difficulty(){
		difficultyObservers = new ArrayList();
		difficulty = 0;
		difficulties.put(0,"EASY");
		difficulties.put(1,"MEDIUM");
		difficulties.put(2,"HARD");
	}

	/*
	Attaches observers

	@param observer	the observer to attach
	 */
	@Override
	public void attach(SystemObserver observer) {
		// TODO Auto-generated method stub
		difficultyObservers.add(observer);
	}

	/*
	Detach observers

	@param observer	the observer to detach
	 */
	@Override
	public void detach(SystemObserver observer) {
		// TODO Auto-generated method stub
		int i = difficultyObservers.indexOf(observer);
		if (i >= 0) {
		difficultyObservers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < difficultyObservers.size(); i++) {
			SystemObserver observer = (SystemObserver)difficultyObservers.get(i);
			observer.update(this);
		}
	}

	/*
	Gets the current difficulty as an integer

	@return the current difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/*
	Sets the difficulty

	@param difficulty	the difficulty to be set
	 */
	public void setDifficulty(int difficulty) {
	    this.difficulty = difficulty;
	    notifyObservers();
	}

	/*
	Gets the current difficulty as text

	@return the current difficulty
	 */
	public String getDifficultyText() {
		return difficulties.get(difficulty);
	}

}
