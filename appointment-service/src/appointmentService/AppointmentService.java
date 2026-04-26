/********************************************
 *	Anthony Baratti
 *	SNHU CS-320 Software Testing
 *	Professor K. Wilson
 *	10/6/24
 *
 *	Appointment Service Application (AppointmentService.java)
 *	The purpose of this application is to create an appointment object with specified
 *	requirements (listed below). Then attach that object to an Appointment List 
 *	(in memory data structure). Then to test using JUnit testing methods
 *	to ensure that the business requirements are met and are functional.
 *
 *	Appointment Service Requirements:
 *	1. The appointment service shall be able to add appointments with
 *	unique appointment ID
 *
 *	2. The appointment service shall be able to delete appointments
 *	per appointment ID.
 * 
 *********************************************/


package appointmentService;


import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

	// Initializes list to store appointment objects. Req: 1
	public static List<Appointment> appointmentList = new ArrayList<Appointment>();
	
	/*
	 * This function is created to generate a unique ID 
	 * Appointment Req: 1
	 * It checks the list of current appointments and checks their IDs
	 * If a match is found, it increments the ID by 1 until a match is not found
	 * This method is called from addNewAppointment method, and passed the 
	 * String parameter of "0", a generic starting point.
	 * 
	 *  @param apptID
	 *  @return apptID
	 */
	
	private String validateUniqueID(String apptID) {
		Integer newApptID = Integer.valueOf(apptID);
		// for loop to check ID against existing IDs
		for (int i = 0; i < appointmentList.size(); ++i) {
			if (appointmentList.get(i).getAppointmentID() == newApptID) {
				newApptID = newApptID +1;
			}
		}
		return String.valueOf(newApptID);
	}
	
	/*
	 *  This method is designed to add a new appointment to the appointment list
	 *  It will call validateUniqueID, and pass String "0" as the argument
	 *  validateUniqueID() will return a unique ID, then the appointment object
	 *  will be created and added to the appointmentList
	 *  
	 *  @param: String apptDate, String apptDescription
	 * 
	 */
	
	public void addNewAppointment(String apptDate, String apptDescription)  {
		//Passes generic ID, returns unique ID
		String apptID = validateUniqueID("0");
		
		//Passes parameters to Appointment constructor which will validate
		Appointment newAppointment = new Appointment(apptID, apptDate, apptDescription);
		appointmentList.add(newAppointment); //adds appointment object to list
		
	}
	
	public void deleteAppointment(String apptID) {
		for (int i = 0; i < appointmentList.size(); ++i) {
			if (appointmentList.get(i).getAppointmentID() == Integer.valueOf(apptID)) {
				appointmentList.remove(i);
			}
		}
	}
	
	/*
	 *  NOTE: The requirements of the Appointment Service do not
	 *  state that there are any fields that need to be updated,
	 *  so editParameter functions are not designed.
	 */
}
