package de.composite;


public class InvoiceHeader{
	private final int no;
	private final long date;
	private final Receiver receiver;
	
	public InvoiceHeader (Receiver receiver, long date, int no){
		this.receiver=receiver;
		this.date=date;
		this.no=no;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public  int getNo() {
		return no;
	}

	public long getDate() {
		return date;
	}


	
	
	

}
