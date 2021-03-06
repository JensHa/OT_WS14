package de.abstractfacory;


public class DefaultFactory implements InvoiceHeaderFactory {
	private int lastGivenInvoiceId;
	  
	public InvoiceHeader createInvoiceHeader(Receiver receiver) {
		int invoiceId=nextInvoiceId();
		return new InvoiceHeader(receiver,System.currentTimeMillis(),invoiceId);
	}

	/**
	 * Increments the invoice id
	 * @return the next invoice id
	 */
	private int nextInvoiceId() {
		lastGivenInvoiceId++;
		return lastGivenInvoiceId;
	}

}
