package de.jens.factory;


public class AsemblyLine extends NodeOfQualityIssues<Station> implements I_AreaPart{

	public AsemblyLine(String name, Person responsible) {
		super(name, responsible);
	}

	@Override
	public void accept(I_Visitor visitor) {
		visitor.visit(this);
	}
}
