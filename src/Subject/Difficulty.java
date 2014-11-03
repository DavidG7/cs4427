package Subject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import Observer.SystemObserver;

public class Difficulty implements Subject{
	
	private ArrayList difficultyObservers;
	private HashMap<Integer,String> difficulties = new HashMap<Integer,String>();
	private int difficulty;
	
	public Difficulty(){
		difficultyObservers = new ArrayList();
		difficulty = 0;
		difficulties.put(0,"EASY");
		difficulties.put(1,"MEDIUM");
		difficulties.put(2,"HARD");
	}
	
	@Override
	public void attach(SystemObserver observer) {
		// TODO Auto-generated method stub
		difficultyObservers.add(observer);
	}

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
