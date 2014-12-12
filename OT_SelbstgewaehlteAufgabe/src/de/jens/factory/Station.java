package de.jens.factory;


public class Station extends NodeOfQualityIssues<AbstractProducer> implements I_AreaPart{
	
	
	public Station(String name, Person responsible) {
		super(name, responsible);
	}

	@Override
	public void accept(I_Visitor visitor) {
		visitor.visit(this);
	}

}
