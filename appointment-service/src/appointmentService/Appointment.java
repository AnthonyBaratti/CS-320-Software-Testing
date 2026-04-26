/********************************************
 *	Anthony Baratti
 *	SNHU CS-320 Software Testing
 *	Professor K. Wilson
 *	10/6/24
 *
 *	Appointment Service Application (Appointment.java)
 *	The purpose of this application is to create an appointment object with specified
 *	requirements (listed below). Then attach that object to an Appointment List 
 *	(in memory data structure). Then to test using JUnit testing methods
 *	to ensure that the business requirements are met and are functional.
 *
 *	Appointment Class Requirements:
 *	1. The appointment object shall have a required unique appointment ID
 *	string that cannot be longer than 10 characters. The appointment ID
 *	shall not be null and shall not be updatable.
 *
 *	2. The appointment object shall have a required appointment Date field
 *	The appointment date field cannot be in the past. The appointment
 *	Date field shall not be null.
 *
 *	3. The appointment object shall have a required description String
 *	field that cannot be longer than 50 characters and shall not be null.
 * 
 *********************************************/
package appointmentService;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Appointment {

	private  String apptID = "0";
	private  String apptDate = "2100/12/05"; //Format yyyy/MM/dd
	private String apptDescription = "Describe me";
	
	//Default constructor
	public Appointment() {
		
	}

	/*
	 *  Overloaded Appointment object constructor.
	 *  Uses methods to validate each parameter value as per
	 *  requirements.
	 * 
	 *  @param: String apptID, String apptDate, String apptDescription
	 */
	public Appointment(String apptID, String apptDate, String apptDescription) {
		validateID(apptID); //Req 1
		this.apptID = apptID;
		
		validateDate(apptDate); //Req 2
		this.apptDate = apptDate;
		
		validateDescription(apptDescription); //Req 3
		this.apptDescription = apptDescription;
	}
	
	// Validates Appointment ID: Requirement 1
	//
	// @param String apptID
	// @return apptID
	private String validateID(String apptID) {
		if ((apptID == null) || (apptID.length() > 10)){
			throw new IllegalArgumentException("Invalid ID");
		}
		return apptID;
	}
	
	// Validates Appointment Date: Requirement 2
	//
	// @param String apptDate
	// @return apptDate
	private String validateDate(String apptDate) {
		
		//Set format for string entry
		if(apptDate == null) {
			throw new IllegalArgumentException("Invalid date");
		}
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		//Set dateRequest variable with parsed string apptDate
		LocalDate dateRequest = LocalDate.parse(apptDate, dateFormatter);
		
		//Instance of todays date
		LocalDate compareToDate = LocalDate.now();
		
		/*
		 * Reference:
		 * StackOverFlow.com, (2021). How to resolve Unparseable date exception
		 *    in Java 8 with date format yyyy-MM-dd hh::mm a. StackOverFlow.com. 
		 *    https://stackoverflow.com/questions/64634652/how-to-resolve-unparseable-date-exception-in-java-8-with-date-format-yyyy-mm-dd
		 */
		
		//Checks for date in the past
		if(dateRequest.isBefore(compareToDate)) {
			throw new IllegalArgumentException("Invalid date (past date");
		}
		
		/*
		 * Reference:
		 * Geeksforgeeks.org, (2022). Compare dates in Java. GeeksforGeeks.org
		 *    https://www.geeksforgeeks.org/compare-dates-in-java/ 
		 */
		return apptDate;
	}
	
	// Validates Appointment Description: Requirement 3
	//
	// @param String apptDescription
	// @return apptDescription
	private String validateDescription(String apptDescription) {
		if ((apptDescription == null) || apptDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		return apptDescription;
	}


	
	// retrievable appointment object ID: AppointmentService Req 2
	// @return apptID
	public Integer getAppointmentID() {
		return Integer.valueOf(apptID);
	}
	
	// get appointment date
	// @return apptDate
	public String getAppointmentDate() {
		return apptDate;
	}
	
	// get appointment description
	// @return apptDescription
	public  String getAppointmentDescription() {
		return apptDescription;
	}
}
