package de.composite;

import java.util.ArrayList;
import java.util.List;


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
	
	public InvoiceBuilder setHead(InvoiceHeader head) {
		this.head = head;
		return this;
	}
	
	public InvoiceBuilder setVatCalc(valueAddedTaxCalc calc){
		this.calc=calc;
		return this;

	}
	
	public Invoice create(){
		return new Invoice(lineItems, head,calc);
	}





}
