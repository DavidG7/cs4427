package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;
import java.awt.*;


import java.util.ArrayList;


public class GameUi extends Ui{
    private static final int intRows = 10;
    private static final int intCols = 10;
    private Player player ;

    public GameUi(Difficulty difficulty, Player player) {
		super(difficulty, player);
		difficulty.attach(this);
		player.attach(this);
		System.out.println("Game Ui attached");
		super.currentScreen = this;
        player = player.getInstance();
		// TODO Auto-generated constructor stub
	}
    JPanel panel = new JPanel();

	@Override
	public void draw() {
		// TODO Auto-generated method stub
        setTitle("Maze Runner");
        setSize(700, 700);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        panel.setLayout(new GridLayout(intRows + 1,intCols + 1));
        JPanel[][] squares = new JPanel[intRows][intCols];

        for(int i = 0 ; i < intRows ; i++){
            for(int j = 0 ; j < intCols ; j++){
                squares[i][j] = new JPanel();
                if((i + j) % 2 != 0){
                    squares[i][j].setBackground(Color.black);
                }
                panel.add(squares[i][j]);
            }

        }
        JTextArea diff = new JTextArea();
        diff.setText("Difficulty");
        panel.add(diff);

        JTextArea text = new JTextArea();
        text.setText(difficulty.getDifficultyText());
        panel.add(text);

        add(panel);




	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		System.out.println(player.getPlayerCoordinates()[0]);
	}

}
