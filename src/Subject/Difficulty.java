package Subject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import Constants.Constants;

import Observer.Observer;

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
	
	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub
		difficultyObservers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
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
			Observer observer = (Observer)difficultyObservers.get(i);
			observer.update(this);
		}
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int difficulty) {
	    this.difficulty = difficulty;
	    notifyObservers();
	}

	public String getDifficultyText() {
		return difficulties.get(difficulty);
	}

}
