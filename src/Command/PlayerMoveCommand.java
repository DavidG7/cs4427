
package Command;

import Singleton.Player;

public class PlayerMoveCommand implements Command {

	Player player;
	String direction = "";
	
	public PlayerMoveCommand(Player player){
		this.player = player;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
        player.move(direction);
	}

	public void setDirection(String direction){
		this.direction = direction;
	}
}
