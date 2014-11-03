package Subject;

import Observer.SystemObserver;

public interface Subject {
	public void attach(SystemObserver observer);

	public void detach(SystemObserver observer);

	public void notifyObservers();
}
