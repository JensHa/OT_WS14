package de.composite;

public class Journal extends ContainsPriceAbstract {
	

	public void addInvoice(Invoice invoice){
		list.add(invoice);
	}

}
