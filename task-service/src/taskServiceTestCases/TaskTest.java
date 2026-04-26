/*
 * 	Anthony Baratti
 * 	SNHU CS-330 Software Testing
 *  Professor K. Wilson
 *  9/29/24
 *  
 *  Task Service Application (TaskTest.java)
 *  The purpose of this class is to test the Task.java class
 *  against the requirements of the task object (see Task.java - Task Requirements:)
 *
 */

package taskServiceTestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import taskService.Task;

class TaskTest {
	
	//Tests for correctly constructing task object
	@DisplayName("Correct taskName accepted")
	@Test
	void testCorrectTaskName() { //Correctly constructed task object
		
		String taskID = "0123456789"; //boundary limit (10)
		String taskName = "Not null & under 20."; //Boundary limit (20)
		String taskDescription = "This can't be longer than 50 characters boundary c"; //boundary limit (50)
		
		Task newTask = new Task(taskID, taskName, taskDescription);
		
		//Confirms correctly constructed object
		assertTrue(newTask.getTaskID().equals(Integer.valueOf(taskID)));
		assertTrue(newTask.getTaskName().equals(taskName));
		assertTrue(newTask.getTaskDescription().equals(taskDescription));
	}
	
	/*
	 * This set of tests checks taskID Requirements
	 * Task Req: 1
	 * 
	 * Test 1 taskID too long throws exception
	 * Test 2 taskID null throws exception
	 * NOTE - taskID shall be unique will be tested in TaskServiceTest.java 
	 * 
	 */
	
	@DisplayName("taskID too long")
	@Test
	void testTaskIDTooLong()
	{
		//Tests exception thrown for taskID too long
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			String taskID = "01234567890"; // Test ID boundary limit (11)
			String taskName = "Name under 20"; // Test Name
			String taskDescription = "This can't be longer than 50 characters)"; //Test description
			
			Task newTask = new Task(taskID, taskName, taskDescription);			
		});	
	}
	
	@DisplayName("taskID null")
	@Test
	void testTaskIDNull()
	{
		//Tests exception thrown for taskID null (Req: 1)
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			String taskID = null; //Test ID Null
			String taskName = "Name under 20"; //Test Name
			String taskDescription = "This can't be longer than 50 characters"; //Test Description
			Task newTask = new Task(taskID, taskName, taskDescription);
		});
	}
	
	/*
	 * This set of tests checks taskName Requirements
	 * Task Req: 2
	 * 
	 * Test 1 taskName too long throws exception
	 * Test 2 taskName null throws exception
	 *  
	 */
	
	@DisplayName("taskName too long") 
	@Test
	void testTaskNameTooLong()
	{
		// Tests exception thrown for taskName too long	(Req: 2)
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			String taskID = "0123456789"; //Test ID
			String taskName = "This name is over 20 "; //Test Name boundary limit (21)
			String taskDescription = "This can't be longer than 50 characters"; //Test description
			Task newTask = new Task(taskID, taskName, taskDescription);
		});
	}
	
	@DisplayName("taskName is null")
	@Test
	void testTaskNameNull()
	{
		//Tests exception thrown for taskName null (Req:2)
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			String taskID = "0123456789"; //Test ID
			String taskName = null; //Test Name null
			String taskDescription = "This can't be longer than 50 characters)"; //Test Description
			
			Task newTask = new Task(taskID, taskName, taskDescription);			
		});	
	}
	
	/*
	 * This set of tests checks task description requirements
	 * Task Req: 3
	 * 
	 * Test 1 taskDescription too long throws exception
	 * Test 2 taskDescription null throws exception
	 * 
	 */
	
	@DisplayName("taskDescription too long")
	@Test
	void testTaskDescriptionTooLong()
	{
		//Tests exception thrown for taskDescription too long (Req: 3)
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			String taskID = "0123456789"; //Test ID
			String taskName = "Name under 20"; //Test name
			String taskDescription = "This cant be longer than 50 characters boundary lim"; //Test description boundary limit (51)
			
			Task newTask = new Task(taskID, taskName, taskDescription);			
		});
	}
	
	@DisplayName("taskDescription is null")
	@Test
	void testTaskDescriptionNull()
	{
		//Tests exception thrown for taskDescription null (Req: 3)
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> {
			String taskID = "0123456789"; //Test ID
			String taskName = "Name under 20"; //Test name
			String taskDescription = null; //Test Description Null
			
			Task newTask = new Task(taskID, taskName, taskDescription);			
		});	
	}
}
