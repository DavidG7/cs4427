
package Command;

import Singleton.Player;

/*
Moves the player
*/
public class PlayerMoveCommand implements Command {

	Player player;
	String direction = "";

	/*
	@param player	an instance of Player
	 */
	public PlayerMoveCommand(Player player){
		this.player = player;
	}
	
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
