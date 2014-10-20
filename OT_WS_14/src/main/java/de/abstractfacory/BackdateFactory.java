package de.abstractfacory;

import java.util.Calendar;


public class BackdateFactory implements InvoiceHeaderFactory{

	public InvoiceHeader createInvoiceHeader(Receiver receiver) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -10);
		return new BackdateInvoiceHeader(receiver, cal.getTime());

	}

}
