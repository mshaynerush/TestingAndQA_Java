package junit;

import java.util.*;

public class ContactService {
	
	static List<Contact> contactList = new LinkedList<Contact>();

	
	public static void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		// Create a new contact and add it to a list.
	
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		
		if(getContact(contactID) == null) {
			contactList.add(newContact);
		} else {
			throw new IllegalArgumentException("The contact already exists");
		}
	}
	
	public static void deleteContact(String id) {
		// Find contact based on contact ID provided and remove from the list.

		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getID().equals(id)) {
				contactList.remove(i);
			}
		}
	}
	
	public static void updateContact(String id, String fName, String lName, String phone, String address) {
		
		// Get contact by ID
		Contact contactToUpdate = getContact(id);
		if(contactToUpdate == null) { throw new NullPointerException("The Contact could not be updated because the Contact does not exist"); }
		
		else {
			
			// If a field was provided, update that field, otherwise, no update occurs.
			// Allows a user to update any of the fields in a Contact by ID while not updating the ID
			if (fName != null) {
				contactToUpdate.setFirstName(fName);
			}
			
			if(lName != null) {
				contactToUpdate.setLastName(lName);
			}
			
			if(phone != null) {
				contactToUpdate.setPhone(phone);
			}
			
			if(address != null) {
				contactToUpdate.setAddress(address);
			}
		}
	}
	
	
	public static Contact getContact(String id) {
		
		// Find the Contact object in the list and return it based on the id given or return null;
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getID().equals(id)) {
				return contactList.get(i);
			}
		}
		return null;
	}
	
}