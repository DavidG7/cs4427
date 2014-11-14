package UI;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Observer.Enemy;
import Observer.Observer;
import Singleton.Player;
import Subject.Difficulty;
import Constants.Constants;


public abstract class Ui extends JFrame implements Observer{
	protected Player player;
	protected Difficulty difficulty;
    protected Ui currentScreen;
    protected ArrayList<Enemy> enemies;
    protected static String displayDifficulty = Constants.EASY_TEXT;
    
	
	public Ui(Difficulty dificulty, Player player,ArrayList<Enemy> enemies){
		this.difficulty = dificulty;
		this.player = player;
		this.enemies = enemies;
        
	}
	
	public void setUserInterface(Ui currentScreen) {
        this.currentScreen = currentScreen;
		currentScreen.draw();
	}
	
	public abstract void draw();
}
