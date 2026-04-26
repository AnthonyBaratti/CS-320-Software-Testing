/*
 *  Anthony Baratti
 *  SNHU CS-330 Software Testing
 *  Professor K. Wilson
 *  9/29/24
 *  
 *  Task Service Application (TaskService.java)
 *  Task Object Requirements: (See Task.java)
 *  Task Service Requirements:
 *  
 *  1. The Task Service shall be able to add tasks with Unique ID
 *  2. The Task Service shall be able to delete tasks per ID
 *  3. The Task Service SHall be able to update task fields per task ID.
 *     The following fields are updatable:
 *      -Name
 *      -Description
 *
 */


package taskService;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
	
	public static List<Task> taskList = new ArrayList<Task>(); //creates data structure to hold task objects (no database)

	/*
	 * This function is called from addNewTask which will take
	 * the taskID and check to see if it exists on any task object
	 * in taskList. If it finds a match, it increments and tries again
	 * Task Service Req: 1
	 * 
	 *  @param: String taskID
	 *  @return: taskID
	 */
	private static String validateUniqueID(String taskID) {
		Integer newIDNum = Integer.valueOf(taskID);
		//for loop to check ID for matches, ensuring a unique ID is found.
		for (int i = 0; i < taskList.size(); ++i) {
			if (newIDNum == taskList.get(i).getTaskID()) {
				newIDNum = newIDNum + 1; //If ID is in list, increment and loop again
			}
		}
		taskID = String.valueOf(newIDNum); //Sets unique ID
		return taskID; //returns unique ID
	}
	/*
	 *  addNewTask is a method that takes a task name and description
	 *  then assigns it a unique ID via validateUniqueID().
	 *  Then it creates a new task object and attaches all 3 attributes
	 *  before adding it to taskList
	 *  Task Service Req: 1
	 *  
	 *   @param: String taskName, String taskDescription
	 */
	public void addNewTask(String taskName, String taskDescription) {
		
		String newID = validateUniqueID("0"); //This ID will be changed via validateUniqueID()
		Task newTask = new Task(newID, taskName, taskDescription);
		
		taskList.add(newTask);
	}
	/*
	 *  This method will use taskID to find a task object
	 *  then remove it from the list 
	 *  Task Service Req: 2
	 *  
	 *  @param: String taskID
	 */
	public void deleteTask(String taskID) {
		for (int i=0; i < taskList.size(); ++i) {
			if (taskList.get(i).getTaskID() == Integer.valueOf(taskID)) {
				taskList.remove(i);
			}
		}
		
	}
	/*
	 *  This method is used to update task name
	 *  It will find the task object by taskID number
	 *  then call setTaskName in Task.java which will
	 *  validate that the task name meets the other requirements 
	 *  Task Service Req: 3
	 *  
	 *  @param: String taskName, String taskID
	 */
	public static void editTaskName(String taskName, String taskID) {
		for (int i=0; i < taskList.size(); ++i) {
			//finds task object by unique ID
			if (taskList.get(i).getTaskID() == Integer.valueOf(taskID)) {
				taskList.get(i).setTaskName(taskName);
			}
		}
	}
	/*
	 *  This method is used to update task description
	 *  It will find the task object by taskID number
	 *  then call setTaskDescription in Task.java which will
	 *  validate that the task description meets the other requirements
	 *  Task Service Req: 3
	 *  
	 *  @param: String taskDescription, String taskID
	 */
	public static void editTaskDescription(String taskDescription, String taskID) {
		for (int i = 0; i < taskList.size(); ++i) {
			//finds task object by unique ID
			if (taskList.get(i).getTaskID() == Integer.valueOf(taskID)) {
				taskList.get(i).setTaskDescription(taskDescription);
			}
		}
	}
	
}
