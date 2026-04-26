/*
 *   Anthony Baratti
 *   SNHU CS-320 Software Testing
 *   Professor K. Wilson
 *   9/22/2024
 *   Contact Service (ContactTest.java)
 *   
 *   Tests for requirements met in Contact.java
 */

package TestCases;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;

import org.junit.jupiter.api.DisplayName;

class ContactTest {
	
	//Tests that constructor works correctly with proper input
	@DisplayName("Constructor Validation.")
	@Test
	void testConstructorValidation() {
		//Initialize contact object
		Contact newContact = new Contact("Anthony", "Baratti", "0123456789",
				"1234567890", "22425 So. Prairie Rd E.");
		
		//checks contact object attributes
		assertTrue(newContact.getFirstName().equals("Anthony"));
		assertTrue(newContact.getLastName().equals("Baratti"));
		assertTrue(newContact.getContactId().equals(Integer.valueOf("0123456789")));
		assertTrue(newContact.getContactPhone().equals("1234567890"));
		assertTrue(newContact.getContactAddress().equals("22425 So. Prairie Rd E."));
		
	}
	
	/*
	 * This block of tests will initialize first name with
	 * first name > 10
	 * first name = null
	 * 
	 * Requirement 2: First name shall not be null and shall not be greater than 10 char
	 * 
	 * Passing tests will show exception thrown
	 * Updating first name tests are found in ContactServiceTest.java
	 */
	
	@DisplayName("Initialize first name length too long Exception") //Requirement: First Name <= 10 Char
	@Test
	void testInitializeFirstNameTooLong() {
		//Exception thrown if first name greater than 10 char long
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			//Initialize firstName = "AnthonyJohn" (too long, boundary limit of 11)
			Contact newContact = new Contact("AnthonyJohn", "Baratti", "1",
					"1234567890", "22425 So. Prairie Rd. E.");
			});
	}
	
	@DisplayName("Initialize first name null Exception") //Requirement: First Name != null
	@Test
	void testInitializeFirstNameNull() {
		//Exception thrown if first name null
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			//Initialize firstName = null
			Contact newContact = new Contact(null, "Baratti", "1",
					"1234567890", "22425 So. Prairie Rd. E.");
			});
	}
	
	/*
	 * This block of tests will initiliaze last name with
	 * last name > 10
	 * last name = null
	 * 
	 * Requirement 3: Last name shall not be null and shall not be greater than 10
	 * Passing tests will show exception thrown
	 * Updating first name tests are found in ContactServiceTest.java
	 */
	
	@DisplayName("Initialize last name length too long Exception") //Requirement: Last Name <= 10 Char
	@Test
	void testLastNameTooLong() {
		//Exception thrown if last name greater than 10 long
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			String firstName = "Anthony";
			String lastName = "AnthonyJohn"; // Last name too long (boundary of 11)
			String contactID = "1";
			String contactPhone = "1234567890";
			String contactAddress = "22425 So. Prairie Rd. E.";
			Contact newContact = new Contact(firstName, lastName, contactID,
					contactPhone, contactAddress ); //Exception: Last Name > 10
			});
	}
	
	@DisplayName("Initialize last name null Exception") //Requirement: Last Name != null
	@Test
	void testLastNameNull() {
		//Exception thrown if last name null
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			//set last name null
			Contact newContact = new Contact("Anthony", null, "1",
					"1234567890", "22425 So. Prairie Rd. E."); //Exception: Last Name = null
			});
	}
	/*
	 *  This set of tests will initialize Contact Object with
	 *  
	 *  Requirement 1: Contact ID shall not be null and shall not be greater than 10 char
	 *  
	 *  contactID > 10
	 *  contactID = null
	 */
	@DisplayName("Contact ID too long") //Req: Contact ID <= 10
	@Test
	void testContactIDTooLong() {
		//Exception thrown if contactID is greater than 10 long
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			//contactID too long (boundary limit of 11)
			Contact newContact = new Contact("Anthony", "Baratti", "12345678901",
					"1234567890", "22425 So. Prairie Rd. E.");
		});
	}
	
	@DisplayName("Contact ID is null") //Req: Contact ID != null
	@Test
	void testContactIDNull() {
		//Exception thrown if contactID is null
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			//contactID is null
			Contact newContact = new Contact("Anthony", "Baratti", null,
					"1234567890", "22425 So. Prairie Rd. E.");
		});
	}

	/*
	 * This set of tests will initialize a Contact Object
	 * phone number intiliazed to boundary limits ( 9 < 10 & 11 > 10)
	 * phone number initialized to all digits
	 * phone number initialized to null
	 * 
	 * Requirement 4: Phone number shall not be null and shall be exactly 10 digits
	 * 
	 * Passing tests will show exception thrown
	 * Updating phone number tests found in ContactServiceTest.java
	 */
	@DisplayName("Phone number is 10 long") //Req: Phone number == 10 length
	@Test
	void testPhoneNumberExactlyTenLong() {
		//Exception thrown for 11 and over char
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			//Set phone number to 11 digits
			Contact newContact = new Contact("Anthony", "Baratti", "1",
					"12345678901", "22425 So. Prairie Rd. E.");
		});
		
		//Exception thrown for 9 and under char
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			//set phone number to 9 digits
			Contact newContact = new Contact("Anthony", "Baratti", "1",
					"123456789", "22425 So. Prairie Rd. E.");
		});
	}
	
	@DisplayName("Phone number is null") //Req: Phone number != null
	@Test
	void testPhoneNumberNull() {
		//Exception thrown if phone number is null
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			//set phone number to null
			Contact newContact = new Contact("Anthony", "Baratti", "1",
					null, "22425 So. Prairie Rd. E.");
		});
		
	}
	
	@DisplayName("Phone number is digits") //Req: Phone number must be digits
	@Test
	void testPhoneNumberDigits() {
		//Exception thrown if phone number is not all digits
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			//set phone number to exactly 10 char, but has "abc" (not digits)
			Contact newContact = new Contact("Anthony", "Baratti", "1",
					"253abc4141", "22425 So. Prairie Rd. E.");
		});
	}
	/*
	 * This set of tests will initialize a contact object with
	 * Address too long 
	 * Address null
	 * 
	 *  Requirement 5: Address shall not be null and address shall not be greater than 30
	 * 
	 *  Passing tests will show exceptions thrown
	 *  Updating address tests found in ContactServiceTest.java
	 */
	@DisplayName("Address is too long") //Req: Address <= 30 char
	@Test
	void testAddressTooLong() {
		//Exception thrown if address is too long
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			//Set address too long
			Contact newContact = new Contact("Anthony", "Baratti", "0123456789",
					"1234567890", "22425 So. Prairie Rd E., Seattle WA. 98391");
	});
	}
	
	@DisplayName("Address is null") //Req: Address != null
	@Test
	void testAddressNull() {
		//Exception thrown if address is null
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			//Set address to null
			Contact newContact = new Contact("Anthony", "Baratti", "0123456789",
					"1234567890", null);
		});
	}
}
