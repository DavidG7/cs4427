package Command;

public class Invoker {
	Command command;
	
	public Invoker(){}

	/*
	@param command	the command to be set
	 */
	public void setCommand(Command command){
		this.command = command;
	}
	
	public void buttonPressed(){
		command.execute();
	}

}
