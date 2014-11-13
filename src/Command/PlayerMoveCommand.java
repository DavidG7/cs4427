
package Command;

import Singleton.Player;

public class PlayerMoveCommand implements Command {

	Player player;
	String direction = "";

	/*
	@param player	the player that will be moved
	 */
	public PlayerMoveCommand(Player player){
		this.player = player;
	}

	/*
	Implementation of the Command interface's execute function
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
        player.move(direction);
	}

	/*
	@param direction	the direction the player wants to move
	 */
	public void setDirection(String direction){
		this.direction = direction;
	}
}
