package de.composite;

import java.util.Collections;
import java.util.List;


public class Invoice extends ContainsPriceAbstract{
	private final InvoiceHeader head;
	private final valueAddedTaxCalc calc;
	
	public Invoice(List<LineItem> lineItems, InvoiceHeader head, valueAddedTaxCalc calc){
		super(lineItems);
		this.head=head;
		this.calc=calc;

	}
	
	/**
	 * Sums up the amount of all line items of an invoice
	 * @return The sum of the invoice
	 */
	public Money getInvoiceSum(){
//	    Money sum = new Money( 0 );
//
//	    for ( LineItem lineItem : lineItems ) {
//	      sum = sum.add( lineItem.getLineSum() );
//	    }
//	    return sum;
		return getPrice();
	}
	
	/**
	 * Will return all line items within the invoice. 
	 * @return An immutable view of the line items
	 */
	public List<ContainsPrice> getLineItems(){
		return Collections.unmodifiableList(list);
	}

	public InvoiceHeader getHead() {
		return head;
	}
	

	public valueAddedTaxCalc getCalc() {
		return calc;
	}
	
	public Money getGrossInvoiceSum() {
		return getInvoiceSum().add(getVat());
	}
	
	public Money getVat() {
		return calc.vatOfInvoice(this);
		
	}


}
