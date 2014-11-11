package UI;

import javax.swing.*;

import Command.Invoker;
import Command.PlayerMoveCommand;
import Command.PlayerShineTorchCommand;

import Singleton.Player;
import Subject.Difficulty;
import Subject.Subject;
import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameUi extends Ui {
    private static final int intRows = 10;
    private static final int intCols = 10;
    private Player player;
    Invoker playerInvoker;
    PlayerMoveCommand move;
    PlayerShineTorchCommand shineTorch;
    JPanel[][] squares;
    int[] lastPlayerCoordinates = { 0, 0 };

    /*
    Creates a the game user interface

	@param difficulty	the current difficulty
	@param player		an instance of the Player
     */
    public GameUi(Difficulty difficulty, Player player) {
        super(difficulty, player);
        difficulty.attach(this);
        player.attach(this);
        System.out.println("Game Ui attached");
        super.currentScreen = this;
        this.player = player;
        move = new PlayerMoveCommand(player);
        playerInvoker = new Invoker();
        shineTorch = new PlayerShineTorchCommand(player);
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
        setFocusable(true);
        setVisible(true);
        panel.setLayout(new GridLayout(intRows + 1, intCols + 1));
        squares = new JPanel[intRows][intCols];

        for (int i = 0; i < intRows; i++) {
            for (int j = 0; j < intCols; j++) {
                squares[i][j] = new JPanel();
                if ((i + j) % 2 != 0) {
                    squares[i][j].setBackground(Color.BLACK);
                }else{
                    squares[i][j].setBackground(Color.WHITE);
                }

                squares[0][0].setBackground(player.getColor());
                panel.add(squares[i][j]);
            }

        }
        squares[8][8].setBackground(Color.GREEN);

        JTextArea diff = new JTextArea();
        diff.setText("Difficulty");
        panel.add(diff);

        JTextArea text = new JTextArea();
        text.setText(difficulty.getDifficultyText());
        panel.add(text);

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
        // System.out.println(player.getPlayerCoordinates()[0]);
        System.out.println("X:" + player.getPlayerXCoordinate());
        System.out.println("Y:" + player.getPlayerYCoordinate());
        updateMaze();
    }

    public void updateMaze() {
        if ((lastPlayerCoordinates[0] + lastPlayerCoordinates[1]) % 2 != 0) {
            squares[lastPlayerCoordinates[0]][lastPlayerCoordinates[1]]
                    .setBackground(Color.BLACK);
        } else {
            squares[lastPlayerCoordinates[0]][lastPlayerCoordinates[1]]
                    .setBackground(Color.WHITE);
        }


        squares[player.getPlayerXCoordinate()][player.getPlayerYCoordinate()]
                .setBackground(player.getColor());
        lastPlayerCoordinates[0] = player.getPlayerXCoordinate();
        lastPlayerCoordinates[1] = player.getPlayerYCoordinate();

        if(player.getPlayerXCoordinate() == 8 && player.getPlayerYCoordinate() == 8){
            player.resetPlayerCoordinates();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(this, "Success, you have successfully navigated the Maze!!!");
            this.dispose() ;
            Ui userInterface = new MenuUi(difficulty, player);
            userInterface.draw();
        }
    }

}