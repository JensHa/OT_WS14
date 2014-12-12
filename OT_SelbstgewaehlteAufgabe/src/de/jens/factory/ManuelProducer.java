package de.jens.factory;

public class ManuelProducer extends AbstractProducer {

	public ManuelProducer(int workloadOfUnit, String name, Person responsible) {
		super(workloadOfUnit, name, responsible);
	}

	@Override
	public void accept(I_Visitor visitor) {
		visitor.visit(this);
	}
}
