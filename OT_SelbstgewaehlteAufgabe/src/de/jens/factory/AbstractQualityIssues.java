package de.jens.factory;

public abstract class AbstractQualityIssues implements I_HasReportedQualityIssues{
	private String name;
	private Person responsible;
	
	public AbstractQualityIssues(String name, Person responsible){
		this.name=name;
		this.responsible=responsible;
	}
	
	public Person getResponsiblePerson(){
		return this.responsible;
	}
	
	public String getName(){
		return this.name;
	}

}
