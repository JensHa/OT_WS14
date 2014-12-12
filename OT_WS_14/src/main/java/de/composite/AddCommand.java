package de.composite;

public class AddCommand implements Command{


	private Addressbook adressbook;
	private int id;
	private Receiver receiver;

	public AddCommand(Addressbook adressbook, Receiver receiver, int id) {
		this.adressbook=adressbook;
		this.receiver=receiver;
		this.id=id;
	}

	public void execute() {
		adressbook.add(id,receiver);	
	}

	public void undo() {
		adressbook.remove(id);
	}

}
