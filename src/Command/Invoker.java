package Command;

public class Invoker {
	Command command;
	
	public Invoker(){}
	
	public void setCommand(Command command){
		this.command = command;
	}
	
	public void buttonPressed(){
		command.execute();
	}

}
