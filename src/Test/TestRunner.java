package Test;

/**
 * Created by Gearóid on 13/11/2014.
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {

        Result playerMoveResult = JUnitCore.runClasses(PlayerTest.class);

        for (Failure failure : playerMoveResult.getFailures()) {
            System.out.println(failure.toString());

        }
        System.out.println(playerMoveResult.wasSuccessful());
    }
}