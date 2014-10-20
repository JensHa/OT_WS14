package de.abstractfacory;

import java.util.Date;

public abstract class InvoiceHeader implements Header{
	private static int no;
	private final Date date;
	private final Receiver receiver;
	
	public InvoiceHeader (Receiver receiver, Date date){
		InvoiceHeader.no++;
		this.receiver=receiver;
		this.date=date;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public static int getNo() {
		return no;
	}

	public Date getDate() {
		return date;
	}

	public static void setNo(int no) {
		InvoiceHeader.no = no;
	}
	
	
	

}
