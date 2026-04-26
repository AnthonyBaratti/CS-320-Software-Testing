/*
 *   Anthony Baratti
 *   SNHU CS-320 Software Testing
 *   Professor K. Wilson
 *   9/22/2024
 *   Contact Service (Contact.java)
 *   
 *   The purpose of this application is to create contact objects that follow business requirements
 *   and add them to a list of contacts. The requirements are as follows:
 *   1. Contact object shall have a required unique contact ID that can not be longer than 10
 *   characters, can not be null, and shall not be updateable
 *   2. The contact object shall have required first name string that can not be longer than 10
 *   shall not be null, and shall be updateable
 *   3. The contact object shall have a required last name string that can not be longer than 10
 *   shall not be null, and shall be updateable
 *   4. The contact object shall have a required phone number string that must be exactly 10 digits
 *   long, must not be null, and must be updateable
 *   5. The contact object shall have a required addres string that must be no longer than 30
 *   chacters long, shall not be null, and must be updateable.
 *   
 *   Tests are designed using JUnit testing and annotations built to ensure these requirements are met.
 */





package contactService;

public class Contact {
	
	//Contact variables set to private
	private String firstName;
	private String lastName;
	private String contactID;
	private String contactPhone;
	private String contactAddress;
	
	//Set of functions that will validate input parameters
	
	/*
	 *  Checks length of first name string. 
	 *  If null or greater than 10, exception is thrown
	 *  @param firstName
	 *  @return firstName
	 */
	private String validateFirstName(String firstName) {
		if ((firstName == null) || (firstName.length() > 10)) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		return firstName;
	}
	
	/*
	 *  Checks length of last name string. 
	 *  If null or greater than 10, exception is thrown
	 *  @param lastName
	 *  @return lastName
	 */
	private String validateLastName(String lastName) {
		if ((lastName == null) || (lastName.length() > 10)) { //Checks last name length
			throw new IllegalArgumentException("Invalid last name.");
		}
		return lastName;
	}
	
	/*
	 *  Checks length of contactID string. 
	 *  If null or greater than 10, exception is thrown
	 *  @param contactID
	 *  @return contactID
	 */
	private String validateContactID(String contactID) { //checks contact ID length
		if ((contactID == null) || (contactID.length() > 10)) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		return contactID;
	}
	
	/*
	 *  Checks length of phone number string. 
	 *  If null or not exactly 10, exception is thrown
	 *  @param phoneNumber
	 *  @return phoneNumber
	 */
	private String validatePhoneNumber(String phoneNumber) {
		if ((phoneNumber == null) || (phoneNumber.length() != 10)) { //check phone number length
			throw new IllegalArgumentException("Invalid phone number.");
		}
		//Checks to ensure phone number is all digits
		for (int i = 0; i < phoneNumber.length(); ++i) { //parses phone number
			char s = phoneNumber.charAt(i);
			boolean digit = true; //set to true
			if(!Character.isDigit(s)) { //if character is not digit
				digit = false; //set to false
			}
			if (digit == false) { //if false (not digit) throw exception
				throw new IllegalArgumentException("Invalid digits.");
			}
		}
		
		return phoneNumber;
	}
	
	/*
	 *  Checks length of address string. 
	 *  If null or greater than 30, exception is thrown
	 *  @param contactAddress
	 *  @return contactAddress
	 */
	private String validateContactAddress(String contactAddress) {
		
		//checks address to be under 30 char
		if((contactAddress == null) || (contactAddress.length() > 30)) {
			throw new IllegalArgumentException("Invalid address.");
		}
		return contactAddress;
	}
	//Default constructor
	public Contact() {}
	
	/*
	 *  Constructor that verifies inputs
	 *  Called from ContactService to populate contactList with new contacts
	 *  
	 *  @param firstName, lastName, contactId, contactPhone, contactAddress
	 */
	public Contact(String firstName, String lastName, String contactID, 
			String contactPhone, String contactAddress) {
		
		//calls to validate checks on value
		validateFirstName(firstName);
		//Allows setting first name if exception not thrown.
		this.firstName = firstName;
		
		
		//calls to validate last name
		validateLastName(lastName);
		//allows setting last name if exception not found
		this.lastName = lastName;
		
		/*
		 * Used to validate contact ID
		 * When ID is generated in ContactService addNewContact()
		 * a unique ID should be generated and validated there.
		 */
		validateContactID(contactID);
		this.contactID = contactID; 
		
		//Validate phone number
		validatePhoneNumber(contactPhone);
		this.contactPhone = contactPhone;
		
		//Validate Address
		validateContactAddress(contactAddress);
		this.contactAddress = contactAddress;
	}
	
	//Setters for updating object attributes
	public void setFirstName(String fName) {
		validateFirstName(fName); //checks requirements
		firstName = fName; //updates first name
	}
	public void setLastName(String lName) {
		validateLastName(lName); //checks requirements
		lastName = lName; //updates last name
	}
	
	//Do not create a set function for ID, as it is not updateable
	
	public void setContactPhone(String phoneNum) {
		validatePhoneNumber(phoneNum); //checks requirements
		contactPhone = phoneNum; //updates phone number
	}
	public void setContactAddress(String address) {
		validateContactAddress(address); //checks requirements
		contactAddress = address; //updates address
	}
	
	//Getters
	public String getFirstName() {
		return firstName;
	}
	public String getLastName( ) {
		return lastName;
	}
	public Integer getContactId() {
		return Integer.valueOf(contactID);
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public String getContactAddress() {
		return contactAddress;
	}
		

	
}
