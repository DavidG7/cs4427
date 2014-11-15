package UI;

import Constants.Constants;
import MouseListener.CustomMouseListener;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/*
The graphic user interface for the difficulty options
 */
public class DifficultyUi extends Ui {

    /*
	Instantiates the Difficulty UI
	@param dificulty	the difficulty to be set
	@param player		an instance of the Player
	@param enemies		an array of enemies
	 */
	public DifficultyUi(Difficulty dificulty, Player player,ArrayList<Enemy> enemies) {
		// TODO Auto-generated constructor stub
		super(dificulty, player,enemies);
		dificulty.attach(this);
		System.out.println(Constants.ATTACH_DIFFICULTYUI);
		super.currentScreen = this;
	}

	GridLayout grid = new GridLayout(Constants.MENU_OPTIONS_ROWS, Constants.MENU_OPTIONS_COLUMNS);
	JPanel panel = new JPanel();
	JLabel difficultyLED = new JLabel(Constants.DIFFICULTY + Constants.SEMI_COLON + displayDifficulty, JLabel.CENTER);
	JLabel easy = new JLabel(Constants.EASY_TEXT, JLabel.CENTER);
	JLabel medium = new JLabel(Constants.MEDIUM_TEXT, JLabel.CENTER);
	JLabel hard = new JLabel(Constants.HARD_TEXT, JLabel.CENTER);
	JButton back = new JButton(Constants.BACK);


    /*
	Implementation of UI's draw() method
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		setTitle(Constants.OPTIONS);
		setSize(Constants.SCREEN_DIMENSIONS,Constants.SCREEN_DIMENSIONS);
		setResizable(Constants.TRUE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setBackground(Color.BLACK);
		panel.setLayout(grid);
		difficultyLED.setFont(new Font("Serif", Font.PLAIN, Constants.MENU_OPTIONS_TEXT_SIZE_HEADING));
		easy.setFont(new Font("Serif", Font.PLAIN, Constants.MENU_OPTIONS_TEXT_SIZE));
		medium.setFont(new Font("Serif", Font.PLAIN, Constants.MENU_OPTIONS_TEXT_SIZE));
		hard.setFont(new Font("Serif", Font.PLAIN, Constants.MENU_OPTIONS_TEXT_SIZE));
		difficultyLED.setForeground(Color.RED);
		easy.setForeground(Color.RED);
		medium.setForeground(Color.RED);
		hard.setForeground(Color.RED);
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.RED);
		panel.add(difficultyLED);
		panel.add(easy);
		panel.add(medium);
		panel.add(hard);
		panel.add(back);
		add(panel);
		setVisible(Constants.TRUE);

		easy.addMouseListener(new CustomMouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				displayDifficulty = Constants.EASY_TEXT;
				difficulty.setDifficulty(Constants.EASY_DIFFICULTY);
			
			}
		});

		medium.addMouseListener(new CustomMouseListener() {


			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				displayDifficulty = Constants.MEDIUM_TEXT;
				difficulty.setDifficulty(Constants.MEDIUM_DIFFICULTY);
			}
		});

		hard.addMouseListener(new CustomMouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				displayDifficulty = Constants.HARD_TEXT;
				difficulty.setDifficulty(Constants.HARD_DIFFICULTY);
			}
		});
		
		back.addMouseListener(new CustomMouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setUserInterface(new MenuUi(difficulty, player,enemies));
				DifficultyUi.this.dispose();
			}
		});
		
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		    System.out.println("DISPLAY DIFFICULTY IS " + displayDifficulty);
			difficultyLED.setText(Constants.DIFFICULTY + Constants.SPACE + displayDifficulty);
	
	}



}