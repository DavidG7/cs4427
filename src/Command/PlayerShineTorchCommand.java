package Command;

import Singleton.Player;

public class PlayerShineTorchCommand implements Command {

    Player player;
	
	public PlayerShineTorchCommand(Player player){
		this.player = player;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
        player.shineTorch();
	}

}
