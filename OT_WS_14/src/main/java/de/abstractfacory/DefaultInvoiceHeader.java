package de.abstractfacory;

import java.util.Date;

public class DefaultInvoiceHeader extends InvoiceHeader{
	
	public DefaultInvoiceHeader(Receiver receiver, Date date) {
		super(receiver, date);
	}

	@Override
	public String toString() {
		return "DefaultInvoiceHeader";
	}

}
