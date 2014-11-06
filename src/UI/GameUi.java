package UI;

import javax.swing.*;

import Command.Invoker;
import Command.PlayerMoveCommand;
import Command.PlayerShineTorchCommand;
import Factory.EnemyFactory;

import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;
import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GameUi extends Ui {

	private static final int GOAL = 9;
	private static final int INT_ROWS = 10;
	private static final int INT_COLS = 10;
	private Player player;
	private Invoker playerInvoker;
	private PlayerMoveCommand move;
	private PlayerShineTorchCommand shineTorch;
	private JPanel[][] squares;
	private JPanel panel;


	public GameUi(Difficulty difficulty, Player player, Enemy[] enemies) {
		// TODO Auto-generated constructor stub
		super(difficulty, player, enemies);
		super.currentScreen = this;
		
		//ATTACH AS OBSERVER TO DIFFICULTY AND PLAYER
		difficulty.attach(this);
		player.attach(this);
		System.out.println("Game Ui attached to difficulty and player");

		this.player = player;
		move = new PlayerMoveCommand(player);
		playerInvoker = new Invoker();
		shineTorch = new PlayerShineTorchCommand(player);
		panel = new JPanel();
	}



	@Override
	public void draw() {
		// TODO Auto-generated method stub
		setTitle("Maze Runner");
		setSize(400, 400);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setFocusable(true);
		setVisible(true);
		panel.setLayout(new GridLayout(INT_ROWS + 1, INT_COLS + 1));
		squares = new JPanel[INT_ROWS][INT_COLS];
        resetGrid(true);
		

		squares[GOAL][GOAL].setBackground(Color.GREEN);

		JTextArea diff = new JTextArea();
		diff.setText("Difficulty");
		panel.add(diff);

		JTextArea text = new JTextArea();
		text.setText(difficulty.getDifficultyText());
		panel.add(text);

		for (int i = 0; i < super.enemies.length; i++) {
			squares[super.enemies[i].getEnemyRowPosition()][super.enemies[i]
					.getEnemyColPosition()].setBackground(super.enemies[i]
					.getColor());
		}

		add(panel);

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				playerInvoker.setCommand(move);
				int c = e.getKeyCode();
				if (c == KeyEvent.VK_UP) {
					move.setDirection("UP");
					playerInvoker.buttonPressed();
				} else if (c == KeyEvent.VK_DOWN) {
					move.setDirection("DOWN");
					playerInvoker.buttonPressed();
				} else if (c == KeyEvent.VK_LEFT) {
					move.setDirection("LEFT");
					playerInvoker.buttonPressed();
				} else if (c == KeyEvent.VK_RIGHT) {
					move.setDirection("RIGHT");
					playerInvoker.buttonPressed();
				} else if (c == KeyEvent.VK_ENTER) {
					playerInvoker.setCommand(shineTorch);
					playerInvoker.buttonPressed();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		updateMaze();
	}

	public void updateMaze() {
	
		resetGrid(false);

		for (int i = 0; i < super.enemies.length; i++) {
			squares[super.enemies[i].getEnemyRowPosition()][super.enemies[i]
					.getEnemyColPosition()].setBackground(super.enemies[i]
					.getColor());
		}

		squares[9][9].setBackground(Color.GREEN);

		squares[player.getPlayerXCoordinate()][player.getPlayerYCoordinate()]
				.setBackground(player.getColor());

		/*
		 * WESLEYS CODE
		 */
		if (player.getPlayerXCoordinate() == 9
				&& player.getPlayerYCoordinate() == 9) {
			player.resetPlayerCoordinates();
			super.enemies[0].setEnemyCoordinates(Enemy.randomEnemyPosition());
			super.enemies[1].setEnemyCoordinates(Enemy.randomEnemyPosition());
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(this,
					"Success, you have successfully navigated the Maze!!!");
			this.dispose();
			Ui userInterface = new MenuUi(difficulty, player, enemies);
			userInterface.draw();

		}

	}
	
	
	public void resetGrid(boolean needToInitialze){
		for (int i = 0; i < INT_ROWS; i++) {
			for (int j = 0; j < INT_COLS; j++) {
				if(needToInitialze)
				squares[i][j] = new JPanel();
				if ((i + j) % 2 != 0) {
					squares[i][j].setBackground(Color.BLACK);
				} else {
					squares[i][j].setBackground(Color.WHITE);
				}
				if(needToInitialze){
				squares[0][0].setBackground(player.getColor());

				panel.add(squares[i][j]);
				}
			}
		}
	}


}