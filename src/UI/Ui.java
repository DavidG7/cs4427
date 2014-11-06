package UI;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Observer.Enemy;
import Observer.Observer;
import Singleton.Player;
import Subject.Difficulty;


public abstract class Ui extends JFrame implements Observer{
	Player player;
	Difficulty difficulty;
    Ui currentScreen;
    Enemy[] enemies;
	
	public Ui(Difficulty dificulty, Player player,Enemy[] enemies){
		this.difficulty = dificulty;
		this.player = player;
		this.enemies = enemies;
        
	}
	
	public void setUserInterface(Ui currentScreen){
		this.currentScreen = currentScreen;
		currentScreen.draw();
	}
	
	public abstract void draw();
	


}
