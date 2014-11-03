package de.builder;

import static org.junit.Assert.*;

import org.junit.Test;

import de.builder.Money;

public class BuilderTest {
	
  @Test
  public void testInvoiceBuilder() throws Exception {
    InvoiceBuilder invoiceBuilder = new InvoiceBuilder();
	invoiceBuilder.addLineItem(new LineItem("productA", 10, new Money(10)))
	.addLineItem(new LineItem("productB", 20, new Money(5)))
	.addLineItem(new LineItem("productC", 5, new Money(100)))
	.addLineItem(new LineItem("productD", 50, new Money(1)));  
	  
//	Alternative	
//	invoiceBuilder.addLineItem(new LineItem("productA", 10, new Money(10)));
//	invoiceBuilder.addLineItem(new LineItem("productB", 20, new Money(5)));
//	invoiceBuilder.addLineItem(new LineItem("productC", 5, new Money(100)));
//	invoiceBuilder.addLineItem(new LineItem("productD", 50, new Money(1)));
	
	Invoice invoice = invoiceBuilder.create();

	System.out.println("Created a new invoice");
	System.out.println("Sum of invoice: " + invoice.getInvoiceSum().getCents());
	for(LineItem item : invoice.getLineItems()){
		System.out.println(item);
	}
	assertEquals(4,invoice.getLineItems().size());
	assertEquals(10*10+20*5+5*100+50*1, invoice.getInvoiceSum().getCents());
  }


}