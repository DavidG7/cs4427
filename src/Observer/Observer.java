package Observer;

import Subject.Difficulty;
import Subject.Subject;

public interface Observer {
	public void update(Subject subject);
}