package de.composite;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class JournalTest {
  @Test
  public void testIt() throws Exception {
    Article articleA = new Article( "Artikel A", new Money( 507 ) );
    Article articleB = new Article( "Artikel B", new Money( 407 ) );
    Article articleC = new Article( "Artikel C", new Money( 307 ) );


    Journal journal = new Journal();

    DefaultFactory headerFactory = new DefaultFactory();

    journal.addInvoice( new InvoiceBuilder()
                        .setHead( headerFactory.createInvoiceHeader( new Receiver( "Markus Mustermann", "Dofstraﬂe 7" ) ) )
                        .setVatCalc( new normalVATCalc( 0.19 ) )
                        .addLineItem( new LineItem( articleA, 5 ) )
                        .addLineItem( new LineItem( articleB, 7 )
                        ).create() );


    
	    journal.addInvoice( new InvoiceBuilder()
	    .setHead( headerFactory.createInvoiceHeader( new Receiver( "Paula Panther", "Musterstraﬂe 11" ) ) )
	    .setVatCalc( new normalVATCalc( 0.19 ) )
	    .addLineItem( new LineItem( articleC, 1 ) )
	    .addLineItem( new LineItem( articleB, 400 )
	    ).create() );

    assertThat( journal.getPrice().asDouble() , equalTo( 1684.91) );
  }
}