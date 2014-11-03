package de.abstractFactory;


import static org.junit.Assert.*;

import org.junit.*;

import de.abstractfacory.BackdateFactory;
import de.abstractfacory.DefaultFactory;
import de.abstractfacory.InvoiceHeader;
import de.abstractfacory.Receiver;
import de.abstractfacory.Invoice;
import de.abstractfacory.InvoiceBuilder;
import de.abstractfacory.LineItem;
import de.abstractfacory.Money;



public class AbstractFactoryTest {
  @Test
  public void testDefault(){
    DefaultFactory factory = new DefaultFactory();
    Receiver rec = new Receiver("Jens", "Teststr 1");
    InvoiceHeader header = factory.createInvoiceHeader(rec);

    assertNotNull( header );
    assertEquals( rec, header.getReceiver() );

    //Verify that the date is not older than 1000ms=1sec
    assertTrue( System.currentTimeMillis() - header.getDate() < 1000 );
    assertEquals( 1, header.getNo());


    //2nd header with new invoice id
    assertEquals( 2, factory.createInvoiceHeader(rec).getNo());
    assertEquals( 3, factory.createInvoiceHeader(rec).getNo() );
    assertEquals( 4, factory.createInvoiceHeader(rec).getNo() );
    
    
    InvoiceBuilder invoiceBuilder = new InvoiceBuilder();
   
	invoiceBuilder.addLineItem(new LineItem("productA", 10, new Money(10)))
	.addLineItem(new LineItem("productB", 20, new Money(5)))
	.addLineItem(new LineItem("productC", 5, new Money(100)))
	.addLineItem(new LineItem("productD", 50, new Money(1))).setHead(header);;
	
	Invoice in=invoiceBuilder.create();
	assertEquals(in.getHead(),header);
  }
  
  @Test
  public void testBackdate(){
    BackdateFactory factory = new BackdateFactory();
    Receiver rec = new Receiver("Jens", "Teststr 1");
    InvoiceHeader header = factory.createInvoiceHeader(rec);

    assertNotNull( header );
    assertEquals( rec, header.getReceiver() );

    //Verify that the date is not older than 10 days
    assertTrue( System.currentTimeMillis() - header.getDate()-1000 * 60 * 60 * 24 * 10 < 1000 );
    assertEquals( 1, header.getNo());


    //2nd header with new invoice id
    assertEquals( 2, factory.createInvoiceHeader(rec).getNo());
    assertEquals( 3, factory.createInvoiceHeader(rec).getNo() );
    assertEquals( 4, factory.createInvoiceHeader(rec).getNo() );
    
    
    InvoiceBuilder invoiceBuilder = new InvoiceBuilder();
   
	invoiceBuilder.addLineItem(new LineItem("productA", 10, new Money(10)))
	.addLineItem(new LineItem("productB", 20, new Money(5)))
	.addLineItem(new LineItem("productC", 5, new Money(100)))
	.addLineItem(new LineItem("productD", 50, new Money(1))).setHead(header);;
	
	Invoice in=invoiceBuilder.create();
	assertEquals(in.getHead(),header);
  }


}