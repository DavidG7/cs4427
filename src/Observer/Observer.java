package Observer;

import Subject.Difficulty;
import Subject.Subject;

/*
Observer Design Pattern observer interface
 */
public interface Observer {
	public void update(Subject subject);
}