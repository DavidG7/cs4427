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
import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;

public class MenuUi extends Ui {

	public MenuUi(Difficulty dificulty, Player player) {
		super(dificulty, player);
		// TODO Auto-generated constructor stub
		// DOESNT OBSERVER PLAYER OR DIFFICULTY
	     super.currentScreen = this;
	}

	GridLayout grid = new GridLayout(5, 1);
	JPanel panel = new JPanel();
	JLabel gameTitle = new JLabel("CORRIDOR HORROR", JLabel.CENTER);
	JLabel start = new JLabel("START", JLabel.CENTER);
	JLabel options = new JLabel("OPTIONS", JLabel.CENTER);
	JLabel exit = new JLabel("EXIT", JLabel.CENTER);
	JLabel[] labels = { start, options, exit };

	@Override
	public void draw() {
		// TODO Auto-generated method stub
        
		setTitle("Difficulty");
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

		options.addMouseListener(new CustomMouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// MenuUi.super.setUserInterface(new
				// DifficultyUi(difficultySystem, player));
				// MenuUi.super.draw();
				
				setUserInterface(new DifficultyUi(difficulty, player));
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
