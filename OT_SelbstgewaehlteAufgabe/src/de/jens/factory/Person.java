package de.jens.factory;

public class Person {
	private String nameOfPerson;
	
	public Person(String name){
		this.nameOfPerson=name;
	}
	
	public String getName(){
		return this.nameOfPerson;
	}
	
	public void sendMessage(String message){
		System.out.println();
	}
	
}
