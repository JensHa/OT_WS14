package de.jens.factory;

public class AutomaticProducer extends AbstractProducer{

	public AutomaticProducer(int workloadOfUnit, String name, Person responsible) {
		super(workloadOfUnit, name, responsible);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(I_Visitor visitor) {
		visitor.visit(this);
	}


}
