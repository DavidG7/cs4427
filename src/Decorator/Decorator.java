package Decorator;

import Observer.Enemy;
import Singleton.Player;
import Subject.Subject;
import Subject.Difficulty;

import UI.Ui;

/**
 * Created by Wesley on 12/11/2014.
 */
public class Decorator extends Ui{

    private Ui ui= null ;

    public Decorator(Difficulty dificulty, Player player, Enemy[] enemies, Ui uiRef) {
        super(dificulty, player,enemies);
        this.ui = uiRef ;
    }

    @Override
    public void draw(){
            ui.draw() ;
    }


    @Override
    public void update(Subject subject) {
        // TODO Auto-generated method stub
    }
}
