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
	 * ##FIXME Won't work if a contact is removed from anywhere but the end of list
	 * Correct to use for loop to check for any matching ID and incremement 1 if found
	 * 
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
	 * @param contactID
	 * 
	 */
	
	public void deleteContact(String contactID) {
		
		for (int i = 0; i < contactList.size(); ++i) {
			if ( Integer.valueOf(contactID) == contactList.get(i).getContactId()) {
				contactList.remove(i);
			}
		}
	}
	
	/*
	 * Method for editing first name of valid contact in list
	 * calls setFirstName function which will validate requirements
	 * @param contactID, firstName
	 */
	public static void editFirstName(String contactID, String firstName) {
		
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactList.get(i).getContactId() == Integer.valueOf(contactID)) {
				contactList.get(i).setFirstName(firstName);
			}
		}
	}
	
	
	/*
	 * Method for editing last name of valid contact in list
	 * calls setLastName function which will validate requirements
	 * @param contactID, lastName
	 */
	public static void editLastName(String contactID, String lastName) {
		
		for (int i = 0; i < contactList.size(); ++i) {
			if(contactList.get(i).getContactId() == Integer.valueOf(contactID)) {
				contactList.get(i).setLastName(lastName);
			}
		}	
	}
	
	/*
	 * Method for editing first name of valid contact in list
	 * calls setContactPhone function which will validate requirements
	 * @param contactID, contactPhoneNum
	 */
	public void editContactPhoneNum(String contactID, String contactPhoneNum) {
		for (int i = 0; i < contactList.size(); ++i) {
			if( Integer.valueOf(contactID) == contactList.get(i).getContactId()) {
				contactList.get(i).setContactPhone(contactPhoneNum);
			}
		}
	}
	
	/*
	 * Method for editing address of valid contact in list
	 * calls setContactAddress function which will validate requirements
	 * @param contactID, contactAddress
	 */
	public void editContactAddress(String contactID, String contactAddress) {
		for (int i = 0; i < contactList.size(); ++i) {
			if( Integer.valueOf(contactID) == contactList.get(i).getContactId()) {
				contactList.get(i).setContactAddress(contactAddress);
			}
		}
	}


}
