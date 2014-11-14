package UI;

import javax.swing.*;


import Command.MovePlayerInvoker;
import Command.PlayerMoveCommand;
import Constants.Constants;
import Decorator.EnemyTeleportDecorator;
import Memento.CareTaker;
import MouseListener.CustomMouseListener;
import Observer.Enemy;
import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import Decorator.Decorator;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameUi extends Ui {

	private Player player;
	private MovePlayerInvoker playerInvoker;
	private PlayerMoveCommand move;
	private CareTaker careTaker = new CareTaker();
	private JPanel[][] squares;
	private JPanel panel;
	private JButton undoButton;
	private int count;
    private Difficulty d ;
    private ArrayList<Enemy> e;
	JTextArea movesLeft;

	public GameUi(Difficulty difficulty, Player player, ArrayList<Enemy> enemies) {
		// TODO Auto-generated constructor stub
		super(difficulty, player, enemies);
        this.d = difficulty ;
        this.e = enemies;
        super.currentScreen = this;
        count = Constants.ALLOWED_MOVES ;
        System.out.println("COUNT IS " + count);
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
		setTitle(Constants.GAME_TITLE);
		setSize(Constants.SCREEN_DIMENSIONS,Constants.SCREEN_DIMENSIONS);
		setResizable(Constants.TRUE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setFocusable(Constants.TRUE);
		setVisible(Constants.TRUE);
		panel.setLayout(new GridLayout(Constants.INT_ROWS + 1, Constants.INT_COLS + 1));
		squares = new JPanel[Constants.INT_ROWS][Constants.INT_COLS];
		resetGrid(Constants.TRUE);

		squares[Constants.GOAL][Constants.GOAL].setBackground(Color.GREEN);

		JTextArea difficultyTitle = new JTextArea();
		difficultyTitle.setText(Constants.DIFFICULTY);
		panel.add(difficultyTitle);

		JTextArea difficultyLED= new JTextArea();
		difficultyLED.setText(difficulty.getDifficultyText());
		panel.add(difficultyLED);
		

		for (int i = 0; i < super.enemies.size(); i++) {
			squares[super.enemies.get(i).getEnemyRowPosition()][super.enemies.get(i)
					.getEnemyColPosition()].setBackground(super.enemies.get(i)
                    .getColor());
		}
		
		panel.add(undoButton);
		
		movesLeft= new JTextArea();
		movesLeft.setText(Integer.toString(count));
		panel.add(movesLeft);

        
		add(panel);
   
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
					move.setDirection(Constants.UP);
					playerInvoker.arrowKeyPressed();
				} else if (c == KeyEvent.VK_DOWN) {
					move.setDirection(Constants.DOWN);
					playerInvoker.arrowKeyPressed();
				} else if (c == KeyEvent.VK_LEFT) {
					move.setDirection(Constants.LEFT);
					playerInvoker.arrowKeyPressed();
				} else if (c == KeyEvent.VK_RIGHT) {
					move.setDirection(Constants.RIGHT);
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
					System.out.println(Constants.NO_MORE_MOVE_RESPONSE); 
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

		resetGrid(Constants.FALSE);
        System.out.println("COUNT IN UPODATE MAZE ID" + count);
        count--;
        if(count >= Constants.ZERO) {
            movesLeft.setText(Integer.toString(count));

        }
        if(count == Constants.ZERO){
            Decorator gameUiDecorator = new EnemyTeleportDecorator(this.d,  this.player, this.e, this);
            gameUiDecorator.draw();

        }


		for (int i = 0; i < super.enemies.size(); i++) {
			squares[super.enemies.get(i).getEnemyRowPosition()][super.enemies.get(i)
					.getEnemyColPosition()].setBackground(super.enemies.get(i)
					.getColor());
		}

		squares[Constants.GOAL][Constants.GOAL].setBackground(Color.GREEN);

		squares[player.getPlayerRowCoordinate()][player.getPlayerColCoordinate()]
				.setBackground(player.getColor());

		/*
		 * WESLEYS CODE
		 */
		if (player.getPlayerRowCoordinate() == Constants.GOAL
				&& player.getPlayerColCoordinate() == Constants.GOAL) {
			player.resetPlayerCoordinates();
			
			for(int i = 0;i < super.enemies.size();i++){
			super.enemies.get(i).setEnemyCoordinates(Enemy.randomEnemyPosition());
			}

			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(this,
					Constants.GAME_PASSED_RESPONSE);

			Ui userInterface = new MenuUi(difficulty, player, enemies);
			userInterface.draw();


		}


	}

	public void resetGrid(boolean needToInitialze) {
		for (int i = 0; i < Constants.INT_ROWS; i++) {
			for (int j = 0; j < Constants.INT_COLS; j++) {
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
	

}