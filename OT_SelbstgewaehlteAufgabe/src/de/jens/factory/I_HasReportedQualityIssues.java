package de.jens.factory;

public interface I_HasReportedQualityIssues {
	
	int getReportedQualityIssues();
	
	void accept(I_Visitor visitor);

}
