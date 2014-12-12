package de.command;

import java.util.ArrayList;

public class ContactManager {
	
	ArrayList<Command> commands = new ArrayList<Command>();
	
	public void execute(Command command){
		command.execute();
		commands.add(command);
	}
	
	public void undo(){
		if(commands.size()>0){
		commands.remove(commands.size()-1).undo();
		}else{
			System.out.println("no more commands");
		}
		
	}

}
