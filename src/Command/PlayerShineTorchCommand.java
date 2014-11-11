package Command;

import Singleton.Player;

/*
Shines the torch
 */
public class PlayerShineTorchCommand implements Command {

    Player player;

	/*
	Creates an instance of PlayerShineTorchCommand

	@param player 	an instance of type Player
	 */
	public PlayerShineTorchCommand(Player player){
		this.player = player;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
        player.shineTorch();
	}

}
