package UI;

import javax.swing.JFrame;

import Observer.SystemObserver;
import Singleton.Player;
import Subject.Difficulty;


public abstract class Ui extends JFrame implements SystemObserver{
	Player player;
	Difficulty difficulty;
    Ui currentScreen;
	
	public Ui(Difficulty dificulty, Player player){
		this.difficulty = dificulty;
		this.player = player;
        
	}
	
	public void setUserInterface(Ui currentScreen){
		this.currentScreen = currentScreen;
		currentScreen.draw();
	}
	
	public abstract void draw();

}
