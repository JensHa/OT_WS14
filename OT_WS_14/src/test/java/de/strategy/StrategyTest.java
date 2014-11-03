package de.strategy;

import org.junit.*;

import static org.junit.Assert.*;

public class StrategyTest {
  @Test
  public void normalVATtest(){
	  Receiver rec=new Receiver("Jens", "Fakestreet");
	  
	  DefaultFactory factory= new DefaultFactory();
	  InvoiceHeader header=factory.createInvoiceHeader(rec);
	  
	  InvoiceBuilder builder = new InvoiceBuilder();
	  
	  valueAddedTaxCalc calc= new normalVATCalc(19);
	  
	  builder.addLineItem(new LineItem("A", 10, new Money(100)));
	  builder.addLineItem(new LineItem("B", 20, new Money(10)));
	  builder.addLineItem(new LineItem("C", 30, new Money(10)));
	  builder.setVatCalc(calc);
	  builder.setHead(header);
	  Invoice invoice=builder.create();
	  
	  assertEquals((10.0*100.0+20.0*10.0+30.0*10.0)*0.19,invoice.getVat().asDouble(),0.0);

  }
  
  @Test
  public void reducedVATtest(){
	  Receiver rec=new Receiver("Jens", "Fakestreet");
	  
	  DefaultFactory factory= new DefaultFactory();
	  InvoiceHeader header=factory.createInvoiceHeader(rec);
	  
	  InvoiceBuilder builder = new InvoiceBuilder();
	  
	  valueAddedTaxCalc calc= new complexVATCalc(19, 1);
	  
	  builder.addLineItem(new LineItem("reduced_item", 10, new Money(100)));
	  builder.addLineItem(new LineItem("B", 20, new Money(10)));
	  builder.addLineItem(new LineItem("C", 30, new Money(10)));
	  builder.setVatCalc(calc);
	  builder.setHead(header);
	  Invoice invoice=builder.create();
	  
	  assertEquals((20.0*10.0+30.0*10.0)*0.19+(10*100)*0.01,invoice.getVat().asDouble(),0.0);

	  System.out.println(invoice.getVat().asDouble());
  }
}