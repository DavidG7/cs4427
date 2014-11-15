package Subject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import Constants.Constants;

import Observer.Observer;

/*
The difficulty of the game
 */
public class Difficulty implements Subject{
	
	private ArrayList difficultyObservers;
	private HashMap<Integer,String> difficulties = new HashMap<Integer,String>();
	private int difficulty;
	
	public Difficulty(){
		difficultyObservers = new ArrayList();
		difficulty = Constants.EASY_DIFFICULTY;
		difficulties.put(Constants.EASY_DIFFICULTY,Constants.EASY_TEXT);
		difficulties.put(Constants.MEDIUM_DIFFICULTY,Constants.MEDIUM_TEXT);
		difficulties.put(Constants.HARD_DIFFICULTY,Constants.HARD_TEXT);
	}

    /*
	Implementation of the Subject Interface's attach() method
	@param observer		the observer to be attached to the difficulty
	 */
	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub
		difficultyObservers.add(observer);
	}

    /*
	Implementation of the Subject Interface's detach() method
	@param observer		the observer to be detached from the difficulty
	 */
	@Override
	public void detach(Observer observer) {
		// TODO Auto-generated method stub
		int i = difficultyObservers.indexOf(observer);
		if (i >= 0) {
		difficultyObservers.remove(i);
		}
	}

    /*
	Implementation of the Subject Interface's notifyObservers() method
	 */
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < difficultyObservers.size(); i++) {
			Observer observer = (Observer)difficultyObservers.get(i);
			observer.update(this);
		}
	}

    /*
	@return the difficulty of the game
	 */
	public int getDifficulty() {
		return difficulty;
	}

    /*
	Sets the difficulty of the game
	@param difficulty	the difficulty the game will be set to
 	*/
	public void setDifficulty(int difficulty) {
	    this.difficulty = difficulty;
	    notifyObservers();
	}

    /*
	@return the difficulty of the game as a string
	 */
	public String getDifficultyText() {
		return difficulties.get(difficulty);
	}

}
