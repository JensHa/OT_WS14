package de.jens.factory;

public interface I_Visitor {
	
	public void visit(Plant plant);
	
	public void visit(Area area);
	
	public void visit(AsemblyLine line);
	
	public void visit(Station station);
	
	public void visit(ManuelProducer manuelProducer);
	
	public void visit(AutomaticProducer automaticProducer);

}
