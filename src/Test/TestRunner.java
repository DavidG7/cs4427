package Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result playerMoveResult = JUnitCore.runClasses(PlayerTest.class);
        Result difficultyResult = JUnitCore.runClasses(DifficultyTest.class);
        Result enemyCreationResult = JUnitCore.runClasses(DifficultyTest.class);

        for (Failure failure : playerMoveResult.getFailures()) {
            System.out.println(failure.toString());
        }
        for (Failure failure : difficultyResult.getFailures()) {
            System.out.println(failure.toString());
        }
        for (Failure failure : enemyCreationResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Player Move Result: " + playerMoveResult.wasSuccessful());
        System.out.println("Difficulty Result: " + difficultyResult.wasSuccessful());
        System.out.println("Enemy Creation Result: " + difficultyResult.wasSuccessful());
    }
}