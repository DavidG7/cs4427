package Command;

public class MovePlayerInvoker {
	Command command;
	
	public MovePlayerInvoker(Command command){
		this.command = command;
	}
	
	public void arrowKeyPressed(){
		command.execute();
	}

}

