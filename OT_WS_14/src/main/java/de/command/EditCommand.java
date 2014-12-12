package de.command;

public class EditCommand implements Command {
	
	private Addressbook adressbook;
	private Receiver receiver;
	private int id;
	private Receiver oldEntry;

	public EditCommand(Addressbook adressbook, Receiver receiver, int id) {
		this.adressbook=adressbook;
		this.receiver=receiver;
		this.id=id;
	}


	public void execute() {
		oldEntry=adressbook.remove(id);
		adressbook.add(id, receiver);
	}

	public void undo() {
		adressbook.remove(id);
		adressbook.add(id, oldEntry);
	}

}
