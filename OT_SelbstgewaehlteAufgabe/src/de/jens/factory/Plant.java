package de.jens.factory;


public  class Plant extends NodeOfQualityIssues<Area>{
	
	
	public Plant(String name, Person responsible) {
		super(name, responsible);
	}

	@Override
	public void accept(I_Visitor visitor) {
		visitor.visit(this);
	}

}
