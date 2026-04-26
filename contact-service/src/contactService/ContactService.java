/*
 *   Anthony Baratti
 *   SNHU CS-320 Software Testing
 *   Professor K. Wilson
 *   9/22/2024
 *   Contact Service (ContactService.java)
 *   
 *   A set of functions to add and edit contact objects
 *   Edit features: first name, last name, phone number, address
 *   Function calls to Contact.java to edit attributes.
 *   
 *   Requirements:
 *   1. The contact service shall be able to add contacts with unique ID.
 *   2. The contact service shall be able to delete contacts per contactId.
 *   3. The contact service shall be able to update contact fields per contactId. The following fields are updatable:
 *		firstName
 *		lastName
 * 		PhoneNumber
 * 		Address 
 */
package contactService;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

	public static List<Contact> contactList = new ArrayList<Contact>(); //Stores contacts
	int newIdNum = 0; //For new contacts

	/*
	 * This method is used to add a new contacts to contactList
	 * It uses an integer starting at zero and each time a new user is added
	 * it increments that number by counting the list size
	 * 
	 * Req 1: The contact service shall be able to add contacts with unique ID.
	 *  @param firstName, lastName, phoneNum, address
	 *  
	 */
	
	public void addNewContact(String firstName, String lastName,
			String phoneNum, String address) {
		newIdNum = 0;
		String newID = String.valueOf(newIdNum);
		for (int i = 0; i < contactList.size(); ++i) {
			++newIdNum;
		}
		newID = String.valueOf(newIdNum);
		//creates new contact object and attaches generated ID
		Contact newContact = new Contact(firstName, lastName, newID, phoneNum, address);
		
		//adds new contact to list
		contactList.add(newContact);
	}
	
	/*
	 * Method to delete contact via unique ID
	 * 
	 * Requirement 2: The contact service shall be able to delete contacts per contactId.
	 
	 * @param contactID
	 */
	
	public void deleteContact(String contactID) {
		
		//Finds contact object by contact ID
		for (int i = 0; i < contactList.size(); ++i) {
			if ( Integer.valueOf(contactID) == contactList.get(i).getContactId()) {
				contactList.remove(i);//removes contact if found by ID
			}
		}
	}
	
	/*
	 * Set of methods of updating fields
	 * 
	 *  Requirement 3: The contact service shall be able to update contact fields per contactId. The following fields are updatable:
	 *		firstName
	 *		lastName
	 * 		PhoneNumber
	 * 		Address 
	 */
	
	/*
	 * Method for editing first name of valid contact in list
	 * calls setFirstName function which will validate requirements
	 * @param contactID, firstName
	 */
	public static void editFirstName(String contactID, String firstName) {
		
		//finds contact by contactID
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactList.get(i).getContactId() == Integer.valueOf(contactID)) {
				contactList.get(i).setFirstName(firstName); //updates firstName if ID found
			}
		}
	}
	
	
	/*
	 * Method for editing last name of valid contact in list
	 * calls setLastName function which will validate requirements
	 * @param contactID, lastName
	 */
	public static void editLastName(String contactID, String lastName) {
		
		//finds contact by contactID
		for (int i = 0; i < contactList.size(); ++i) {
			if(contactList.get(i).getContactId() == Integer.valueOf(contactID)) {
				contactList.get(i).setLastName(lastName); //updates lastName if ID found
			}
		}	
	}
	
	/*
	 * Method for editing phone number of valid contact in list
	 * calls setContactPhone function which will validate requirements
	 * @param contactID, contactPhoneNum
	 */
	public static void editContactPhoneNum(String contactID, String contactPhoneNum) {
		
		//finds contact by contactID
		for (int i = 0; i < contactList.size(); ++i) {
			if( Integer.valueOf(contactID) == contactList.get(i).getContactId()) {
				contactList.get(i).setContactPhone(contactPhoneNum); //updates phone number if ID found
			}
		}
	}
	
	/*
	 * Method for editing address of valid contact in list
	 * calls setContactAddress function which will validate requirements
	 * @param contactID, contactAddress
	 */
	public static void editContactAddress(String contactID, String contactAddress) {
		
		//finds contact by contactID
		for (int i = 0; i < contactList.size(); ++i) {
			if( Integer.valueOf(contactID) == contactList.get(i).getContactId()) {
				contactList.get(i).setContactAddress(contactAddress); //updates address if ID found
			}
		}
	}


}
