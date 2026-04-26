/********************************************
 *	Anthony Baratti
 *	SNHU CS-320 Software Testing
 *	Professor K. Wilson
 *	10/6/24
 *
 *	Appointment Service Application (AppointmentServiceTest.java)
 *	The purpose of this application is to create an appointment object with specified
 *	requirements (see AppointmentService.java). Then attach that object to an Appointment List 
 *	(in memory data structure). Then to test using JUnit testing methods
 *	to ensure that the business requirements are met and are functional.
 * 
 *********************************************/

package appointmentServiceTestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import appointmentService.AppointmentService;

class AppointmentServiceTest {


	@BeforeEach //Sets up appointmentList and populates with first object
	void testSetUp() {
		String apptDate = "2025/10/20"; //Boundary date already tested.
		String apptDescription = "Some description < 50";
		
		AppointmentService testList = new AppointmentService();
		testList.addNewAppointment(apptDate, apptDescription);
	}
	
	@AfterEach //Clears appointmentList
	void testClearList() {
		AppointmentService.appointmentList.clear();
	}
	
	/*
	 *  This test will test 2 aspects of Requirment 1
	 *  It will first add 2 new objects to the testList
	 *  which will show that it can auto-generate Unique IDs.
	 *  Then it will remove an object from the list (at position [1]).
	 *  Once the object is removed, since object @[1] should have ID 1,
	 *  then ID 1 will be recycled and auto-assigned to the next object created.
	 *  Thus, the order of the list should be: [0] = ID 0, [1] = ID 2, and [2] = ID 1 (recycled)
	 *  
	 *  The recycling will ultimately show that the object IDs will remain unique via
	 *  addNewAppointment(String apptDate, String apptDescription) which will call
	 *  validateUniqueID(String apptID) and return a unique ID for all 3 constructor parameters
	 *  
	 *   Pass: Auto generates Unique IDs, recycles IDs as objects are destroyed and created
	 *         Adds object to list with Unique ID (Req: 1)
	 */
	@DisplayName("Add by Unique ID")
	@Test
	void addAppointmentByUniqueID() {
		//@BeforeEach has built the list and populated the first object with unique ID "0"
		AppointmentService testList = new AppointmentService();
		
		// Confirm that the list is populated by 1 object
		assertTrue(AppointmentService.appointmentList.size() == 1);
		
		// Confirm that object at [0] has ID "0"
		assertTrue(AppointmentService.appointmentList.get(0).getAppointmentID() == 0);
		
		//Add two more objects to the list with [1] ID = "1" and [2] ID = "2" (which auto-generate)
		testList.addNewAppointment("2025/10/21", "New Description 1");
		testList.addNewAppointment("2025/10/31", "New Description 2");
		
		// Confirm that the list is populated by 2 new objects
		assertTrue(AppointmentService.appointmentList.size() == 3);
		
		// Confirms that object [1] and [2] have unique IDs "1" and "2" respectively
		assertTrue(AppointmentService.appointmentList.get(1).getAppointmentID() == 1);
		assertTrue(AppointmentService.appointmentList.get(2).getAppointmentID() == 2);
		
		//Removes object @ [1], which will recycle ID "1"
		AppointmentService.appointmentList.remove(1);
		
		// Confirms that object with ID 2 has been moved to [1] on list
		assertTrue(AppointmentService.appointmentList.get(1).getAppointmentID() == 2);
		
		// Add new object, which should re-use ID 1, ensuring that IDs remain Unique
		testList.addNewAppointment("2025/10/25",  "New Description 3");
		
		//Confirms that new object is placed at end of list, with unique ID "1"
		assertTrue(AppointmentService.appointmentList.get(0).getAppointmentID() == 0);
		assertTrue(AppointmentService.appointmentList.get(1).getAppointmentID() == 2);
		assertTrue(AppointmentService.appointmentList.get(2).getAppointmentID() == 1);
	}
	
	/*
	 *  This set of tests will show that Objects are added with Unique IDs
	 *  then are searched for by the Unique ID and deleted from the list (Req:2)
	 *  
	 *   Pass: Create a list of objects, then search for object by ID "1" and remove
	 *         via deleteAppointment() function. Object with ID one is deleted
	 */
	@DisplayName("Delete Appointment by ID")
	@Test
	void deleteAppointmentByUniqueID() {
		//@BeforeEach has built the list and populated the first object with unique ID "0"
		AppointmentService testList = new AppointmentService();
		
		//Add 3 new objects, IDs are auto generated
		testList.addNewAppointment("2025/10/05", "Description 1"); //ID "1"
		testList.addNewAppointment("2025/10/06", "Description 2"); //ID "2"
		testList.addNewAppointment("2026/01/01", "Description 3"); //ID "3"
		
		// Confirms all objects exist with their unique IDs
		assertTrue(AppointmentService.appointmentList.get(0).getAppointmentID() == 0);
		assertTrue(AppointmentService.appointmentList.get(1).getAppointmentID() == 1);
		assertTrue(AppointmentService.appointmentList.get(2).getAppointmentID() == 2);
		assertTrue(AppointmentService.appointmentList.get(3).getAppointmentID() == 3);
		assertTrue(AppointmentService.appointmentList.size() == 4); //shows all 4 exist (and no more)
		
		// Remove object by ID
		testList.deleteAppointment("1"); //Deletes item with ID "1"
		testList.deleteAppointment("3"); //Deletes item with ID "3"
		
		// Confirms appointmentList [0] is ID "0" and [1] is "2" and list only has 2 objects
		// which shows that object with ID "1" and ID "3" have been removed/deleted
		assertTrue(AppointmentService.appointmentList.size() == 2); //List size is now 2
		assertTrue(AppointmentService.appointmentList.get(0).getAppointmentID() == 0);
		assertTrue(AppointmentService.appointmentList.get(1).getAppointmentID() == 2);
	}
}
