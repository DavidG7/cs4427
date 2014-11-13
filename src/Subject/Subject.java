package Subject;

import Observer.Observer;

/*
Observer Design Pattern subject interface
 */
public interface Subject {
	public void attach(Observer observer);

	public void detach(Observer observer);

	public void notifyObservers();
}
