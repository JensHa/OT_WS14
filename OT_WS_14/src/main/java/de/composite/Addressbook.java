package de.composite;

import java.util.HashMap;

public class Addressbook {
	HashMap<Integer, Receiver>book=new HashMap<Integer, Receiver>();
	


	public void add(int id, Receiver receiver) {
		book.put(id, receiver);
	}
	
	public Receiver remove(int id){
		return book.remove(id);
	}

	public int getSize() {
		return book.size();
	}

	public Receiver getEntry(int i) {
		return book.get(i);
	}

}
