package de.composite;

public class Receiver {
	private final String name;
	private final String adress;
	
	
	public Receiver(String name, String adress) {
		this.name = name;
		this.adress = adress;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public String toString(){
		return this.name +" -  " +this.adress;
	}

}
