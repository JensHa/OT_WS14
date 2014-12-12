package de.jens.factory;

public class QualityAlertVisitor implements I_Visitor {
	private int limitOfPlantIssues;
	private int limitOfAreaIssues;
	private int limitOfLineIssues;
	private int limitOfStationIssues;
	private int limitOfManuelProduderIssues;
	private int limitOfAutomaticProducerIssues;
	String path="";

	public QualityAlertVisitor(int plant, int area, int line, int station, int manuelProducer, int automaticProducer) {
		this.limitOfPlantIssues = plant;
		this.limitOfAreaIssues = area;
		this.limitOfLineIssues = line;
		this.limitOfStationIssues = station;
		this.limitOfManuelProduderIssues = manuelProducer;
		this.limitOfAutomaticProducerIssues = automaticProducer;
	}

	@Override
	public void visit(Plant plant) {
		String oldPath=path;
		path+=plant.getName()+"/";
		if (plant.getReportedQualityIssues() > limitOfPlantIssues) {
			sendMessageTo(plant);
		}
		
		visitChilds(plant);
		path=oldPath;
	}



	@Override
	public void visit(Area area) {
		String oldPath=path;
		path+=area.getName()+"/";
		if (area.getReportedQualityIssues() > limitOfAreaIssues) {
			sendMessageTo(area);
		}
		visitChilds(area);
		path=oldPath;
	}

	@Override
	public void visit(AsemblyLine line) {
		String oldPath=path;
		path+=line.getName()+"/";
		if (line.getReportedQualityIssues() > limitOfLineIssues) {
			sendMessageTo(line);
		}
		
		visitChilds(line);
		path=oldPath;
	}

	@Override
	public void visit(Station station) {
		String oldPath=path;
		path+=station.getName()+"/";
		if (station.getReportedQualityIssues() > limitOfStationIssues) {
			sendMessageTo(station);
		}
		
		visitChilds(station);
		path=oldPath;
	}

	@Override
	public void visit(ManuelProducer manuelProducer) {
		String oldPath=path;
		path+=manuelProducer.getName()+"/";
		if (manuelProducer.getReportedQualityIssues() > limitOfManuelProduderIssues) {
			sendMessageTo(manuelProducer);
		}
		path=oldPath;
	}

	@Override
	public void visit(AutomaticProducer automaticProducer) {
		String oldPath=path;
		path+=automaticProducer.getName()+"/";
		if (automaticProducer.getReportedQualityIssues() > limitOfAutomaticProducerIssues) {
			sendMessageTo(automaticProducer);
		}
		path=oldPath;
	}

	private void sendMessageTo(AbstractQualityIssues issue) {
		System.out.println("To: " + issue.getResponsiblePerson().getName()
				+ " -- Message: You are having a quality problem at "
				+ path + ". Amount of problems: "
				+ issue.getReportedQualityIssues());
	}
	
	private void visitChilds(NodeOfQualityIssues<? extends I_HasReportedQualityIssues> issue) {
		
		for(I_HasReportedQualityIssues issue1 : issue.getComponents()){
			issue1.accept(this);
		}
		
	}
}
