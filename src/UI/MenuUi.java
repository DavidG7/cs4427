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

import MouseListener.CustomMouseListener;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;

public class MenuUi extends Ui {

	private GridLayout grid = new GridLayout(5, 1);
	private JPanel panel = new JPanel();
	private JLabel gameTitle = new JLabel("CORRIDOR HORROR", JLabel.CENTER);
	private JLabel start = new JLabel("START", JLabel.CENTER);
	private JLabel options = new JLabel("OPTIONS", JLabel.CENTER);
	private JLabel exit = new JLabel("EXIT", JLabel.CENTER);
	
	public MenuUi(Difficulty dificulty, Player player,Enemy[] enemies) {
		super(dificulty, player,enemies);
		// TODO Auto-generated constructor stub
		// DOESNT OBSERVER PLAYER OR DIFFICULTY
	     super.currentScreen = this;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
        
		setTitle("Menu");
		setSize(400, 400);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setBackground(Color.BLACK);
		panel.setLayout(grid);
		gameTitle.setFont(new Font("Serif", Font.PLAIN, 25));
		start.setFont(new Font("Serif", Font.PLAIN, 20));
		options.setFont(new Font("Serif", Font.PLAIN, 20));
		exit.setFont(new Font("Serif", Font.PLAIN, 20));
		gameTitle.setForeground(Color.RED);
		start.setForeground(Color.RED);
		options.setForeground(Color.RED);
		exit.setForeground(Color.RED);
		panel.add(gameTitle);
		panel.add(start);
		panel.add(options);
		panel.add(exit);
		add(panel);
		setVisible(true);
        
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
