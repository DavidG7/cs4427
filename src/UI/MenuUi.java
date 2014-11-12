package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Constants.Constants;
import MouseListener.CustomMouseListener;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;

public class MenuUi extends Ui {

	private GridLayout grid = new GridLayout(Constants.MENU_OPTIONS_ROWS, Constants.MENU_OPTIONS_COLUMNS);
	private JPanel panel = new JPanel();
	private JLabel gameTitle = new JLabel(Constants.GAME_TITLE, JLabel.CENTER);
	private JLabel start = new JLabel(Constants.START, JLabel.CENTER);
	private JLabel options = new JLabel(Constants.OPTIONS, JLabel.CENTER);
	private JLabel exit = new JLabel(Constants.EXIT, JLabel.CENTER);
	
	public MenuUi(Difficulty dificulty, Player player,Enemy[] enemies) {
		super(dificulty, player,enemies);
		// TODO Auto-generated constructor stub
		// DOESNT OBSERVER PLAYER OR DIFFICULTY
	     super.currentScreen = this;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
        
		setTitle(Constants.MENU_TITLE);
		setSize(Constants.SCREEN_DIMENSIONS,Constants.SCREEN_DIMENSIONS);
		setResizable(Constants.TRUE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setBackground(Color.BLACK);
		panel.setLayout(grid);
		gameTitle.setFont(new Font("Serif", Font.PLAIN, Constants.MENU_OPTIONS_TEXT_SIZE_HEADING));
		start.setFont(new Font("Serif", Font.PLAIN, Constants.MENU_OPTIONS_TEXT_SIZE));
		options.setFont(new Font("Serif", Font.PLAIN, Constants.MENU_OPTIONS_TEXT_SIZE));
		exit.setFont(new Font("Serif", Font.PLAIN, Constants.MENU_OPTIONS_TEXT_SIZE));
		gameTitle.setForeground(Color.RED);
		start.setForeground(Color.RED);
		options.setForeground(Color.RED);
		exit.setForeground(Color.RED);
		panel.add(gameTitle);
		panel.add(start);
		panel.add(options);
		panel.add(exit);
		add(panel);
		setVisible(Constants.TRUE);
        
		start.addMouseListener(new CustomMouseListener(){
        	@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				setUserInterface(new GameUi(difficulty, player,enemies));
				MenuUi.this.dispose();
				
			}
		});
        
		options.addMouseListener(new CustomMouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				setUserInterface(new DifficultyUi(difficulty, player,enemies));
				MenuUi.this.dispose();
				
			}
		});

		exit.addMouseListener(new CustomMouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(-1);
			}
		});
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		// DOESNT OBSERVE PLAYER OR DIFFICULTY
	}

}
