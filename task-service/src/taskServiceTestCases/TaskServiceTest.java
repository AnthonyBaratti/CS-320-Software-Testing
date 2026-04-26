package taskServiceTestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import taskService.TaskService;

class TaskServiceTest {

	/*  Method implemented before each test to initialize a testList
	 *  and populate it with the first object
	 */
	@BeforeEach
	void setUpTaskObject() {
		String taskName = "This task name < 20";
		String taskDescription = "This task description < 50";
	 
		TaskService testList = new TaskService();
		testList.addNewTask(taskName,  taskDescription);
 }
	
	//Method to remove all objects from testList after every test (reset)
	@AfterEach
	void deleteTestList() {
		TaskService.taskList.clear();
		
	}
	
	//Tests addNewTask() function to add task object to list with Unique ID (Req: 1)
	@DisplayName("Add Task to List")
	@Test
	void addTaskObjectToTaskList() {
		TaskService testList = new TaskService();
		//adds two objects to list
		testList.addNewTask("Task Name 1", "Task Description 1");
		testList.addNewTask("Task Name 2", "Task Description 2");
		
		//Ensures new task objects are added to list
		assertTrue(TaskService.taskList.size() == 3);
		
		//Checks attributes of first added object
		assertTrue(TaskService.taskList.get(0).getTaskName() == "This task name < 20");
		assertTrue(TaskService.taskList.get(0).getTaskID() == Integer.valueOf("0"));
		assertTrue(TaskService.taskList.get(0).getTaskDescription() == "This task description < 50");
		
		//Checks attributes of second added object
		assertTrue(TaskService.taskList.get(1).getTaskName() == "Task Name 1");
		assertTrue(TaskService.taskList.get(1).getTaskID() == Integer.valueOf("1"));
		assertTrue(TaskService.taskList.get(1).getTaskDescription() == "Task Description 1");
		
		//Checks attributes of third added object
		assertTrue(TaskService.taskList.get(2).getTaskName() == "Task Name 2");
		assertTrue(TaskService.taskList.get(2).getTaskID() == Integer.valueOf("2"));
		assertTrue(TaskService.taskList.get(2).getTaskDescription() == "Task Description 2");
		
	}
	
	//Tests deleteTask() function with taskID (Req: 2)
	@DisplayName("Delete Task from List")
	@Test
	void testDeleteTaskFromList() {
		
		TaskService testList = new TaskService();
		
		//adds two objects to list
		testList.addNewTask("Task Name 1", "Task Description 1");
		testList.addNewTask("Task Name 2", "Task Description 2");
		
		//Ensures new task objects are added to list
		assertTrue(TaskService.taskList.size() == 3);
		
		//calls deleteTask() with parameter taskID
		testList.deleteTask("0");
		
		//Ensures object has been removed from list
		assertTrue(TaskService.taskList.size() == 2);
		
		//Ensures Object with ID 0 was removed (front of list)
		assertTrue(TaskService.taskList.get(0).getTaskID() == Integer.valueOf("1"));
		assertTrue(TaskService.taskList.get(1).getTaskID() == Integer.valueOf("2"));
		
	}
	
	//Tests unique ID generation (Req: 1)
	@DisplayName("Unique ID")
	@Test
	void testUniqueID() {
		/*
		 *  This block of codes adds 3 users with ID 0, 1, and 2,
		 *  then deletes object at testList[0] from the front (taskID 0).
		 *  This frees up ID 0, and should assign a new object
		 *  into testList[2] with taskID = 0
		 */
		TaskService testList = new TaskService();
		//adds two objects to list
		testList.addNewTask("Task Name 1", "Task Description 1");
		testList.addNewTask("Task Name 2", "Task Description 2");
		
		//Ensures new task objects are added to list
		assertTrue(TaskService.taskList.size() == 3);
		
		//calls deleteTask with parameter taskID
		testList.deleteTask("0");
		
		//Ensures object has been removed from list
		assertTrue(TaskService.taskList.size() == 2);
		
		//Ensures Object with ID 0 was removed (front of list)
		//Also ensures new objects got a Unique ID via validateUniqueID() in TaskService.java
		assertTrue(TaskService.taskList.get(0).getTaskID() == Integer.valueOf("1"));
		assertTrue(TaskService.taskList.get(1).getTaskID() == Integer.valueOf("2"));
		
		//add new task, which gets reassigned unique ID 0 (recycled after deleted)
		testList.addNewTask("This name < 20",  "This description < 50");
		
		//checks object at taskList[3] got a unique ID
		assertTrue(TaskService.taskList.get(2).getTaskID() == Integer.valueOf("0"));
		
	}
	
	//tests task name update (Req: 3)
	// Pass: Finds object in list by unique ID and updates name
	@DisplayName("Update Name")
	@Test
	void testUpdateName() {
		//Checks current name of added object testList[0]
		assertTrue(TaskService.taskList.get(0).getTaskName() == "This task name < 20");
		
		//Sets new task name
		String newTaskName = "New task name < 20"; //test name update
		String taskID = "0"; //test ID for list object [0]
		//Finds task by Unique ID and updates name via editTaskName() (Req: 3)
		TaskService.editTaskName(newTaskName, taskID); 
		
		// Confirms the object was found by unique ID and name was updated (PASS)
		assertTrue(TaskService.taskList.get(0).getTaskName() == newTaskName);
		
		/*
		 * Because validateTaskName is called in both the constructor
		 * and the setTaskName() function (which is nested within editTaskName() to update task name)
		 * the validateTaskName function has been tested against null and too long requirements
		 * (See TaskTest.java).
		 * 
		 * This validateTaskName() function will throw exceptions whether
		 * upon instantiation or editing
		 *  
		 */
	}
	
	//Tests update task description (Req: 3)
	//Pass: finds object in list by unique ID and updates description
	@DisplayName("Update Description")
	@Test
	void testUpdateDescription() {
		//Checks current description of object added to testList[0]
		assertTrue(TaskService.taskList.get(0).getTaskDescription() == "This task description < 50");
		
		//New task description
		String newTaskDescription = "New task description < 50"; //test description update
		String taskID = "0"; //test ID
		
		// Finds task by unique ID and edits description via editTaskDescription() (Req: 3)
		TaskService.editTaskDescription(newTaskDescription, taskID);
		
		// Confirms the object was found by unique ID and the task description was updated (PASS)
		assertTrue(TaskService.taskList.get(0).getTaskDescription() == newTaskDescription);
		
		/*
		 * Because validateTaskDescription is called in both the constructor
		 * and the setTaskDescription() function, the validateTaskDescription
		 * function has been tested against null and too long requirements
		 * (See TaskTest.java).
		 * 
		 * This validateTaskDescription() function will throw exceptions whether
		 * upon instantiation or editing
		 *  
		 */
		
	}
}
