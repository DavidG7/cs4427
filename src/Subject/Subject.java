package Subject;

import Observer.Observer;

public interface Subject {
	public void attach(Observer observer);

	public void detach(Observer observer);

	public void notifyObservers();
}
