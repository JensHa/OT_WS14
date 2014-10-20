package de.builder;

import java.util.ArrayList;
import java.util.List;

import de.abstractfacory.InvoiceHeader;

public class InvoiceBuilder {
	private final List<LineItem> lineItems= new ArrayList<LineItem>();
	private InvoiceHeader head;
	
	public InvoiceBuilder(){
	}
	
	public InvoiceBuilder addLineItem(LineItem lineItem){
		this.lineItems.add(lineItem);
		return this;
	}
	
	public void setHead(InvoiceHeader head) {
		this.head = head;
	}
	
	public Invoice create(){
		return new Invoice(lineItems, head);
	}





}
