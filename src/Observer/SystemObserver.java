package Observer;

import Subject.Difficulty;
import Subject.Subject;

public interface SystemObserver {
   public void update(Subject subject);
}
