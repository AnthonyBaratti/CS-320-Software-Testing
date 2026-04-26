/********************************************
 *	Anthony Baratti
 *	SNHU CS-320 Software Testing
 *	Professor K. Wilson
 *	10/6/24
 *
 *	Appointment Service Application (AppointmentTest.java)
 *	The purpose of this application is to create an appointment object with specified
 *	requirements (see Appointment.java). Then attach that object to an Appointment List 
 *	(in memory data structure). Then to test using JUnit testing methods
 *	to ensure that the business requirements are met and are functional.
 * 
 *********************************************/

package appointmentServiceTestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;

class AppointmentTest {
	
	// Pass: No exceptions thrown for all acceptable parameters
	@DisplayName("Correct Appointment Object")
	@Test
	void testCorrectAppointment() {
	
		String apptID = "0123456789"; //boundary of 10
		String apptDate = "2025/10/20"; //boundary same day (Was tested on 10/05 with 10/05, changed to continue testing on future dates
		String apptDescription = "this description must be less than 50 characters!!"; //boundary of 50
		
		//create object with correct parameters
		Appointment newAppointment = new Appointment(apptID, apptDate, apptDescription);
		
		// assert true that all parameters are accepted
		assertTrue(newAppointment.getAppointmentID().equals(Integer.valueOf(apptID)));
		assertTrue(newAppointment.getAppointmentDate().equals(apptDate));
		assertTrue(newAppointment.getAppointmentDescription().equals(apptDescription));
	}
	
	//Pass: exception thrown for ID too long
	@DisplayName("ID too long") //Req: 1
	@Test
	void testIDTooLong() {
		
		//Passes if exception thrown for ID too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			String apptID = "01234567890"; //boundary of 11 (Too long) Req: 1
			String apptDate = "2025/10/20"; //Boundary date of 2024/10/05 was tested, but for turn in purposes, date was adjusted.
			String apptDescription = "this description must be less than 50 characters!!"; //boundary of 50
			
			//Initialize object with ID too long
			Appointment newAppointment = new Appointment(apptID, apptDate, apptDescription);
		});
	}
	
	//Pass: exception thrown for null ID
	@DisplayName("ID is Null") //Req: 1
	@Test
	void testIDIsNull() {
		
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			String apptID = null;  //Req: 1
			String apptDate = "2025/10/20";
			String apptDescription = "A description"; 
			
			//Initialize object with null ID
			Appointment newAppointment = new Appointment(apptID, apptDate, apptDescription);
		});
	}
	
	//NOTE All date tests were run on 10/05/2024 (which sets compared to to 10/05)
	
	//Pass: exception thrown for date in the past	
	@DisplayName("Appointment Date In Past") //Req: 2
	@Test
	void testAppointmentDateInPast() {
		

		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			String apptID = "0123456789" ;
			String apptDate = "2024/10/04"; //boundary date, current date -1 (Req: 2)
			String apptDescription = "A description"; 
			
			//Initialize object with date in the past
			Appointment newAppointment = new Appointment(apptID, apptDate, apptDescription);
		});
	}
	
	//Pass: exception thrown for null date	
	@DisplayName("Appointment Date is Null") //Req: 2
	@Test
	void testAppointmentDateNull() {
		
		//Passes if exception thrown for null date
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			String apptID = "0123456789"; 
			String apptDate = null;
			String apptDescription = "A description"; 
			
			//Initialize object with null date
			Appointment newAppointment = new Appointment(apptID, apptDate, apptDescription);
		});
	}
	
	//Pass: exception thrown for description too long
	@DisplayName("Description too long") //Req 3
	@Test
	void testDescriptionTooLong() {
		String apptID = "0123456789"; 
		String apptDate = "2025/10/20";
		String apptDescription = "this description is going to be just over 50 long!!"; //boundary 51 
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> { 		
			Appointment newAppointment = new Appointment(apptID, apptDate, apptDescription);
		});
	}
	
	//Pass: Exception thrown for null description
	@DisplayName("Null description") //Req: 3
	@Test
	void testNullDescription() {
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			String apptID = "0123456789"; 
			String apptDate = "2025/10/20";
			String apptDescription = null; 
			
			//Initialize object with null description
			Appointment newAppointment = new Appointment(apptID, apptDate, apptDescription);
		});
	}

}
