package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import MouseListener.CustomMouseListener;
import Observer.SystemObserver;
import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;

public class DifficultyUi extends Ui {

	/*
	Creates a the difficulty user interface

	@param dificulty	the current difficulty
	@param player		an instance of the Player
 */
	public DifficultyUi(Difficulty dificulty, Player player) {
		super(dificulty, player);
		dificulty.attach(this);
		player.attach(this);
		// TODO Auto-generated constructor stub
		super.currentScreen = this;
	}

	GridLayout grid = new GridLayout(5, 1);
	JPanel panel = new JPanel();
	JLabel difficultyLED = new JLabel("DIFFICULTY : EASY", JLabel.CENTER);
	JLabel easy = new JLabel("EASY", JLabel.CENTER);
	JLabel medium = new JLabel("MEDIUM", JLabel.CENTER);
	JLabel hard = new JLabel("HARD", JLabel.CENTER);
	JLabel[] labels = { easy, medium, hard };
	JButton back = new JButton("BACK");


	@Override
	public void draw() {
		// TODO Auto-generated method stub
		setTitle("Options");
		setSize(400, 400);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setBackground(Color.BLACK);
		panel.setLayout(grid);
		difficultyLED.setFont(new Font("Serif", Font.PLAIN, 25));
		easy.setFont(new Font("Serif", Font.PLAIN, 20));
		medium.setFont(new Font("Serif", Font.PLAIN, 20));
		hard.setFont(new Font("Serif", Font.PLAIN, 20));
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
		setVisible(true);

		easy.addMouseListener(new CustomMouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				difficulty.setDifficulty(0);
			}
		});

		medium.addMouseListener(new CustomMouseListener() {


			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				difficulty.setDifficulty(1);
			}
		});

		hard.addMouseListener(new CustomMouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				difficulty.setDifficulty(2);
			}
		});
		
		back.addMouseListener(new CustomMouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setUserInterface(new MenuUi(difficulty, player));
				DifficultyUi.this.dispose();
			}
		});
		
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		if (subject instanceof Difficulty) {
			int difficulty = ((Difficulty) subject).getDifficulty();
			System.out.println("Ui updated! new difficulty is " + difficulty);
			difficultyLED.setText("DIFFICULTY : "
					+ ((Difficulty) subject).getDifficultyText());
		} else if (subject instanceof Player) {
			System.out.println("Draw scene");
		}
	}



}