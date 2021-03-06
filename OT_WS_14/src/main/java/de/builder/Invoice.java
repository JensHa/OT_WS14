package de.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.builder.Money;

public class Invoice {
	private final List<LineItem> lineItems= new ArrayList<LineItem>();
	
	public Invoice(List<LineItem> lineItems){
		this.lineItems.addAll(lineItems);
	}
	
	/**
	 * Sums up the amount of all line items of an invoice
	 * @return The sum of the invoice
	 */
	public Money getInvoiceSum(){
	    Money sum = new Money( 0 );

	    for ( LineItem lineItem : lineItems ) {
	      sum = sum.add( lineItem.getLineSum() );
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


}
