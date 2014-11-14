package Decorator;

import Observer.Enemy;
import Singleton.Player;
import Subject.Subject;
import Subject.Difficulty;

import UI.Ui;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Wesley on 12/11/2014.
 */
public abstract class Decorator extends Ui{

    private Ui ui;

    public Decorator(Difficulty dificulty, Player player, ArrayList<Enemy> enemies, Ui uiRef) {
        super(dificulty, player,enemies);
        this.ui = uiRef ;
    }

    @Override
    public abstract void draw();

}
