package UI;

import javax.swing.JFrame;

import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;



public class GameUi extends Ui{

	public GameUi(Difficulty dificulty, Player player) {
		super(dificulty, player);
		dificulty.attach(this);
		player.attach(this);
		System.out.println("Game Ui attached");
		super.currentScreen = this;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		
	}

}
