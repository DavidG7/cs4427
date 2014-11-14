package Decorator;

import Observer.Enemy;
import Singleton.Player;
import Subject.Subject;
import UI.Ui;
import Subject.Difficulty;
import java.util.ArrayList;

/**
 * Created by Wesley on 14/11/2014.
 */
public class EnemyTeleportDecorator extends Decorator{

    private Ui ui;

    public EnemyTeleportDecorator(Difficulty dificulty, Player player, ArrayList<Enemy> enemies, Ui uiRef) {
        super(dificulty, player,enemies,uiRef);
        this.ui = uiRef ;
    }
    @Override
    public void draw() {
        doSomethingCool();
    }


    public void doSomethingCool(){
          for(int i = 0; i < super.enemies.size();i++) {
              super.enemies.get(i).doSomethingCool();
          }
    }

    @Override
    public void update(Subject subject) {

    }
}
