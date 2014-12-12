package de.composite;

public class DeleteCommand implements Command{
	
	private Addressbook adressbook;
	private int id;
	private Receiver deletedEntry;

	public DeleteCommand(Addressbook adressbook, int id) {
		this.adressbook=adressbook;
		this.id=id;
	}


	public void execute() {
		deletedEntry=adressbook.remove(id);		
	}

	public void undo() {
		adressbook.add(id, deletedEntry);		
	}

}
