/*
 *   Anthony Baratti
 *   SNHU CS-320 Software Testing
 *   Professor K. Wilson
 *   9/22/2024
 *   Contact Service (ContactServiceTest.java)
 *   
 *   Tests for requirements met in ContactService.java
 *   
 */
package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contactService.ContactService;


class ContactServiceTest {
	
	//Method to create first contact object in list before each test
	//Reduces redundancies in tests
	@BeforeEach
	void createFirstObject() {
		String firstName = "Anthony";
		String lastName = "Baratti";
		String phoneNum = "1234567890";
		String address = "22425 So. Prairie Rd E.";
		
		ContactService testList = new ContactService();
		testList.addNewContact(firstName, lastName, phoneNum, address);
	}
	//Method created to clear entire list of elements after each test.
	@AfterEach
	void removeList() {
		ContactService.contactList.clear();
	}
	
	//Check to make sure addNewContact works
	@DisplayName("Properly adds new contact to list")
	@Test
	void testAddContact() {
		//Uses Annotation @BeforeEach where first object is created and added to list
		
		//checks all attributes of contact object added to contactList
		assertTrue(ContactService.contactList.get(0).getContactId() == 0);
		assertEquals("Anthony", ContactService.contactList.get(0).getFirstName());
		assertEquals("Baratti", ContactService.contactList.get(0).getLastName());
		assertEquals("1234567890", ContactService.contactList.get(0).getContactPhone());
		assertEquals("22425 So. Prairie Rd E.", ContactService.contactList.get(0).getContactAddress());
	}

	//FIXME Verify CS Adds contacts with unique ID
	//Need to fix the ContactService Method for Unique ID @ addNewContact()
	/*
	 * This test will add a new contact to the contact list
	 * Verifying that it has a unique ID
	 * 
	 */
	@DisplayName("Unique ID (Multiple contacts)")
	@Test
	void testUniqueID() {
		
		ContactService test = new ContactService();
		
		//adds 2 more contact objects
		test.addNewContact("John", "Smith", "1234567890", "Some made up address");
		test.addNewContact("Jane", "Johnson", "1234567890", "City,State,Zip");

		//Checks that each contact was added with a new unique ID (Incremented from last addition)
		assertTrue(ContactService.contactList.get(0).getContactId() == 0);
		assertTrue(ContactService.contactList.get(1).getContactId() == 1);
		assertTrue(ContactService.contactList.get(2).getContactId() == 2);

	}
	
	//Delete by contactID number
	@DisplayName("Delete contact")
	@Test
	void testDeleteContact() {
		
		ContactService test = new ContactService();
		
		//adds 2 more contact objects to contactList
		test.addNewContact("John", "Smith", "1234567890", "Some made up address"); //contact ID 1
		test.addNewContact("Jane", "Johnson", "1234567890", "City,State,Zip"); //contact ID 2
		
		assertTrue(ContactService.contactList.size() == 3); //confirms 2 more objects are added to contactList
		
		
		//Checks all 3 ID numbers in their places
		assertTrue(ContactService.contactList.get(0).getContactId() == 0);
		assertTrue(ContactService.contactList.get(1).getContactId() == 1);
		assertTrue(ContactService.contactList.get(2).getContactId() == 2);
		
		test.deleteContact("1"); //delete contact by ID "1"
		
		assertEquals(2, ContactService.contactList.size()); //shows object was removed from the list (-1)
		assertEquals("Anthony", ContactService.contactList.get(0).getFirstName()); //shows array position 0 remained
		assertEquals("Jane", ContactService.contactList.get(1).getFirstName()); // shows that array position 2 goes to array position 1
		assertFalse(ContactService.contactList.get(1).getFirstName() == "John"); //shows John no longer exists

	}
	
	/*
	 * This set of tests uses a properly initialized Contact object
	 * Then updates the first name to appropriate input
	 * then updates to greater than 10 and null (3 tests)
	 * 
	 * 1st test shows correct change
	 * last 2 tests show exception thrown
	 *
	 */
	@DisplayName("Update first name") //Requirement: First name updateable
	@Test
	void testUpdateFirstName() {

		String contactID = "0";
		//Checks original value of firstName based on contactID
		assertEquals("Anthony", ContactService.contactList.get(Integer.valueOf(contactID)).getFirstName());
		
		ContactService.editFirstName(contactID, "AnthonyJ");//Edits first name
		
		//Checks updated value of firstName based on contactID
		assertEquals("AnthonyJ", ContactService.contactList.get(Integer.valueOf(contactID)).getFirstName());
	}

