package de.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.abstractfacory.InvoiceHeader;

public class Invoice {
	private final List<LineItem> lineItems= new ArrayList<LineItem>();
	private final InvoiceHeader head;
	
	public Invoice(List<LineItem> lineItems, InvoiceHeader head){
		this.lineItems.addAll(lineItems);
		this.head=head;
	}
	
	/**
	 * Sums up the amount of all line items of an invoice
	 * @return The sum of the invoice
	 */
	public long getInvoiceSum(){
		long sum=0;
		for(LineItem item : lineItems){
			sum+=item.getLineSum();
		}
		return sum;
	}
	
	/**
	 * Will return all line items within the invoice. 
	 * @return An immutable view of the line items
	 */
	public List<LineItem> getLineItems(){
		return Collections.unmodifiableList(lineItems);
	}

	public InvoiceHeader getHead() {
		return head;
	}

}
