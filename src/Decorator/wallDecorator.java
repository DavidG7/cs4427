package Decorator;

import Constants.Constants;
import Observer.Enemy;
import Singleton.Player;
import Subject.Subject;
import UI.Ui;
import Subject.Difficulty ;

public class wallDecorator extends Decorator {

    private Object wallObject = null ;

	public wallDecorator(Difficulty dificulty, Player player, Enemy[] enemies, Ui uiRef) {
		super(dificulty, player,enemies,uiRef);
        this.wallObject = uiRef;
	}

    @Override
    public void draw() {
        System.out.println("PLease for god sake be Adding wall");
        //super.draw();
        addWall();
    }

	@Override
	public void update(Subject subject) {
	}

    private void addWall() {
        System.out.println(this.wallObject.toString());
    }

}
