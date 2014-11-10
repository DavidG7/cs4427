package UI;

import javax.swing.*;


import Command.MovePlayerInvoker;
import Command.PlayerMoveCommand;
import Factory.EnemyFactory;

import Memento.CareTaker;
import Memento.PlayerCareTaker;
import MouseListener.CustomKeyListener;
import MouseListener.CustomMouseListener;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GameUi extends Ui {

	private static final int GOAL = 9;
	private static final int INT_ROWS = 10;
	private static final int INT_COLS = 10;
	private Player player;
	private MovePlayerInvoker playerInvoker;
	private PlayerMoveCommand move;
	private CareTaker careTaker = new CareTaker();
	private JPanel[][] squares;
	private JPanel panel;
	private JButton undoButton;

	public GameUi(Difficulty difficulty, Player player, Enemy[] enemies) {
		// TODO Auto-generated constructor stub
		super(difficulty, player, enemies);
		super.currentScreen = this;

		// ATTACH AS OBSERVER TO DIFFICULTY AND PLAYER
		difficulty.attach(this);
		player.attach(this);
		System.out.println("Game Ui attached to difficulty and player");

		this.player = player;
		move = new PlayerMoveCommand(player);
		playerInvoker = new MovePlayerInvoker(move);
	
		panel = new JPanel();
		undoButton = new JButton();
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
		
		panel.add(undoButton);
        add(panel);
       // panel.requestFocusInWindow();
        addKeyListener(new KeyListener() {
        	
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				careTaker.add(player.saveStateToMemento());
				int c = e.getKeyCode();
				if (c == KeyEvent.VK_UP) {
					move.setDirection("UP");
					playerInvoker.arrowKeyPressed();
				} else if (c == KeyEvent.VK_DOWN) {
					move.setDirection("DOWN");
					playerInvoker.arrowKeyPressed();
				} else if (c == KeyEvent.VK_LEFT) {
					move.setDirection("LEFT");
					playerInvoker.arrowKeyPressed();
				} else if (c == KeyEvent.VK_RIGHT) {
					move.setDirection("RIGHT");
					playerInvoker.arrowKeyPressed();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
        
        
        undoButton.addMouseListener(new CustomMouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				 try{
				 player.getStateFromMemento(careTaker.get(careTaker.getNumberOfMoves()-1));
			     careTaker.remove(careTaker.get(careTaker.getNumberOfMoves()-1));
			
				 }catch(ArrayIndexOutOfBoundsException exception){
					exception.printStackTrace();
					System.out.println("No more moves to undo"); 
				 }
				
		    
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

		squares[player.getPlayerRowCoordinate()][player.getPlayerColCoordinate()]
				.setBackground(player.getColor());

		/*
		 * WESLEYS CODE
		 */
		if (player.getPlayerRowCoordinate() == 9
				&& player.getPlayerColCoordinate() == 9) {
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

	public void resetGrid(boolean needToInitialze) {
		for (int i = 0; i < INT_ROWS; i++) {
			for (int j = 0; j < INT_COLS; j++) {
				if (needToInitialze)
					squares[i][j] = new JPanel();
				if ((i + j) % 2 != 0) {
					squares[i][j].setBackground(Color.BLACK);
				} else {
					squares[i][j].setBackground(Color.WHITE);
				}
				if (needToInitialze) {
					squares[0][0].setBackground(player.getColor());

					panel.add(squares[i][j]);
				}
			}
		}
		
	}
	
	public void focusLost(FocusEvent e) {
        throw new StackOverflowError();
    }

}