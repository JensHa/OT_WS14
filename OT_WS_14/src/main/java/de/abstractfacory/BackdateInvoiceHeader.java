package de.abstractfacory;

import java.util.Date;

public class BackdateInvoiceHeader extends InvoiceHeader{


	public BackdateInvoiceHeader(Receiver receiver, Date date) {
		super(receiver, date);
	}

	@Override
	public String toString() {
	return "BackdateInvoiceHeader";
	}
}
