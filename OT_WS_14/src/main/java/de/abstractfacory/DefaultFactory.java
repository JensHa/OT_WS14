package de.abstractfacory;

import java.util.Calendar;

public class DefaultFactory implements InvoiceHeaderFactory{

	public InvoiceHeader createInvoiceHeader(Receiver receiver) {
		Calendar cal = Calendar.getInstance();
		return new DefaultInvoiceHeader(receiver, cal.getTime());
	}

}
