package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import junit.Contact;
import junit.ContactService;

class ContactServiceTest {

	
	@Test
	void addContactTestDuplicateID() {
		ContactService.addContact("123456", "Shayne", "Rushton", "4252152152", "2320 63rd St SE Unit B");
		assertThrows(IllegalArgumentException.class, () -> { ContactService.addContact("123456", "Shayne", "Rushton", "4252152152", "2320 63rd St SE Unit B" );
		});
		
	}
	
	@Test
	void addContactSuccessTest() {
		ContactService.addContact("1234567", "Shayne", "Rushton", "4252152152", "2320 63rd St SE Unit B");
		Contact getContact = ContactService.getContact("1234567");
		assertTrue(getContact.getID().equals("1234567"));
		assertTrue(getContact.getFirstName().equals("Shayne"));
		assertTrue(getContact.getLastName().equals("Rushton"));
		assertTrue(getContact.getPhone().equals("4252152152"));
		assertTrue(getContact.getAddress().equals("2320 63rd St SE Unit B"));
	}
	
	@Test
	void deleteContactTest() {
		// Run add contact and verify success, then delete contact and verify success of deletion
		addContactSuccessTest();
		assertNotNull(ContactService.getContact("1234567"));
		ContactService.deleteContact("1234567");
		assertNull(ContactService.getContact("1234567"));
		
	}
	
	@Test
	void updateFirstNameTest() {
		// Test assumes contact exists
		ContactService.addContact("123456789", "Shayne", "Rushton", "4252152152", "2320 63rd St SE Unit B");
		assertNotNull(ContactService.getContact("123456789"));
		// Update First Name
		ContactService.updateContact("123456789", "Matthew", null, null, null);
		Contact updatedContact = ContactService.getContact("123456789");
		String firstName = updatedContact.getFirstName();
		assertTrue(firstName == "Matthew");

	}
	
	@Test
	void updateLastNameTest() {
		// Test assumes contact exists;
		ContactService.addContact("987654321", "Shayne", "Rushton", "4252152152", "2320 63rd St SE Unit B");
		// Update Last Name
		ContactService.updateContact("987654321", null, "Ollum", null, null);
		Contact updatedContact = ContactService.getContact("987654321");
		String lastName = updatedContact.getLastName();
		assertTrue(lastName == "Ollum");

	}
	
	@Test
	void udpateContactPhoneTest() {
		// Test assumes contact exists;
		ContactService.addContact("87654321", "Shayne", "Rushton", "4252152152", "2320 63rd St SE Unit B");
		// Update Contact Phone
		ContactService.updateContact("87654321", null, null, "6667779999", null);
		Contact updatedContact = ContactService.getContact("87654321");
		String contPhone = updatedContact.getPhone();
		assertTrue(contPhone == "6667779999");

	}
	
	@Test
	void udpateContactAddressTest() {
		// Test assumes contact exists;
		ContactService.addContact("666999888", "Shayne", "Rushton", "4252152152", "2320 63rd St SE Unit B");
		// Update Address
		ContactService.updateContact("666999888", null, null, null, "699 Something Road");
		Contact updatedContact = ContactService.getContact("666999888");
		String contAddr = updatedContact.getAddress();
		assertTrue(contAddr == "699 Something Road");

	}
	
	@Test
	void udpateContactTest() {
		// Test assumes contact doesn't exist;
		ContactService.addContact("000222333", "Shayne", "Rushton", "4252152152", "2320 63rd St SE Unit B");
		// Update All fields
		ContactService.updateContact("000222333", "HeyHey", "Dolly", "PhoneNum99", "I live somewhere");
		Contact updatedContact = ContactService.getContact("000222333");
		assertTrue(updatedContact.getID().equals("000222333"));
		assertTrue(updatedContact.getFirstName().equals("HeyHey"));
		assertTrue(updatedContact.getLastName().equals("Dolly"));
		assertTrue(updatedContact.getPhone().equals("PhoneNum99"));
		assertTrue(updatedContact.getAddress().equals("I live somewhere"));
		
	}
	
	@Test
	void updateContactNullTest() {
		assertThrows(NullPointerException.class, () -> { ContactService.updateContact(null, "Don", "Johnson", "4567894566", "Homeless"); });
	}
	

}