	@DisplayName("Update first name null Exception") //Requirement: First Name != null
	@Test
	void testSetFirstNameNull() {
		
		String contactID = "0";
		
		
		//Edit first name to null (throw exception)
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			ContactService.editFirstName(contactID, null);
			});
	}
	
	@DisplayName("Update first name too long Exception") //Requirement: First Name <= 10
	@Test
	void testSetFirstNameTooLong() {

		String contactID = "0";
		
		//Edit first name too long (throw exception)
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			ContactService.editFirstName(contactID, "AnthonyJohn");
			});
	}
	
	
	/*
	 * This set of tests uses a properly initialized Contact Object
	 * Then updates the last name appropriately
	 * then to greater than 10 and null (3 tests)
	 * 
	 * 1st test shows correct change
	 * last 2 tests show exception thrown
	 *
	 */
	
	@DisplayName("Update last name") //Requirement: Last name updateable
	@Test
	void testUpdateLastName() {

		String contactID = "0";
		
		//Checks original value of lastName based on contactID
		assertEquals("Baratti", ContactService.contactList.get(Integer.valueOf(contactID)).getLastName());
		
		ContactService.editLastName(contactID, "JBaratti");//Edits first name
		
		//Checks updated value of firstName based on contactID
		assertEquals("JBaratti", ContactService.contactList.get(Integer.valueOf(contactID)).getLastName());
	}
	
	@DisplayName("Update last name too long Exception") //Req: Last name <= 10
	@Test
	void testUpdateLastNameTooLong() {
		String contactID = "0";
		
		//Edit last name too long (throw exception)
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			ContactService.contactList.get(Integer.valueOf(contactID)).setLastName("AnthonyJohn");
		});
	}
	
	@DisplayName("Update last name null Exception") //Req: Last name != null
	@Test
	void testUpdateLastNameNull() {
		
		String contactID = "0";
		
		//Edit last name null (throw exception)
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			ContactService.contactList.get(Integer.valueOf(contactID)).setLastName(null);
		});
	}
	
	/*
	 *  THis set of tests will check to determine the address is updateable
	 *  Set to valid address, then set to too long and null (3 tests)
	 *  
	 *  1st test shows correct change
	 *  last 2 tests show exception thrown
	 *
	 */
	@DisplayName("Update Address") //Req: Address updateable
	@Test
	void testUpdateAddress() {

		String contactID = "0";
		
		//Checks original address implemented
		assertEquals(ContactService.contactList.get(Integer.valueOf(contactID)).getContactAddress(), "22425 So. Prairie Rd E.");
		
		ContactService.contactList.get(Integer.valueOf(contactID)).setContactAddress("Updated address"); //Edit Address
		
		//Checks address was updated
		assertEquals(ContactService.contactList.get(Integer.valueOf(contactID)).getContactAddress(), "Updated address"); 
	}
	
	@DisplayName("Update Address too long") //Req: Address <= 10
	@Test
	void testUpdateAddressTooLong() {
		
		String contactID = "0";
		
		//Checks original address implemented
		assertEquals(ContactService.contactList.get(Integer.valueOf(contactID)).getContactAddress(), "22425 So. Prairie Rd E.");
		
		//Edit address too long (throw exception)
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			ContactService.contactList.get(Integer.valueOf(contactID)).setContactAddress("This address is going to be way too long simply for test purposes.");
		});
			
		}
	
	@DisplayName("Update Address null") //Req: Address != null
	@Test
	void testUpdateAddressNull() {

		String contactID = "0";
		
		//Checks original address implemented
		assertEquals(ContactService.contactList.get(Integer.valueOf(contactID)).getContactAddress(), "22425 So. Prairie Rd E.");
		
		//Edit address null (throw exception)
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			ContactService.contactList.get(Integer.valueOf(contactID)).setContactAddress(null);
		});
			
		}

}
