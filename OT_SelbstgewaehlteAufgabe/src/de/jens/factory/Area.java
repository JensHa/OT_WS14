package de.jens.factory;


public class Area extends NodeOfQualityIssues<I_AreaPart>{

	public Area(String name, Person responsible) {
		super(name, responsible);
	}

	@Override
	public void accept(I_Visitor visitor) {
		visitor.visit(this);
	}

}
