/*
 *		Anthony Baratti
 *		SNHU CS-330 Software Testing
 *		Professor K. Wilson
 *		9/29/24
 *
 * 		Task Service Application (Task.java)
 * 		The purpose of this application is to create task objects
 * 		and a Task Service to create and add those objects to a data structure
 * 		then test those objects and services for meeting requirements.
 *      The requirements are as follows:
 *      Task object Requirements:
 *      1. The task object shall have a required unique task ID String that cannot
 *         be longer than 10 characters. The ID shall not be null and shall not be
 *         updateable
 *      2. The task object shall have a required String name field that cannot be longer
 *         than 20 characters. The name field shall not be null
 *      3. The task object shall have a required String description field that cannot be longer
 *         than 50 characters. The description field shall not be null
 *      Task Service Requirements: (See TaskService.java).
 */

package taskService;

public class Task {
	
	//Define attributes and constructors
	private String taskName;
	private String taskDescription;
	private String taskID;
	
	//Default constructor
	public Task() {
		
	}
	
	/*
	 * Task object constructor
	 * Will use private methods to validate requirements of parameters
	 * passed to constructor before creating object
	 * 
	 * If parameters fail requirements, exception is thrown.
	 * 
	 * @param: taskID, taskName, taskDescription
	 */
	
	public Task(String taskID, String taskName, String taskDescription) {
		
		// validates then sets taskID or throws exception
		validateTaskID(taskID);
		this.taskID = taskID;
		
		// validates then sets taskName or throws exception
		validateTaskName(taskName);
		this.taskName = taskName;
		
		// validates then sets taskDescription or throws exception
		validateTaskDescription(taskDescription);
		this.taskDescription = taskDescription;
		
	}
	
	/*
	 *  This method is designed to check the taskID requirements (see requirements: 1)
	 *  to ensure that taskID is neither null nor greater than 10 characters
	 *  Throws an IllegalArgumentException if requirements not met.
	 *  
	 *  @param: taskID
	 *  @return: taskID
	 */
	private String validateTaskID(String taskID) {
		if ((taskID == null) || (taskID.length() > 10)) {
			throw new IllegalArgumentException("Invalid task ID."); //ID is null or longer than 10 char
		}
		
		return taskID;
	}
	

	/*
	 * This method is designed to check the taskName requirements (see requirements: 2)
	 * to ensure that taskName is neither null nor greater than 20 characters
	 * Throws an IllegalArgumentException if requirements not met.
	 * 
	 * @param: taskName
	 * @return: taskName
	 */
	private String validateTaskName(String taskName) {
		if ((taskName == null) || (taskName.length() > 20)) { //Name is null or longer than 20 char
			throw new IllegalArgumentException("Invalid task name.");
		}
		return taskName;
	}
	
	/*
	 * This method is designed to check the taskDescription requirements (see requirements: 2)
	 * to ensure that taskDescription is neither null nor greater than 50 characters
	 * Throws an IllegalArgumentException if requirements not met.
	 * 
	 * @param: taskDescription
	 * @return: taskDescription
	 */
	private String validateTaskDescription(String taskDescription) {
		if ((taskDescription == null) || (taskDescription.length() > 50)) {
			throw new IllegalArgumentException("Invalid task description.");
		}
		return taskDescription;
	}
	
	//setters (used for updating fields Req: 3). Each one calls validate<Attribute>(attribute)
	// @param attribute
	public void setTaskName(String taskName) {
		validateTaskName(taskName); //validates requirements
		this.taskName = taskName; //updates if requirements met
	}
	
	public void setTaskDescription(String taskDescription) {
		validateTaskDescription(taskDescription); //validates requirements
		this.taskDescription = taskDescription; //updates if requirements met
	}
	
	//getters 
	// @return attribute
	public Integer getTaskID() {
		return Integer.valueOf(taskID);
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
}
