package de.jens.factory;

public abstract class AbstractProducer extends LeafOfQualityIssues{
	
	private int reportedQualityIssues;
	
	public AbstractProducer(int reportedQualityIssuesOfUnit, String name, Person responsible){
		super(name,responsible);
		this.reportedQualityIssues=reportedQualityIssuesOfUnit;
	}
	public void addReportedQualityIssue() {
		this.reportedQualityIssues++;
	}
	
	@Override
	public int getReportedQualityIssues() {
		return reportedQualityIssues;
	}

}
