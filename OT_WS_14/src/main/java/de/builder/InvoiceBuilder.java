package de.builder;

import java.util.ArrayList;
import java.util.List;

import de.abstractfacory.InvoiceHeader;

public class InvoiceBuilder {
	private final List<LineItem> lineItems= new ArrayList<LineItem>();
	
	public InvoiceBuilder(){
	}
	
	public InvoiceBuilder addLineItem(LineItem lineItem){
		this.lineItems.add(lineItem);
		return this;
	}
	
	public Invoice create(){
		return new Invoice(lineItems);
	}


}
