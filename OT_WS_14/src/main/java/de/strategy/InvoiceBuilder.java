package de.strategy;

import java.util.ArrayList;
import java.util.List;

import de.strategy.InvoiceHeader;

public class InvoiceBuilder {
	private final List<LineItem> lineItems= new ArrayList<LineItem>();
	private InvoiceHeader head;
	private valueAddedTaxCalc calc;
	
	public InvoiceBuilder(){
	}
	
	public InvoiceBuilder addLineItem(LineItem lineItem){
		this.lineItems.add(lineItem);
		return this;
	}
	
	public void setHead(InvoiceHeader head) {
		this.head = head;
	}
	
	public void setVatCalc(valueAddedTaxCalc calc){
		this.calc=calc;
	}
	
	public Invoice create(){
		return new Invoice(lineItems, head,calc);
	}





}
