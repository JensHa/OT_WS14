package de.command;


public class BackdateFactory implements InvoiceHeaderFactory {
	private int lastGivenInvoiceId;

	public InvoiceHeader createInvoiceHeader(Receiver receiver) {

		return new InvoiceHeader(receiver, createDate(), nextInvoiceId());

	}

	private static long createDate() {
		return System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 10;
	}

	private int nextInvoiceId() {
		lastGivenInvoiceId++;
		return lastGivenInvoiceId;
	}
}
