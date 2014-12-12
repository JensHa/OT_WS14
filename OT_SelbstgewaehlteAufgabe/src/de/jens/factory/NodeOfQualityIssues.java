package de.jens.factory;

import java.util.ArrayList;

public abstract class NodeOfQualityIssues<T extends I_HasReportedQualityIssues> extends AbstractQualityIssues{
	public NodeOfQualityIssues(String name, Person responsible) {
		super(name, responsible);
	}


	private ArrayList<I_HasReportedQualityIssues> components=new ArrayList<I_HasReportedQualityIssues>();
	
	public void addCom(T component){
		components.add(component);
	}
	
	public ArrayList<I_HasReportedQualityIssues> getComponents(){
		return this.components;
	}
	
	
	@Override
	public int getReportedQualityIssues() {
		int sum = 0;

		for (I_HasReportedQualityIssues component : components) {
			sum += component.getReportedQualityIssues();
		}
		return sum;
	}


}
