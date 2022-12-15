package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.Contact;

class ContactTest {


	@Test
	public void testContactClass() {
		Contact newContact = new Contact("123456", "Shayne", "Rushton", "2452345321", "2320 63rd St Unit B");
		assertTrue(newContact.getID().equals("123456"));
		assertTrue(newContact.getFirstName().equals("Shayne"));
		assertTrue(newContact.getLastName().equals("Rushton"));
		assertTrue(newContact.getPhone().equals("2452345321"));
		assertTrue(newContact.getAddress().equals("2320 63rd St Unit B"));
	}
	
	
	@Test
	public void testContactIDLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123452000002", "Shayne", "Rushton", "4252105823", "2320 63rd St Unit B");
			
		});
	}
	
	@Test
	public void testContactNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Shayne", "Rushton", "4252105823", "2320 63rd St Unit B");
		});
	}
	
	@Test
	public void testFirstNameLength() {
		//TODO Finish testing first name input
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "ShayneShayneShayne", "Rushton", "4252105823", "2320 63rd St Unit B");
			
		});
	}
	
	@Test
	public void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", null, "Rushton", "4252105823", "2320 63rd St Unit B");
		});
	}
	
	@Test
	public void testLastNameLength() {
		//TODO Finish testing first name input
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Shayne", "RushtonRushtonRusthon", "4252105823", "2320 63rd St Unit B");
			
		});
	}
	
	@Test
	public void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Shayne", null, "4252105823", "2320 63rd St Unit B");
		});
	}
	
	@Test
	public void testPhoneLengthOver10() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Shayne", "Rushton", "4253232122221", "2320 63rd St Unit B");
			
		});
	}
	
	@Test
	public void testPhoneLengthUnder10() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Shayne", "Rushton", "123654", "2320 63rd St Unit B");
			
		});
	}
	
	@Test
	public void testPhoneNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Shayne", "Rushton", null, "2320 63rd St Unit B");
		});
	}

	@Test
	public void testAddressLength() {
		//TODO Finish testing first name input
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Shayne", "Rushton", "4251251254", "2320 63rd St Unit B ******************************");
			
		});
	}
	
	@Test
	public void testAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Shayne", "Rushton", "4251251254", null);
		});
	}
}