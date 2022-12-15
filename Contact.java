package junit;

public class Contact {
	private String contactID;	
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor for Contact
	public Contact(String contactID, String firstName, String lastName, String phone, String address){
		
		// Validate that each contact is correct length and is not null
		if(contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("The contact ID is either null or more than 10 characters.");
		}
		
		
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("The first name is either null or more than 10 characters.");
		}
		
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("The last name is either null or more than 10 characters.");
		}
		
		if(phone == null || phone.length() > 10 || phone.length() < 10) {
			throw new IllegalArgumentException("The phone number is either null or more than 10 characters.");
		}
		
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("The address is either null or more than 30 characters.");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Accessors and Mutators

	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	
	public void setLastName(String lName) {
		this.lastName = lName;
	}
	
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String addr) {
		this.address = addr;
	}

	public String getID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}
}