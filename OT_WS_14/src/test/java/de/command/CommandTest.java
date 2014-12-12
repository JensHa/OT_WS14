package de.command;

import static org.junit.Assert.*;

import org.junit.Test;


public class CommandTest {
  @Test
  public void testCommands() {
	  Addressbook addressBook = new Addressbook();
	  ContactManager manager = new ContactManager();

	  assertEquals( 0, addressBook.getSize() );

    manager.execute( new AddCommand( addressBook, new Receiver( "a", "b" ), 1 ) );
    manager.execute( new AddCommand( addressBook, new Receiver( "c", "d" ), 2 ) );
    assertEquals( 2, addressBook.getSize() );

    manager.execute( new EditCommand( addressBook, new Receiver( "1", "2" ), 2 ) );
    assertEquals( 2, addressBook.getSize() );
    assertEquals( "1", addressBook.getEntry( 2 ).getName() );

    manager.execute( new DeleteCommand( addressBook, 1 ) );
    manager.execute( new DeleteCommand( addressBook, 2 ) );

    assertEquals( 0, addressBook.getSize() );


    manager.undo();
    assertEquals( 1, addressBook.getSize() );
    manager.undo();
    assertEquals( 2, addressBook.getSize() );
    assertEquals( "1", addressBook.getEntry( 2 ).getName() );
    manager.undo();
    assertEquals( 2, addressBook.getSize() );
    assertEquals( "c", addressBook.getEntry( 2 ).getName() );
    manager.undo();
    assertEquals( 1, addressBook.getSize() );
    manager.undo();

    assertEquals( 0, addressBook.getSize() );
  }
}