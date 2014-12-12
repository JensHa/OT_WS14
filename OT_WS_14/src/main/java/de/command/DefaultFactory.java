package de.command;


public class DefaultFactory implements InvoiceHeaderFactory {
	private int lastGivenInvoiceId;
	  
	public InvoiceHeader createInvoiceHeader(Receiver receiver) {
		int invoiceId=nextInvoiceId();
		return new InvoiceHeader(receiver,System.currentTimeMillis(),invoiceId);
	}

	private int nextInvoiceId() {
		lastGivenInvoiceId++;
		return lastGivenInvoiceId;
	}

}
