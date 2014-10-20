package de.abstractFactory;


import org.junit.*;

import de.abstractfacory.BackdateFactory;
import de.abstractfacory.DefaultFactory;
import de.abstractfacory.InvoiceHeader;
import de.abstractfacory.InvoiceHeaderFactory;
import de.abstractfacory.Receiver;
import de.builder.Invoice;
import de.builder.InvoiceBuilder;
import de.builder.LineItem;
import de.immutability.Money;



public class AbstractFactoryTest {
  @Test
  public void testDefault(){
    DefaultFactory factory = new DefaultFactory();
    produce( factory );
  }

  @Test
  public void testBack(){
    BackdateFactory factory = new BackdateFactory();
    produce( factory );
  }

  private void produce( InvoiceHeaderFactory factory ) {
	  
	Receiver rec = new Receiver("Jens", "Teststr 1");
    InvoiceHeader header = factory.createInvoiceHeader(rec);

    System.out.println( "Created a <" + header + "> with" );
    System.out.println("Receiver: " + header.getReceiver());
    System.out.println("No: " + header.getNo());
    System.out.println("Date: "+ header.getDate() );
    
    InvoiceBuilder invoiceBuilder = new InvoiceBuilder();
    
	invoiceBuilder.addLineItem(new LineItem("productA", 10, new Money(10)))
	.addLineItem(new LineItem("productB", 20, new Money(5)))
	.addLineItem(new LineItem("productC", 5, new Money(100)))
	.addLineItem(new LineItem("productD", 50, new Money(1))).setHead(header);;
	
	Invoice in=invoiceBuilder.create();
    
  }
}